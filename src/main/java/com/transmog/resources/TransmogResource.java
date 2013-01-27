package com.transmog.resources;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.sun.jersey.api.ParamException;
import com.transmog.model.Category;
import com.transmog.model.Result;
import com.transmog.model.Time;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/transmog")
@Produces(MediaType.APPLICATION_JSON)
public class TransmogResource {

    private static final Function<Result<?>, Category> TO_CATEGORY_FUNCTION = new Function<Result<?>, Category>() {
        @Override
        public Category apply(Result<?> input) {
            return input.getCategory();
        }
    };

    @GET
    @Timed
    public Multimap<Category, Result<?>> transmogrify(@QueryParam("value") Optional<BigDecimal> value) {
        if (!value.isPresent()) {
            throw new ParamException.FormParamException(null, "value", null);
        }

        // return the collated results
        return Multimaps.index(getTimeConversions(value.get()), TO_CATEGORY_FUNCTION);
    }

    private List<Result<?>> getTimeConversions(BigDecimal inputValue) {
        List<Result<?>> results = Lists.newArrayList();

        for (Time srcUnit : Time.values()) {
            for (Time destUnit : Time.values()) {
                results.add(new Result<>(destUnit.convert(inputValue, srcUnit), destUnit));
            }
        }

        return results;
    }
}
