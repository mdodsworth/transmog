package com.transmog.model;

import java.math.BigDecimal;

/**
 * @author mdodsworth
 */
public interface Unit<T> {

    Category getCategory();

    BigDecimal convert(BigDecimal inputValue, T inputUnit);
}
