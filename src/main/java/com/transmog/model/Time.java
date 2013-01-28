package com.transmog.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author mdodsworth
 */
public enum Time implements Convertable<Time> {

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
    public Measure<Time> convert(Measure<Time> inputValue) {
        // some of this conversion could be made a static part of each time unit, at the cost of conciseness
        BigDecimal numNanos = inputValue.getValue().multiply(inputValue.getUnit().nanosecondMultiplier);
        return new Measure<>(numNanos.divide(this.nanosecondMultiplier, 7, RoundingMode.HALF_DOWN), this);
    }
}
