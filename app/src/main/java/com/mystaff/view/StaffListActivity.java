package com.mystaff.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.mystaff.R;
import com.mystaff.data.Members;
import com.mystaff.presenter.StaffListPresenter;
import com.mystaff.presenter.StaffListView;
import com.mystaff.util.ProgressDialogUtil;

import java.util.ArrayList;
import java.util.List;

public class StaffListActivity extends AppCompatActivity implements StaffListView {

    private RecyclerView recyclerView;
    private StaffViewAdapter adapter;
    private StaffListPresenter presenter;
    private List<Members> membersList  = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_list);

        //ActionBar Init
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Staff");

        //Recycler View Init
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new StaffViewAdapter(this,membersList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        //Access the presenter
        presenter = new StaffListPresenter(this);
        ProgressDialogUtil.showProgressDialog(this,"Loading");
        presenter.getStaffList();

    }

    @Override
    public void onRequestForStuffSuccess(List<Members> membersList) {
        adapter = new StaffViewAdapter(this,membersList);
        recyclerView.setAdapter(adapter);
        ProgressDialogUtil.dismissProgressDialog();

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

    @Override
    public void onRequestForStuffFailure() {
        ProgressDialogUtil.dismissProgressDialog();
        Toast.makeText(StaffListActivity.this, "Failed to fetch Staff List.Please try Again!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void startStaffListActivity() {

    }
}
