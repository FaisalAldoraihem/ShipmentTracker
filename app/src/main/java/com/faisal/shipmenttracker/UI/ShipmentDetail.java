package com.faisal.shipmenttracker.UI;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.faisal.shipmenttracker.POJO.Tracking;
import com.faisal.shipmenttracker.R;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShipmentDetail extends AppCompatActivity {

    @BindView(R.id.slug)
    TextView mSlug;
    @BindView(R.id.tracking)
    TextView mTracking;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.package_info);
        ButterKnife.bind(this);
        Tracking tracking = Parcels.unwrap(getIntent().getParcelableExtra(ShipmentsFragment.SHIPPING));
        if (tracking != null) {
            mSlug.setText(tracking.getSlug());
            mTracking.setText(tracking.getTrackingNumber());
        }

    }

}
