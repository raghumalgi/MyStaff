package com.mystaff.presenter;

import com.mystaff.data.Members;

import java.util.List;

/**
 * Created by raghavendra.malgi on 26-12-2016.
 */

public interface StaffListView {





        void onRequestForStuffSuccess(List<Members> items);
        void onRequestForStuffFailure();
        void startStaffListActivity();





}
