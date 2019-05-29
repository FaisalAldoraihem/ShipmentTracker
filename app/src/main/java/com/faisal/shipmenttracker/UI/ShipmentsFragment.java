package com.faisal.shipmenttracker.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.faisal.shipmenttracker.Adapter.ShipmentsAdapter;
import com.faisal.shipmenttracker.POJO.Tracking;
import com.faisal.shipmenttracker.R;

import com.faisal.shipmenttracker.ViewModels.ShipmentsViewModel;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShipmentsFragment extends Fragment implements ShipmentsAdapter.ShipmentsOnClickHandler{

    public static String SHIPPING = "shipping";
    List<Tracking> mShipmentsData;
    private View mRootView;
    private ShipmentsAdapter adapter;
    private ShipmentsViewModel mShipmentsViewModel;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.shipments)
    RecyclerView mShipments;

    public ShipmentsFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.shipment_fragment,
                    container, false);
        }
        ButterKnife.bind(this, mRootView);
        adapter = new ShipmentsAdapter(null,this);
        mShipments.setAdapter(adapter);
        mShipments.setLayoutManager(new LinearLayoutManager(getContext()));

        if(!MainActivity.isConnected){
            progressBar.setVisibility(View.INVISIBLE);
        }

        mShipmentsViewModel = ViewModelProviders.of(this).get(ShipmentsViewModel.class);
        mShipmentsViewModel.getmShipments().observe(getViewLifecycleOwner(), shipment -> {
            if (shipment != null) {
                progressBar.setVisibility(View.INVISIBLE);
                mShipmentsData = shipment.getData().getTrackings();
                adapter.setShipments(mShipmentsData);
            }
        });

        return mRootView;
    }

    @Override
    public void onClick(View view) {
        Tracking tracking = mShipmentsData.get((int)view.getTag());
        Intent intent = new Intent(getContext(), ShipmentDetail.class);
        intent.putExtra(SHIPPING, Parcels.wrap(tracking));
        startActivity(intent);
    }
}
