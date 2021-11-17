package com.wyl.component.extension;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 扩展点加载器
 *
 * @author wyl
 * @since 2021-11-17 16:45:49
 */
public class ExtensionLoader<T> {

    //扩展接口
    private final Class<?> type;
    //扩展加载器集合，key为扩展接口，value为接口对应的扩展加载器
    private static final ConcurrentMap<Class<?>, ExtensionLoader<?>> EXTENSION_LOADERS = new ConcurrentHashMap<Class<?>, ExtensionLoader<?>>();

    //缓存的默认扩展名，就是@SPI中设置的值
    private String cachedDefaultName;
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
            return null;
        }
        return getExtension(cachedDefaultName);
    }

    public T getExtension(String name) {
    }

    //获得扩展实现类数组，把扩展实现类放到cachedClasses中
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

    /**
     * 加载拓展实现类数组
     *
     * @return
     */
    private Map<String, Class<?>> loadExtensionClasses() {
        return (Map<String, Class<?>>) ObjectFactory.getBeansOfType(type);
    }

}
