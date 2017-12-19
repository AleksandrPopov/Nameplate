package com.alexanderpopov.car.nameplate.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alexanderpopov.car.nameplate.resources.CarResource;
import com.alexanderpopov.car.nameplate.R;
import com.alexanderpopov.car.nameplate.adapters.MainActivityRecyclerViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarResource c = new CarResource();
        ArrayList<CarResource> carLabelAndNames = c.carLabelAndName();

        RecyclerView mRecyclerView = findViewById(R.id.listRecyclerViewMainActivity);

        GridLayoutManager mGridLayoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        MainActivityRecyclerViewAdapter mAdapter = new MainActivityRecyclerViewAdapter(carLabelAndNames, MainActivity.this);
        mRecyclerView.setAdapter(mAdapter);
    }
}
