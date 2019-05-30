package com.faisal.shipmenttracker.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faisal.shipmenttracker.Database.ShipmentEntry;
import com.faisal.shipmenttracker.POJO.Tracking;
import com.faisal.shipmenttracker.R;
import com.faisal.shipmenttracker.Utils.ShipmentsUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShipmentsAdapter extends RecyclerView.Adapter<ShipmentsAdapter.ShipmentAdapterViewHolder> {

    private List<Tracking> mShipments;
    private final ShipmentsOnClickHandler onClick;
    private Context context;

    public interface ShipmentsOnClickHandler {
        void onClick(View view);
    }

    public ShipmentsAdapter(List<Tracking> mShipments, ShipmentsOnClickHandler onClick,Context context) {
        this.mShipments = mShipments;
        this.onClick = onClick;
        this.context = context;
    }

    public class ShipmentAdapterViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        @BindView(R.id.shipping_title)
        TextView title;
        @BindView(R.id.last_destination)
        TextView lastDestination;
        @BindView(R.id.last_update)
        TextView lastUpdate;
        @BindView(R.id.textViewOptions)
        TextView options;
        @BindView(R.id.carrier_img)
        ImageView carrierImg;

        public ShipmentAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        void bind(int position) {
            int last = mShipments.get(position).getCheckpoints().size();
            String lastDes = mShipments.get(position).getCheckpoints().get(last - 1).getMessage();

            title.setText(mShipments.get(position).getTitle());
            lastDestination.setText(lastDes);
            lastUpdate.setText(getTime(mShipments.get(position).getLastUpdatedAt()));
            itemView.setTag(position);

            options.setOnClickListener(view -> {
                PopupMenu menu = new PopupMenu(view.getContext(), options);
                menu.inflate(R.menu.options_menu);

                menu.setOnMenuItemClickListener(item -> {
                    switch (item.getItemId()) {
                        case R.id.menu1:
                            ShipmentEntry entry = new ShipmentEntry(mShipments.get(position));
                            new ShipmentsUtils().addToDatabase(entry,context);
                            break;
                        case R.id.menu2:
                            new ShipmentsUtils().deleteShipment(mShipments.get(position).getSlug(),
                                    mShipments.get(position).getTrackingNumber());
                            break;
                    }
                    return false;
                });
                menu.show();
            });
        }

        @Override
        public void onClick(View view) {
            onClick.onClick(view);
        }
    }

    @NonNull
    @Override
    public ShipmentAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        int layoutIdForListItem = R.layout.shipment_list_item;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        return new ShipmentAdapterViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ShipmentAdapterViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        if (mShipments == null) {
            return 0;
        } else {
            return mShipments.size();
        }
    }

    private String getTime(String time){
        String hours = time.substring(11,19);
        hours = hours.substring(0,2) + "h" + hours.substring(3,5) + "m ago";
        return hours;
    }

    public void setShipments(List<Tracking> shipments) {
        mShipments = shipments;
        notifyDataSetChanged();
    }
}
