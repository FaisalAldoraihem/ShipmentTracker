package com.faisal.shipmenttracker.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.faisal.shipmenttracker.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShipmentsFragment extends Fragment {

    private View mRootView;
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

        return mRootView;
    }
}
