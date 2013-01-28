package com.transmog.model;

import com.google.common.collect.ImmutableList;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;
import java.util.List;

/**
 * @author mdodsworth
 */
@Immutable
public class Result<T> {

    private final Measure<T> inputValue;
    private final ImmutableList<Measure<T>> outputValues;

    public Result(@Nonnull Measure<T> inputValue, @Nonnull List<Measure<T>> outputValues) {
        this.inputValue = inputValue;
        this.outputValues = ImmutableList.copyOf(outputValues);
    }

    public Measure<T> getInputValue() {
        return inputValue;
    }

    public List<Measure<T>> getOutputValues() {
        return outputValues;
    }
}
