package com.faisal.shipmenttracker.UI;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

import com.faisal.shipmenttracker.Adapter.MyPagerAdapter;
import com.faisal.shipmenttracker.BuildConfig;
import com.faisal.shipmenttracker.R;

import com.faisal.shipmenttracker.Shipment.ShipmentInfo;
import com.faisal.shipmenttracker.Shipment.Tracking;
import com.faisal.shipmenttracker.Utils.ShipmentsUtils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;

    @BindView(R.id.add_shipment)
    FloatingActionButton mAddShipmentFab;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.tablayout)
    TabLayout tabLayout;
    @BindView(R.id.no_network)
    TextView mNoNetwork;

    static boolean isConnected;

    public static String id;
    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setTitle("Packages");
        MobileAds.initialize(this, "ca-app-pub-8577762809608928~8578625843");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);



        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        if (isConnected) {
            mNoNetwork.setVisibility(View.INVISIBLE);
        }
        setup();
    }

    private void postTracking(Intent data) {
        String tracking = data.getStringExtra(Popup.TRACKING);
        String title = data.getStringExtra(Popup.TITLE);
        if (tracking.isEmpty()) {
            return;
        }

        if (TextUtils.isEmpty(title)) {
            Intent intent = new Intent(this, ShipmentsUtils.class);
            intent.setAction(ShipmentsUtils.ACTION_ADD_TOO_TRACKING);
            Tracking tracking1 = new Tracking(new ShipmentInfo(tracking, id));
            intent.putExtra(ShipmentsUtils.TRACKING_OBJECT, Parcels.wrap(tracking1));

            startService(intent);
        } else {
            Intent intent = new Intent(this, ShipmentsUtils.class);
            intent.setAction(ShipmentsUtils.ACTION_ADD_TOO_TRACKING);
            Tracking tracking1 = new Tracking(new ShipmentInfo(tracking, title, id));
            intent.putExtra(ShipmentsUtils.TRACKING_OBJECT, Parcels.wrap(tracking1));

            startService(intent);
        }
    }

    @SuppressLint("HardwareIds")
    private void setup() {
        id = Settings.Secure.getString(getContentResolver(),
                Settings.Secure.ANDROID_ID);
        Timber.e(id);
        mAddShipmentFab.setOnClickListener(view ->
                startActivityForResult(new Intent(view.getContext(), Popup.class), 100));

        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapterViewPager);
        tabLayout.setupWithViewPager(mViewPager);

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
