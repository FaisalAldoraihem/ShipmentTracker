package com.faisal.shipmenttracker.UI;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.faisal.shipmenttracker.Adapter.CheckpointsAdapter;
import com.faisal.shipmenttracker.POJO.Checkpoint;
import com.faisal.shipmenttracker.R;

import org.jetbrains.annotations.NotNull;
import org.parceler.Parcels;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.faisal.shipmenttracker.UI.ShipmentsFragment.BUNDLE_RECYCLER_LAYOUT;

public class CheckpointsFragment extends Fragment {

    private View mRootView;
    private List<Checkpoint> mCheckpoints;
    CheckpointsAdapter adapter;

    @BindView(R.id.checkpoints)
    RecyclerView mCheckPointsList;

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

        if (getArguments() != null) {
            mCheckpoints = Parcels.unwrap(getArguments().getParcelable(ShipmentDetail.CHECKPOINTS));
            adapter = new CheckpointsAdapter(mCheckpoints);
            mCheckPointsList.setLayoutManager(new LinearLayoutManager(getContext()));
            mCheckPointsList.setAdapter(adapter);
        }


        return mRootView;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        if (savedInstanceState != null) {
            Parcelable savedRecyclerLayoutState = savedInstanceState.getParcelable(BUNDLE_RECYCLER_LAYOUT);
            Objects.requireNonNull(mCheckPointsList.getLayoutManager()).onRestoreInstanceState(savedRecyclerLayoutState);
        }
    }

    @Override
    public void onSaveInstanceState(@NotNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(BUNDLE_RECYCLER_LAYOUT, Objects.requireNonNull(mCheckPointsList.getLayoutManager()).onSaveInstanceState());
    }
}
