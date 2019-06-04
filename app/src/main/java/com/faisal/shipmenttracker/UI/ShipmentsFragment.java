package com.faisal.shipmenttracker.UI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

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

import org.jetbrains.annotations.NotNull;
import org.parceler.Parcels;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShipmentsFragment extends Fragment
        implements ShipmentsAdapter.ShipmentsOnClickHandler {

    public static final String BUNDLE_RECYCLER_LAYOUT = "ShipmentsFragment.recycler.layout";

    static final String SHIPPING = "shipping";
    private List<Tracking> mShipmentsData;
    private View mRootView;
    private ShipmentsAdapter adapter;
    private static ShipmentsViewModel mShipmentsViewModel;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.shipments)
    RecyclerView mShipments;
    @BindView(R.id.swipe)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.no_archived_shipments)
    TextView mNoShipments;

    public ShipmentsFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.shipment_fragment,
                    container, false);
        }

        ButterKnife.bind(this, mRootView);

        adapter = new ShipmentsAdapter(null, this, getContext());
        mShipments.setAdapter(adapter);
        mShipments.setLayoutManager(new LinearLayoutManager(getContext()));

        if (MainActivity.isConnected) {
            progressBar.setVisibility(View.INVISIBLE);

        }

        setupViewModel();
        setupListener();
        return mRootView;
    }

    private void setupListener() {
        mSwipeRefreshLayout.setOnRefreshListener(() -> {
            refresh();
            mSwipeRefreshLayout.setRefreshing(false);
            checkShipments();
        });
    }

    private void setupViewModel() {
        mShipmentsViewModel = ViewModelProviders.of(this).get(ShipmentsViewModel.class);
        mShipmentsViewModel.getmShipments().observe(getViewLifecycleOwner(), shipment -> {
            if (shipment != null) {
                mShipmentsData = shipment.getData().getTrackings();
                adapter.setShipments(mShipmentsData);
                progressBar.setVisibility(View.INVISIBLE);
            }
            checkShipments();
        });

    }

    private void checkShipments() {
        if (mShipmentsData == null) {
            progressBar.setVisibility(View.INVISIBLE);
            mNoShipments.setVisibility(View.VISIBLE);
        } else if (mShipmentsData.isEmpty()) {
            progressBar.setVisibility(View.INVISIBLE);
            mNoShipments.setVisibility(View.VISIBLE);
        } else {
            mNoShipments.setVisibility(View.INVISIBLE);
        }
    }

    public static void refresh() {
        mShipmentsViewModel.fetchShipments();
    }

    @Override
    public void onClick(View view) {
        Tracking tracking = mShipmentsData.get((int) view.getTag());
        Intent intent = new Intent(getContext(), ShipmentDetail.class);
        intent.putExtra(SHIPPING, Parcels.wrap(tracking));
        startActivity(intent);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        if (savedInstanceState != null) {
            Parcelable savedRecyclerLayoutState = savedInstanceState.getParcelable(BUNDLE_RECYCLER_LAYOUT);
            Objects.requireNonNull(mShipments.getLayoutManager()).onRestoreInstanceState(savedRecyclerLayoutState);
        }
    }

    @Override
    public void onSaveInstanceState(@NotNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(BUNDLE_RECYCLER_LAYOUT, Objects.requireNonNull(mShipments.getLayoutManager()).onSaveInstanceState());
    }
}
