package com.mystaff.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;


public interface MyStaffRestApi {

    @GET
    Call<StaffResponse> getStaffList(@Url String url);


}