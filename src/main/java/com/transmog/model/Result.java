package com.transmog.model;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;
import java.math.BigDecimal;

/**
 * @author mdodsworth
 */
@Immutable
public class Result {

    // TODO: is category necessary?
    private final UnitCategory category;
    private final BigDecimal value;
    private final String unit;

    public Result(@Nonnull UnitCategory category, BigDecimal value, @Nonnull String unit) {
        this.category = category;
        this.value = value;
        this.unit = unit;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    public UnitCategory getCategory() {
        return category;
    }
}
