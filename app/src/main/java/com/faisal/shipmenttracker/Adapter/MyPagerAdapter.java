package com.faisal.shipmenttracker.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.faisal.shipmenttracker.UI.ArchiveFragment;
import com.faisal.shipmenttracker.UI.ShipmentsFragment;

public class MyPagerAdapter extends FragmentPagerAdapter {
    public static final String ARCHIVE = "Archive";
    public static final String INTRANSIT = "In Transit";

    private final Fragment[] childFragments;

    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);

        childFragments = new Fragment[]{
                new ShipmentsFragment(),
                new ArchiveFragment()
        };
    }


    @Override
    public int getCount() {
        return childFragments.length;
    }


    @Override
    public Fragment getItem(int position) {
        return childFragments[position];
    }


    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return INTRANSIT;
        } else {
            return ARCHIVE;
        }
    }
}
