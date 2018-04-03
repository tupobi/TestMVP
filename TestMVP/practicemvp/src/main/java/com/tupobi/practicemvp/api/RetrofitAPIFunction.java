package com.tupobi.practicemvp.api;

import com.tupobi.practicemvp.article.model.bean.GankArticle;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2018/4/3/003.
 */

public interface RetrofitAPIFunction {
    @GET("{type}/{count}/{page}")
    public Observable<GankArticle> getGankArticle(@Path("type") String type,
                                                  @Path("count") int count,
                                                  @Path("page") int page);
}
