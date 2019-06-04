package com.faisal.shipmenttracker.UI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.faisal.shipmenttracker.Adapter.ArchivedShipmentAdapter;
import com.faisal.shipmenttracker.Database.ShipmentEntry;
import com.faisal.shipmenttracker.POJO.Tracking;
import com.faisal.shipmenttracker.R;
import com.faisal.shipmenttracker.ViewModels.DBViewModel;

import org.jetbrains.annotations.NotNull;
import org.parceler.Parcels;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.faisal.shipmenttracker.UI.ShipmentsFragment.BUNDLE_RECYCLER_LAYOUT;
import static com.faisal.shipmenttracker.UI.ShipmentsFragment.SHIPPING;

public class ArchiveFragment extends Fragment
        implements ArchivedShipmentAdapter.ShipmentsOnClickHandler {

    private View mRootView;
    private ArchivedShipmentAdapter adapter;
    private List<ShipmentEntry> mArchivedShipmentsData;

    @BindView(R.id.archived_shipments)
    RecyclerView mArchivedShipments;
    @BindView(R.id.no_archived_shipments)
    TextView mNoShipments;

    public ArchiveFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.archive_fragment,
                    container, false);
        }
        ButterKnife.bind(this, mRootView);
        setupView();
        setupViewModel();

        return mRootView;
    }

    private void setupView() {
        adapter = new ArchivedShipmentAdapter(null, this, getContext());
        mArchivedShipments.setAdapter(adapter);
        mArchivedShipments.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setupViewModel() {
        DBViewModel mViewModel = ViewModelProviders.of(this).get(DBViewModel.class);
        mViewModel.getmShipments().observe(getViewLifecycleOwner(), shipmentEntries -> {
            if (shipmentEntries != null) {
                mArchivedShipmentsData = shipmentEntries;
                adapter.setShipments(mArchivedShipmentsData);
                checkShipments();
            }
        });
    }

    private void checkShipments() {
        if (mArchivedShipmentsData == null) {
            mNoShipments.setVisibility(View.VISIBLE);
        } else if (mArchivedShipmentsData.isEmpty()) {
            mNoShipments.setVisibility(View.VISIBLE);
        } else {
            mNoShipments.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onClick(View view) {
        Tracking tracking = mArchivedShipmentsData.get((int) view.getTag()).getTracking();
        Intent intent = new Intent(getContext(), ShipmentDetail.class);
        intent.putExtra(SHIPPING, Parcels.wrap(tracking));
        startActivity(intent);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        if (savedInstanceState != null) {
            Parcelable savedRecyclerLayoutState = savedInstanceState.getParcelable(BUNDLE_RECYCLER_LAYOUT);
            Objects.requireNonNull(mArchivedShipments.getLayoutManager()).onRestoreInstanceState(savedRecyclerLayoutState);
        }
    }

    @Override
    public void onSaveInstanceState(@NotNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(BUNDLE_RECYCLER_LAYOUT, Objects.requireNonNull(mArchivedShipments.getLayoutManager()).onSaveInstanceState());
    }
}
