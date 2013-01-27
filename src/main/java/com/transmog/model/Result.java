package com.transmog.model;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;
import java.math.BigDecimal;

/**
 * @author mdodsworth
 */
@Immutable
public class Result<T> {

    private final BigDecimal inputValue;
    private final Unit<T> inputUnit;

    public Result(@Nonnull BigDecimal inputValue, @Nonnull Unit<T> inputUnit) {
        this.inputValue = inputValue;
        this.inputUnit = inputUnit;
    }

    public BigDecimal getInputValue() {
        return inputValue;
    }

    public Unit<T> getInputUnit() {
        return inputUnit;
    }

    public Category getCategory() {
        return inputUnit.getCategory();
    }
}
