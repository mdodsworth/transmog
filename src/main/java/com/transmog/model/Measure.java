package com.transmog.model;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;
import java.math.BigDecimal;

/**
 * @author mdodsworth
 */
@Immutable
public class Measure<T> {

    private final BigDecimal value;
    private final T unit;

    public Measure(@Nonnull BigDecimal value, @Nonnull T unit) {
        this.value = value;
        this.unit = unit;
    }

    public BigDecimal getValue() {
        return value;
    }

    public T getUnit() {
        return unit;
    }
}
