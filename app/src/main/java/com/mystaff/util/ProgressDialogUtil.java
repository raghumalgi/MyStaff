package com.mystaff.util;


import android.app.Activity;
import android.app.ProgressDialog;

public class ProgressDialogUtil {

    //Static because we are calling showprogress and dismiss multiple times  so
    // nullifying the instance after usage
    private static ProgressDialog pDialog;

    public  static void showProgressDialog(Activity context,String message) {
        if (pDialog == null) {
            pDialog = new ProgressDialog(context);
            pDialog.setMessage(message);
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
        }
        pDialog.show();
    }

    public static void dismissProgressDialog() {
        if (pDialog != null && pDialog.isShowing()) {
            pDialog.dismiss();
            pDialog = null;
        }
    }


}
