package com.transmog;

import com.transmog.health.TransmogHealthCheck;
import com.transmog.resources.TransmogResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 * @author mdodsworth
 */
public class TransmogService extends Service<TransmogConfiguration> {

    public static void main(String[] args) throws Exception {
        new TransmogService().run(args);
    }

    @Override
    public void initialize(Bootstrap<TransmogConfiguration> bootstrap) {
        bootstrap.setName("transmog");
    }

    @Override
    public void run(TransmogConfiguration configuration, Environment environment) {
        environment.addResource(new TransmogResource());
        environment.addHealthCheck(new TransmogHealthCheck());
    }
}