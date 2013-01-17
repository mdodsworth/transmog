package com.transmog.resource;

import com.sun.jersey.api.ParamException;
import com.transmog.model.Result;
import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/transmog")
@Produces(MediaType.APPLICATION_JSON)
public class TransmogResource {

    private final String template;
    private final String defaultUnit;
    private final AtomicLong counter;

    public TransmogResource(String template, String defaultUnit) {
        this.template = template;
        this.defaultUnit = defaultUnit;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Result transmogrify(@QueryParam("value") Optional<Long> value) {
        if (!value.isPresent()) {
            throw new ParamException.FormParamException(null, "value", null);
        }

        return new Result(counter.incrementAndGet(), String.format(template, value.or(0L)));
    }
}
