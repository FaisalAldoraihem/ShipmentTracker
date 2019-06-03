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
import com.faisal.shipmenttracker.POJO.Shipment;
import com.faisal.shipmenttracker.POJO.Tracking;
import com.faisal.shipmenttracker.R;
import com.faisal.shipmenttracker.UI.ShipmentsFragment;
import com.faisal.shipmenttracker.Utils.ShipmentsUtils;

import org.parceler.Parcels;

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

    public ShipmentsAdapter(List<Tracking> mShipments, ShipmentsOnClickHandler onClick, Context context) {
        this.mShipments = mShipments;
        this.onClick = onClick;
        this.context = context;
    }

    public class ShipmentAdapterViewHolder extends RecyclerView.ViewHolder
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

        public ShipmentAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        void bind(int position) {
            int shipmentsSize = mShipments.get(position).getCheckpoints().size();
            String title = mShipments.get(position).getTitle();
            String lastDes = mShipments.get(position).getCheckpoints().get(shipmentsSize - 1).getMessage();
            String expectedDelivery = mShipments.get(position).getExpectedDelivery();


            mTitle.setText(title);
            mLastDestination.setText(lastDes);
            mExpected.setText(expectedDelivery);
            itemView.setTag(position);

            setImage(mCarrierImg,position);
            setListeners(mOptions, position);
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

    public void setShipments(List<Tracking> shipments) {
        mShipments = shipments;
        notifyDataSetChanged();
    }

    private void setListeners(TextView options, int position) {
        ShipmentEntry entry = new ShipmentEntry(mShipments.get(position).getId(),
                mShipments.get(position));

        Intent intent = new Intent(context, ShipmentsUtils.class);
        intent.setAction(ShipmentsUtils.ACTION_ADD_TOO_DATABASE);
        intent.putExtra(ShipmentsUtils.SHIPMENT_OBJECT, Parcels.wrap(entry));

        Intent deleteShipment = new Intent(context,ShipmentsUtils.class);
        deleteShipment.setAction(ShipmentsUtils.ACTION_REMOVE_FROM_TRACKING);
        deleteShipment.putExtra(ShipmentsUtils.SLUG,mShipments.get(position).getSlug());
        deleteShipment.putExtra(ShipmentsUtils.TRACKING,mShipments.get(position).getTrackingNumber());


        options.setOnClickListener(view -> {
            PopupMenu menu = new PopupMenu(view.getContext(), options);
            menu.inflate(R.menu.options_menu);

            menu.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()) {
                    case R.id.menu1:
                        context.startService(intent);
                        break;

                    case R.id.menu2:
                        context.startService(deleteShipment);
                        break;
                }
                return false;
            });
            menu.show();
        });

    }

    private void setImage(ImageView image, int pos) {
        switch (mShipments.get(pos).getSlug()) {
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
