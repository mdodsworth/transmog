package com.transmog.model;

/**
 * @author mdodsworth
 */
public interface Convertable<T> {
    Measure<T> convert(Measure<T> inputValue);
}
