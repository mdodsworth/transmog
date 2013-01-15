package com.transmog.health;

import com.yammer.metrics.core.HealthCheck;

/**
 * @author mdodsworth
 */
public class TransmogHealthCheck extends HealthCheck {
    private final String template;

    public TransmogHealthCheck(String template) {
        super("transmog");
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        return Result.healthy("I'm dandy!");
    }
}
