package com.transmog;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author mdodsworth
 */
public class TransmogConfiguration extends Configuration {

    @NotEmpty
    @JsonProperty
    private String template;

    @NotEmpty
    @JsonProperty
    private String defaultUnit = "Metre";

    public String getTemplate() {
        return template;
    }

    public String getDefaultUnit() {
        return defaultUnit;
    }
}
