package com.faisal.shipmenttracker.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import com.faisal.shipmenttracker.POJO.Tracking;
import com.faisal.shipmenttracker.R;

import org.parceler.Parcels;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShipmentDetail extends AppCompatActivity {

    public static final String CHECKPOINTS = "checkpoints";

    CheckpointsFragment mCheckpointsFragment;
    Tracking mTracking;

    @BindView(R.id.info)
    ConstraintLayout layout;
    @BindView(R.id.showinfo)
    RelativeLayout base;
    @BindView(R.id.Drop)
    ImageView arrow;
    @BindView(R.id.toolbarDetail)
    Toolbar mTopToolbar;

    @BindView(R.id.expected_delivery)
    TextView mSlug;
    @BindView(R.id.last_location)
    TextView mTrackingText;
    @BindView(R.id.route)
    TextView mRoute;
    @BindView(R.id.delivery_date)
    TextView mDate;
    @BindView(R.id.destination_value)
    TextView mDestination;
    @BindView(R.id.weight_value)
    TextView mWeight;
    @BindView(R.id.from_value)
    TextView mFrom;

    boolean hidden = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.package_info);
        ButterKnife.bind(this);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        setSupportActionBar(mTopToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        if (getIntent() != null) {
            mTracking = Parcels.unwrap(getIntent().getParcelableExtra(ShipmentsFragment.SHIPPING));
        }

        if (mTracking != null) {
            setupView();
        }

        if (!hidden) {
            layout.setVisibility(View.VISIBLE);
            arrow.setImageResource(R.drawable.ic_arrow_drop_up);
        }

        setupListener();
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

    private void setupListener() {
        base.setOnClickListener(view -> {
            hidden = !hidden;
            if (!hidden) {
                layout.setVisibility(View.VISIBLE);
                arrow.setImageResource(R.drawable.ic_arrow_drop_up);
            } else {
                layout.setVisibility(View.GONE);
                arrow.setImageResource(R.drawable.ic_arrow_drop_down);
            }
        });
    }

    private void setupView() {
        String route = mTracking.getOriginCountryIso3() + " -> " + mTracking.getCourierDestinationCountryIso3();
        String date = mTracking.getExpectedDelivery();
        String weight = mTracking.getShipmentWeight() + " " + mTracking.getShipmentWeightUnit();
        String destination = mTracking.getCourierDestinationCountryIso3();
        String origin = mTracking.getOriginCountryIso3();

        mSlug.setText(mTracking.getSlug());
        mTrackingText.setText(mTracking.getTrackingNumber());
        mRoute.setText(route);
        mWeight.setText(weight);
        mFrom.setText(origin);
        mDestination.setText(destination);

        if (date == null) {
            date = getString(R.string.delivered);
        }

        mDate.setText(date);
    }

}
