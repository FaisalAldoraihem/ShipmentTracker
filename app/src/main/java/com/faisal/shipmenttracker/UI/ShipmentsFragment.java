package com.faisal.shipmenttracker.UI;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.faisal.shipmenttracker.Adapter.ShipmentsAdapter;
import com.faisal.shipmenttracker.POJO.Tracking;
import com.faisal.shipmenttracker.R;

import com.faisal.shipmenttracker.ViewModels.ShipmentsViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShipmentsFragment extends Fragment {

    List<Tracking> mShipmentsData;
    private View mRootView;
    private ShipmentsAdapter adapter;
    private ShipmentsViewModel mShipmentsViewModel;
    private onClickListener mOnClick;

    @BindView(R.id.shipments)
    RecyclerView mShipments;

    public interface onClickListener {
        void onClick(View view);
    }

    public ShipmentsFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mOnClick = (onClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement onClickListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.shipment_fragment,
                    container, false);
        }
        ButterKnife.bind(this, mRootView);
        adapter = new ShipmentsAdapter(null, mOnClick);
        mShipments.setAdapter(adapter);
        mShipments.setLayoutManager(new LinearLayoutManager(getContext()));

        mShipmentsViewModel = ViewModelProviders.of(this).get(ShipmentsViewModel.class);
        mShipmentsViewModel.getmShipments().observe(getViewLifecycleOwner(), shipment -> {
            if (shipment != null) {
                mShipmentsData = shipment.getData().getTrackings();
                adapter.setShipments(mShipmentsData);
            }
        });

        return mRootView;
    }
}
