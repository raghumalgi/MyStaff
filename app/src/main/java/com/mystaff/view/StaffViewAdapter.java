package com.mystaff.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mystaff.R;
import com.mystaff.data.Members;
import com.mystaff.databinding.StaffViewRowBinding;
import com.mystaff.util.PicassoUtil;

import java.util.List;

public class StaffViewAdapter extends RecyclerView.Adapter<StaffViewAdapter.StaffViewHolder> {

    private List<Members> itemList;
    private Context context;

    public StaffViewAdapter(Context context, List<Members> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public StaffViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.staff_view_row, null);
        StaffViewHolder rcv = new StaffViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(StaffViewHolder holder, int position) {
        holder.bind(itemList.get(position));
        PicassoUtil.loadImage(context,itemList.get(position).thumbnail,holder.thumbnailIv);



    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public Members getItem(int position) {
        return itemList.get(position);
    }


    class StaffViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public StaffViewRowBinding binding;
        public ImageView thumbnailIv;

        public StaffViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            thumbnailIv = (ImageView) itemView.findViewById(R.id.staff_photo);
            binding = DataBindingUtil.bind(itemView);
        }

        public void bind(Members member) {
            binding.setMember(member);
        }
        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Members member = getItem(position);
            Intent intent = new Intent(context,DetailStaffActivity.class);
            intent.putExtra("titleText",member.title);
            intent.putExtra("positionText",member.position);
            intent.putExtra("thumbnailUrl",member.thumbnail);
            intent.putExtra("emailText",member.email);
            context.startActivity(intent);

        }


    }
}