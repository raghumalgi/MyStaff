package com.mystaff.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mystaff.R;
import com.mystaff.util.PicassoUtil;

public class DefaultStaffActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_staff);
        getSupportActionBar().setTitle("My Staff");
        //check for default name and image if persisted
        checkDefaultStaffMember();
    }



    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        checkDefaultStaffMember();
    }

    private void checkDefaultStaffMember() {
        SharedPreferences settings = getSharedPreferences(DetailStaffActivity.PREFS, Context.MODE_PRIVATE);
            if(settings!=null){
                String url = settings.getString(DetailStaffActivity.THUMBNAIL,"");
                String name = settings.getString(DetailStaffActivity.NAME,"");
                if(url.length()==0||name.length()==0){
                    return;
                }
                TextView tv= (TextView) findViewById(R.id.txt_staff_name);
                ImageView iv= (ImageView) findViewById(R.id.staff_photo);
                tv.setVisibility(View.VISIBLE);
                iv.setVisibility(View.VISIBLE);
                tv.setText(name);

                PicassoUtil.loadImage(this,url,iv);


            }


    }


    public void onStaffButtonClicked(View view){
        Intent intent = new Intent(this,StaffListActivity.class);
        startActivity(intent);

    }

}
