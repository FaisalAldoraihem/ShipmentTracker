package com.faisal.shipmenttracker.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faisal.shipmenttracker.Database.ShipmentEntry;
import com.faisal.shipmenttracker.R;
import com.faisal.shipmenttracker.Utils.ShipmentsUtils;


import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArchivedShipmentAdapter extends RecyclerView.Adapter<ArchivedShipmentAdapter.ArchivedShipmentAdapterViewHolder> {

    private List<ShipmentEntry> mShipments;
    private final ShipmentsOnClickHandler onClick;
    private final Context context;

    public interface ShipmentsOnClickHandler {
        void onClick(View view);
    }

    public ArchivedShipmentAdapter(List<ShipmentEntry> mShipments, ShipmentsOnClickHandler onClick, Context context) {
        this.mShipments = mShipments;
        this.onClick = onClick;
        this.context = context;
    }

    public class ArchivedShipmentAdapterViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        @BindView(R.id.shipping_title)
        TextView mTitle;
        @BindView(R.id.last_destination)
        TextView mLastDestination;
        @BindView(R.id.expected_delivery)
        TextView mExpected;
        @BindView(R.id.textViewOptions)
        TextView mOptions;
        @BindView(R.id.carrier_img)
        ImageView mCarrierImg;

        public ArchivedShipmentAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        void bind(int position) {
            int shipmentsSize = mShipments.get(position).getTracking().getCheckpoints().size();
            String title = mShipments.get(position).getTracking().getTitle();
            String lastDes;
            String expectedDelivery = mShipments.get(position).getTracking().getExpectedDelivery();

            if (shipmentsSize > 0) {
                lastDes = mShipments.get(position).getTracking().getCheckpoints().get(shipmentsSize - 1).getMessage();
            } else {
                lastDes = mShipments.get(position).getTracking().getCheckpoints().get(0).getMessage();
            }

            mTitle.setText(title);
            mLastDestination.setText(lastDes);
            mExpected.setText(expectedDelivery);
            itemView.setTag(position);

            setImage(mCarrierImg, position);
            setListeners(mOptions, position);
        }

        @Override
        public void onClick(View view) {
            onClick.onClick(view);
        }
    }


    @NonNull
    @Override
    public ArchivedShipmentAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        int layoutIdForListItem = R.layout.shipment_list_item;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        return new ArchivedShipmentAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArchivedShipmentAdapterViewHolder holder, int position) {
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

    public void setShipments(List<ShipmentEntry> shipments) {
        mShipments = shipments;
        notifyDataSetChanged();
    }

    private void setListeners(TextView options, int position) {
        ShipmentEntry entry = new ShipmentEntry(mShipments.get(position).getTracking().getId(),
                mShipments.get(position).getTracking());
        Intent intent = new Intent(context, ShipmentsUtils.class);
        intent.setAction(ShipmentsUtils.ACTION_REMOVE_FROM_DATABASE);
        intent.putExtra(ShipmentsUtils.SHIPMENT_OBJECT, Parcels.wrap(entry));

        options.setOnClickListener(view -> {
            PopupMenu menu = new PopupMenu(view.getContext(), options);
            menu.inflate(R.menu.archive_options);

            menu.setOnMenuItemClickListener(item -> {
                if (item.getItemId() == R.id.archive_menu) {
                    context.startService(intent);
                }
                return false;
            });
            menu.show();
        });

    }

    private void setImage(ImageView image, int pos) {
        switch (mShipments.get(pos).getTracking().getSlug()) {
            case "fedex":
                image.setImageResource(R.drawable.fedex);
                break;

            case "ups":
                image.setImageResource(R.drawable.ups);
                break;

            case "usps":
                image.setImageResource(R.drawable.usps);
                break;

            case "saudi-post":
                image.setImageResource(R.drawable.saudi);
                break;

            case "dhl-express":
                image.setImageResource(R.drawable.dhl);
                break;
            default:
                image.setImageResource(R.drawable.fedex);
                break;
        }
    }
}
