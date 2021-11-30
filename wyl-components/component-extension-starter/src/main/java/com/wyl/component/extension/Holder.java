package com.wyl.component.extension;

/**
 * @author wyl
 * @since 2021-11-17 17:07:09
 */
public class Holder<T> {

    private volatile T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

}
