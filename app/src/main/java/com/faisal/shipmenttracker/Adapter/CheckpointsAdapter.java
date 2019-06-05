package com.faisal.shipmenttracker.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faisal.shipmenttracker.POJO.Checkpoint;
import com.faisal.shipmenttracker.R;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CheckpointsAdapter extends RecyclerView.Adapter<CheckpointsAdapter.CheckpointsAdapterViewHolder> {

    private List<Checkpoint> mCheckpoints;

    public CheckpointsAdapter(List<Checkpoint> mCheckpoints) {
        this.mCheckpoints = mCheckpoints;
    }


    class CheckpointsAdapterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.expected_delivery)
        TextView lastUpdate;
        @BindView(R.id.last_location)
        TextView lastLocation;
        @BindView(R.id.delivery_date)
        TextView checkpointDate;

        CheckpointsAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(int position) {
            String location = mCheckpoints.get(position).getLocation();
            String update = mCheckpoints.get(position).getMessage();
            String date = getTime(mCheckpoints.get(position).getCheckpointTime());

            if (location != null || !TextUtils.isEmpty(location)) {
                lastLocation.setText(location);
            }
            lastUpdate.setText(update);
            checkpointDate.setText(date);
            itemView.setTag(position);

        }


    }

    @NonNull
    @Override
    public CheckpointsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        int layoutIdForListItem = R.layout.package_info_list_item;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        return new CheckpointsAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckpointsAdapterViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        if (mCheckpoints == null) {
            return 0;
        } else {
            return mCheckpoints.size();
        }
    }

    private String getTime(String time) {
        return time.substring(0, 10);

    }
}
