package com.transmog.model;

import javax.annotation.Nonnull;

/**
 * @author mdodsworth
 */
public class Result {

    private final long value;
    private final String unit;

    public Result(long value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public long getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }
}
