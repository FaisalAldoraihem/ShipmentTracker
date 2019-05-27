package com.faisal.shipmenttracker.UI;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;

import com.faisal.shipmenttracker.BuildConfig;
import com.faisal.shipmenttracker.R;

import com.faisal.shipmenttracker.Shipment.ShipmentInfo;
import com.faisal.shipmenttracker.Shipment.Tracking;
import com.faisal.shipmenttracker.Utils.ShipmentsUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;


import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements ShipmentsFragment.onClickListener {

    @BindView(R.id.add_shipment)
    FloatingActionButton mAddShipmentFab;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.tablayout)
    TabLayout tabLayout;

    public static String id;
    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setTitle("Packages");

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        setup();
    }

    private void postTracking(Intent data) {
        String tracking = data.getStringExtra(Popup.TRACKING);
        String title = data.getStringExtra(Popup.TITLE);
        if (TextUtils.isEmpty(title)) {
            new ShipmentsUtils().postTracking(new Tracking(new ShipmentInfo(tracking, id)), this);
        } else {
            new ShipmentsUtils().postTracking(new Tracking(new ShipmentInfo(tracking, title, id)), this);
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

    @Override
    public void onClick(View view) {
        Timber.e("It does");
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private Fragment[] childFragments;

        MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);

            childFragments = new Fragment[]{
                    new ShipmentsFragment(),
                    new ArchiveFragment()
            };
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return childFragments.length;
        }


        @Override
        public Fragment getItem(int position) {
            return childFragments[position];
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0) {
                return "In Transit";
            } else {
                return "Archive";
            }
        }

    }
}
