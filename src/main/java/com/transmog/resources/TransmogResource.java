package com.transmog.resources;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.sun.jersey.api.ParamException;
import com.transmog.model.Result;
import com.transmog.model.UnitCategory;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

@Path("/transmog")
@Produces(MediaType.APPLICATION_JSON)
public class TransmogResource {

    private static final Function<Result,UnitCategory> TO_CATEGORY_FUNCTION = new Function<Result, UnitCategory>() {
        @Override
        public UnitCategory apply(Result input) {
            return input.getCategory();
        }
    };

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
    public Multimap<UnitCategory, Result> transmogrify(@QueryParam("value") Optional<Long> value) {
        if (!value.isPresent()) {
            throw new ParamException.FormParamException(null, "value", null);
        }

        Result timeResult = new Result(UnitCategory.TIME, new BigDecimal(100), "ms");

        // return the collated results
        return Multimaps.index(Arrays.asList(timeResult), TO_CATEGORY_FUNCTION);
    }
}
