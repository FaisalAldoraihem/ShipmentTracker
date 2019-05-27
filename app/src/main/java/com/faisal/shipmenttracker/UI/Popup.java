package com.faisal.shipmenttracker.UI;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.faisal.shipmenttracker.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Popup extends AppCompatActivity {

    public static final String TITLE = "title";
    public static final String TRACKING = "Tracking";

    @BindView(R.id.tracking_input)
    EditText mTracking;
    @BindView(R.id.title_input)
    EditText mTitle;
    @BindView(R.id.done)
    Button mDone;
    @BindView(R.id.cancel)
    Button mCancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_tracking);
        ButterKnife.bind(this);
        setTitle("");

        mDone.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra(TITLE, mTitle.getText().toString().trim());
            intent.putExtra(TRACKING, mTracking.getText().toString().trim());
            setResult(RESULT_OK,intent);
            onBackPressed();
        });

        mCancel.setOnClickListener(view -> {
            setResult(RESULT_CANCELED);
            onBackPressed();
        });
    }

}
