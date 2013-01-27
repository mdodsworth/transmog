package com.transmog.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author mdodsworth
 */
public enum Time implements Unit<Time> {

    NANOSECONDS(BigDecimal.ONE),
    MICROSECONDS(BigDecimal.valueOf(1000L)),
    MILLISECONDS(BigDecimal.valueOf(1000L * 1000)),
    SECONDS(BigDecimal.valueOf(1000L * 1000 * 1000)),
    MINUTES(BigDecimal.valueOf(60L * 1000 * 1000 * 1000)),
    HOURS(BigDecimal.valueOf(60L * 60 * 1000 * 1000 * 1000)),
    DAYS(BigDecimal.valueOf(24L * 60 * 60 * 1000 * 1000 * 1000));

    private final BigDecimal nanosecondMultiplier;

    private Time(BigDecimal nanosecondMultiplier) {
        this.nanosecondMultiplier = nanosecondMultiplier;
    }

    @Override
    public Category getCategory() {
        return Category.TIME;
    }

    @Override
    public BigDecimal convert(BigDecimal inputValue, Time inputUnit) {
        // some of this conversion could be made a static part of each time unit, at the cost of conciseness
        BigDecimal numNanos = inputValue.multiply(inputUnit.nanosecondMultiplier);
        return numNanos.divide(this.nanosecondMultiplier, 7, RoundingMode.HALF_DOWN);
    }
}
