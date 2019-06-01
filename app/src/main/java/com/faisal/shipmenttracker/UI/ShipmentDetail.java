package com.faisal.shipmenttracker.UI;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.faisal.shipmenttracker.POJO.Tracking;
import com.faisal.shipmenttracker.R;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShipmentDetail extends AppCompatActivity {

    public static final String CHECKPOINTS = "checkpoints";

    CheckpointsFragment mCheckpointsFragment;
    Tracking mTracking;

    @BindView(R.id.expected_delivery)
    TextView mSlug;
    @BindView(R.id.last_location)
    TextView mTrackingText;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.package_info);
        ButterKnife.bind(this);
        mTracking = Parcels.unwrap(getIntent().getParcelableExtra(ShipmentsFragment.SHIPPING));
        if (mTracking != null) {
            mSlug.setText(mTracking.getSlug());
            mTrackingText.setText(mTracking.getTrackingNumber());
        }

        setUpFragment();
    }

    private void setUpFragment() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(CHECKPOINTS, Parcels.wrap(mTracking.getCheckpoints()));

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (mCheckpointsFragment == null) {
            mCheckpointsFragment = new CheckpointsFragment();
            mCheckpointsFragment.setArguments(bundle);

            fragmentManager.beginTransaction()
                    .add(R.id.checkpoints, mCheckpointsFragment)
                    .commit();
        }
    }

}
