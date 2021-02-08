package com.aindri.demomap;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroApi {
@GET("put variable part of url")
Call<List<Model>> getListData();
}
