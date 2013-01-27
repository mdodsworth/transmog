package com.transmog.health;

import com.yammer.metrics.core.HealthCheck;

/**
 * @author mdodsworth
 */
public class TransmogHealthCheck extends HealthCheck {

    public TransmogHealthCheck() {
        super("transmog");
    }

    @Override
    protected Result check() throws Exception {
        return Result.healthy("I'm dandy!");
    }
}
