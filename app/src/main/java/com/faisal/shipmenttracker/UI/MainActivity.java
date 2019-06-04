package com.faisal.shipmenttracker.UI;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentPagerAdapter;

import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.faisal.shipmenttracker.Adapter.MyPagerAdapter;
import com.faisal.shipmenttracker.R;

import com.faisal.shipmenttracker.Shipment.ShipmentInfo;
import com.faisal.shipmenttracker.Shipment.Tracking;
import com.faisal.shipmenttracker.Utils.ShipmentsUtils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.analytics.FirebaseAnalytics;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    private FirebaseAnalytics mFirebaseAnalytics;


    @BindView(R.id.add_shipment)
    FloatingActionButton mAddShipmentFab;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.tablayout)
    TabLayout tabLayout;
    @BindView(R.id.no_network)
    TextView mNoNetwork;
    @BindView(R.id.toolbar)
    Toolbar mTopToolbar;

    static boolean isConnected;

    public static String id;
    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mTopToolbar);
        setTitle(getString(R.string.Shipments));

        MobileAds.initialize(this, getString(R.string.app_id));
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id);
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        setupView();
        setupConnectivity();
        setupAdds();
    }

    private void postTracking(Intent data) {
        String tracking = data.getStringExtra(Popup.TRACKING);
        String title = data.getStringExtra(Popup.TITLE);
        Intent intent = new Intent(this, ShipmentsUtils.class);
        intent.setAction(ShipmentsUtils.ACTION_ADD_TOO_TRACKING);

        if (tracking.isEmpty()) {
            Toast.makeText(this, getString(R.string.addtracking_fail),
                    Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(title)) {
            Tracking trackingObj = new Tracking(new ShipmentInfo(tracking, id));
            intent.putExtra(ShipmentsUtils.TRACKING_OBJECT, Parcels.wrap(trackingObj));
            startService(intent);
        } else {
            Tracking trackingObj = new Tracking(new ShipmentInfo(tracking, title, id));
            intent.putExtra(ShipmentsUtils.TRACKING_OBJECT, Parcels.wrap(trackingObj));
            startService(intent);
        }

        Toast.makeText(this, getString(R.string.giveMeaMin),
                Toast.LENGTH_LONG).show();
    }

    @SuppressLint("HardwareIds")
    private void setupView() {
        id = Settings.Secure.getString(getContentResolver(),
                Settings.Secure.ANDROID_ID);

        mAddShipmentFab.setOnClickListener(view ->
                startActivityForResult(new Intent(view.getContext(), Popup.class), 100));

        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapterViewPager);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupAdds() {
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    private void setupConnectivity() {
        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        if (isConnected) {
            mNoNetwork.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            postTracking(data);
        } else {
            Timber.d("NA");
        }
    }

}
