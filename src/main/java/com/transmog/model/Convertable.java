package com.transmog.model;

import java.math.BigDecimal;

/**
 * @author mdodsworth
 */
public interface Convertable<T> {
    BigDecimal convert(long value, T unit);
}
