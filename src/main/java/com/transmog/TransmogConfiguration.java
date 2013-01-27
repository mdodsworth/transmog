package com.transmog;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author mdodsworth
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransmogConfiguration extends Configuration {
}
