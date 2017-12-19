package com.alexanderpopov.car.nameplate.activitys;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alexanderpopov.car.nameplate.R;
import com.alexanderpopov.car.nameplate.adapters.MainActivityRecyclerViewAdapter;

public class CarInfoActivity extends AppCompatActivity implements View.OnClickListener {

    Intent mIntent;

    @SuppressLint("RestrictedApi")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_info);

        ImageView mCarVinSchemeImage = findViewById(R.id.carVinSchemeImageViewCarInfo);
        TextView mCarSchemeInfoText = findViewById(R.id.carSchemeInfoTextViewCarInfo);
        ImageView mCarVinImage = findViewById(R.id.mCarVinImageViewCarInfo);
        ImageView mCarVinImage2 = findViewById(R.id.mCarVin2ImageViewCarInfo);
        Button btnAllColorList = findViewById(R.id.btnAllColorListCarInfo);
        Button btnChoiceModel = findViewById(R.id.btnChoiceModelCarInfo);

        mIntent = getIntent();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(mIntent.getIntExtra(MainActivityRecyclerViewAdapter.CAR_NAME_TEXT, 1));

        mCarVinSchemeImage.setImageResource(mIntent.getIntExtra(MainActivityRecyclerViewAdapter.CAR_PLATE_SCHEME_IMAGE, 1));
        mCarVinImage.setImageResource(mIntent.getIntExtra(MainActivityRecyclerViewAdapter.CAR_VIN_PHOTO, 1));
        mCarVinImage2.setImageResource(mIntent.getIntExtra(MainActivityRecyclerViewAdapter.CAR_VIN_PHOTO2, 1));
        mCarSchemeInfoText.setText(mIntent.getIntExtra(MainActivityRecyclerViewAdapter.CAR_PLATE_SCHEME_TEXT, 1));

        btnAllColorList.setOnClickListener(this);
        btnChoiceModel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        try {
            if (netInfo != null && netInfo.isConnectedOrConnecting()) {
                switch (v.getId()) {
                    case R.id.btnAllColorListCarInfo:
                        intent = new Intent(CarInfoActivity.this, AllColorListActivity.class);
                        intent.putExtras(mIntent);
                        startActivity(intent);
                        break;
                    case R.id.btnChoiceModelCarInfo:
                        intent = new Intent(CarInfoActivity.this, ModelChoiceActivity.class);
                        intent.putExtras(mIntent);
                        startActivity(intent);
                        break;
                }
            } else {
                Toast.makeText(this, R.string.no_connection_toast, Toast.LENGTH_LONG).show();
            }
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}



