package com.faisal.shipmenttracker.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.faisal.shipmenttracker.Adapter.CheckpointsAdapter;
import com.faisal.shipmenttracker.POJO.Checkpoint;
import com.faisal.shipmenttracker.R;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CheckpointsFragment extends Fragment{

    private View mRootView;
    List<Checkpoint> mCheckpoints;

    @BindView(R.id.checkpoints)
    RecyclerView mCheckPointsList;

    CheckpointsAdapter adapter;

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
        if(getArguments() !=null){
            mCheckpoints = Parcels.unwrap(getArguments().getParcelable(ShipmentDetail.CHECKPOINTS));
            adapter = new CheckpointsAdapter(mCheckpoints);
            mCheckPointsList.setLayoutManager(new LinearLayoutManager(getContext()));
            mCheckPointsList.setAdapter(adapter);
        }


        return mRootView;
    }
}
