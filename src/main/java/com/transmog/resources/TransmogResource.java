package com.transmog.resources;

import com.google.common.base.Optional;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.sun.jersey.api.ParamException;
import com.transmog.model.Category;
import com.transmog.model.Measure;
import com.transmog.model.Result;
import com.transmog.model.Time;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.List;

@Path("/transmog")
@Produces(MediaType.APPLICATION_JSON)
public class TransmogResource {

    @GET
    @Timed
    public Multimap<Category, Result<?>> transmogrify(@QueryParam("value") Optional<BigDecimal> value) {
        if (!value.isPresent()) {
            throw new ParamException.FormParamException(null, "value", null);
        }

        ArrayListMultimap<Category, Result<?>> resultMap = ArrayListMultimap.create();

        resultMap.putAll(Category.TIME, getTimeConversions(value.get()));

        return resultMap;
    }

    private List<Result<?>> getTimeConversions(BigDecimal inputValue) {
        List<Result<?>> results = Lists.newArrayList();

        for (Time srcUnit : Time.values()) {
            Measure<Time> srcValue = new Measure<>(inputValue, srcUnit);

            ImmutableList.Builder<Measure<Time>> builder = ImmutableList.builder();
            for (Time destUnit : Time.values()) {
                builder.add(destUnit.convert(srcValue));
            }

            results.add(new Result<>(srcValue, builder.build()));
        }

        return results;
    }
}
