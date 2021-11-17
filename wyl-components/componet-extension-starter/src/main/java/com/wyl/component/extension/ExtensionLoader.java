package com.wyl.component.extension;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 扩展点加载器
 *
 * @author wyl
 * @since 2021-11-17 16:45:49
 */
public class ExtensionLoader<T> {

    private static final Pattern NAME_SEPARATOR = Pattern.compile("\\s*[,]+\\s*");

    //扩展接口
    private final Class<?> type;
    //扩展加载器集合，key为扩展接口，value为接口对应的扩展加载器
    private static final ConcurrentMap<Class<?>, ExtensionLoader<?>> EXTENSION_LOADERS = new ConcurrentHashMap<Class<?>, ExtensionLoader<?>>();

    //缓存的默认扩展名，就是@SPI中设置的值
    private String cachedDefaultName;
    private final ConcurrentMap<String, Holder<Object>> cachedInstances = new ConcurrentHashMap<String, Holder<Object>>();
    //缓存的扩展实现类集合
    private final Holder<Map<String, Class<?>>> cachedClasses = new Holder<Map<String, Class<?>>>();

    private ExtensionLoader(Class<?> type) {
        this.type = type;
    }

    /**
     * 判断接口类上面是否有@SPI注解
     *
     * @param type
     * @param <T>
     * @return
     */
    private static <T> boolean withExtensionAnnotation(Class<T> type) {
        return type.isAnnotationPresent(SPI.class);
    }

    public static <T> ExtensionLoader<T> getExtensionLoader(Class<T> type) {
        //扩展点接口为空，抛出异常
        if (type == null) {
            throw new IllegalArgumentException("Extension type == null");
        }
        //判断type是否是一个接口类
        if (!type.isInterface()) {
            throw new IllegalArgumentException("Extension type(" + type + ") is not interface!");
        }
        //判断是否为可扩展的接口
        if (!withExtensionAnnotation(type)) {
            throw new IllegalArgumentException("Extension type(" + type +
                    ") is not extension, because WITHOUT @" + SPI.class.getSimpleName() + " Annotation!");
        }

        //从扩展加载器集合中取出扩展接口对应的扩展加载器
        return (ExtensionLoader<T>) EXTENSION_LOADERS.computeIfAbsent(type, key -> new ExtensionLoader<T>(key));
    }

    public T getDefaultExtension() {
        //获得扩展实现类数组
        getExtensionClasses();
        if (null == cachedDefaultName || cachedDefaultName.length() == 0
                || "true".equals(cachedDefaultName)) {
            throw new IllegalStateException("no default extension on extension " + type.getName());
        }
        return getExtension(cachedDefaultName);
    }

    public T getExtension(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("Extension name == null");
        }
        //缓存中获取对应的扩展对象
        Holder<Object> holder = cachedInstances.computeIfAbsent(name, key -> new Holder<Object>());
        Object instance = holder.get();
        if (instance == null) {
            synchronized (holder) {
                instance = holder.get();
                if (instance == null) {
                    //通过扩展名创建接口实现类的对象
                    instance = createExtension(name);
                    //把创建的扩展对象放入缓存
                    holder.set(instance);
                }
            }
        }
        return (T) instance;
    }

    private T createExtension(String name) {
        //获得扩展名对应的扩展实现类
        Class<?> clazz = getExtensionClasses().get(name);
        if (clazz == null) {
            throw new IllegalStateException("No such extension \"" + name + "\" for " + type.getName() + "!");
        }
        return (T) ObjectFactory.getBean(clazz);
    }


    /**
     * 加载拓展实现类数组
     *
     * @return
     */
    private Map<String, Class<?>> getExtensionClasses() {
        Map<String, Class<?>> classes = cachedClasses.get();
        if (classes == null) {
            synchronized (cachedClasses) {
                classes = cachedClasses.get();
                if (classes == null) {
                    classes = loadExtensionClasses();
                    cachedClasses.set(classes);
                }
            }
        }
        return classes;
    }

    private Map<String, Class<?>> loadExtensionClasses() {
        final SPI defaultAnnotation = type.getAnnotation(SPI.class);
        if (defaultAnnotation != null) {
            //@SPI内的默认值
            String value = defaultAnnotation.value();
            if ((value = value.trim()).length() > 0) {
                String[] names = NAME_SEPARATOR.split(value);
                //只允许有一个默认值
                if (names.length > 1) {
                    throw new IllegalStateException("more than 1 default extension name on extension " + type.getName()
                            + ": " + Arrays.toString(names));
                }
                if (names.length == 1) cachedDefaultName = names[0];
            }
        }
        Map<String, T> classes = (Map<String, T>) ObjectFactory.getBeansOfType(type);
        if (!CollectionUtils.isEmpty(classes)) {
            return classes.entrySet().stream()
                    .filter(entry -> entry.getValue().getClass().isAnnotationPresent(Extension.class))
                    .collect(Collectors.toMap(entry -> {
                        String extenValue = entry.getValue().getClass().getAnnotation(Extension.class).value();
                        if (extenValue == null || extenValue.length() == 0) {
                            extenValue = entry.getKey();
                        }
                        return extenValue;
                    }, entry -> entry.getValue().getClass()));

        }
        return null;
    }

}
