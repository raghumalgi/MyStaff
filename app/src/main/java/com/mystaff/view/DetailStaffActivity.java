package com.mystaff.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mystaff.R;
import com.mystaff.util.PicassoUtil;

public class DetailStaffActivity extends AppCompatActivity {

    private String thumbnail;
    private String titleText;

    public static final String PREFS = "prefs";
    public static final String THUMBNAIL = "thumbnail";
    public static final String NAME = "name";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_staff);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        TextView titleTv = (TextView) findViewById(R.id.staff_name);
        TextView emailTv = (TextView) findViewById(R.id.email);
        TextView positionTv = (TextView) findViewById(R.id.position);
       ImageView thumbnailIv = (ImageView) findViewById(R.id.staff_photo);

        Bundle bundle = getIntent().getExtras();
         thumbnail = bundle.getString("thumbnailUrl");
        String positionText = bundle.getString("positionText");
         titleText = bundle.getString("titleText");
        String emailText = bundle.getString("emailText");

        getSupportActionBar().setTitle(titleText);

        titleTv.setText(titleText);
        positionTv.setText(positionText);
        emailTv.setText(emailText);

        PicassoUtil.loadImage(this,thumbnail,thumbnailIv);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onDefaultClicked(View view){

        SharedPreferences settings = getSharedPreferences(DetailStaffActivity.PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(DetailStaffActivity.NAME, titleText);
        editor.putString(DetailStaffActivity.THUMBNAIL, thumbnail);
        editor.commit();

        Intent intent = new Intent(this,DefaultStaffActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();


    }
}
