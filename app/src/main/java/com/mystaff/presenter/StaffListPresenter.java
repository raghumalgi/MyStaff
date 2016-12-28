package com.mystaff.presenter;

import com.mystaff.data.MyStaffRestApi;
import com.mystaff.data.ServiceGenerator;
import com.mystaff.data.StaffResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by raghavendra.malgi on 26-12-2016.
 */

public class StaffListPresenter  {

    private final StaffListView staffListView;
    private final String URL = "http://www.mocky.io/v2/582955b112000004088a266e";

    public StaffListPresenter(StaffListView staffListView) {
        this.staffListView = staffListView;
    }

    public void startStaffListActivity(){
        staffListView.startStaffListActivity();
    }


   public void getStaffList(){

       MyStaffRestApi serviceApi = new ServiceGenerator().createService(MyStaffRestApi.class);
       Call<StaffResponse> call = serviceApi.getStaffList(URL);
       call.enqueue(new Callback<StaffResponse>() {
           @Override
           public void onResponse(Call<StaffResponse> call, Response<StaffResponse> response) {
               staffListView.onRequestForStuffSuccess(response.body().items);

           }

           @Override
           public void onFailure(Call<StaffResponse> call, Throwable t) {
               staffListView.onRequestForStuffFailure();
           }




       });
   }


}
