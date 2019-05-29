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

public class CheckpointsFragment extends Fragment {

    private View mRootView;
    @BindView(R.id.checkpoints)
    RecyclerView mCheckPoints;

    public CheckpointsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.checkpoints_fragment,
                    container, false);
        }
        ButterKnife.bind(this, mRootView);
        

        return mRootView;
    }
}
