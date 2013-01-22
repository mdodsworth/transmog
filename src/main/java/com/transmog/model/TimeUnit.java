package com.transmog.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @author mdodsworth
 */
public enum TimeUnit implements Convertable<TimeUnit> {
    NANOSECONDS(1L),
    MICROSECONDS(1000L),
    MILLISECONDS(1000L * 1000),
    SECONDS(1000L * 1000 * 1000),
    MINUTES(60L * 1000 * 1000 * 1000),
    HOURS(60L * 60 * 1000 * 1000 * 1000),
    DAYS(24L * 60 * 60 * 1000 * 1000 * 1000);

    long nanosecondMultiplier;

    private TimeUnit(long nanosecondMultiplier) {
        this.nanosecondMultiplier = nanosecondMultiplier;
    }

    @Override
    public BigDecimal convert(long value, TimeUnit unit) {
        // much of this conversion could be made a static part of each time unit, at the cost of conciseness
        long numNanos = value * unit.nanosecondMultiplier;
        return new BigDecimal(numNanos).divide(new BigDecimal(this.nanosecondMultiplier), 5, RoundingMode.HALF_DOWN);
    }
}
