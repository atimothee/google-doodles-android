package io.github.atimothee.doodles.datasync;

import java.util.List;

import io.github.atimothee.doodles.provider.doodle.DoodleModel;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Timo on 3/3/15.
 */
public interface DoodleService {
    @GET("/doodles/json/{year}/{month}")
    List<Doodle> listDoodles(@Path("year") Integer year, @Path("month") Integer month);
}
