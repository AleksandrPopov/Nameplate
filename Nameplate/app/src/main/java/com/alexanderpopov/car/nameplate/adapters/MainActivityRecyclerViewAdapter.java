package com.alexanderpopov.car.nameplate.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexanderpopov.car.nameplate.resources.CarResource;
import com.alexanderpopov.car.nameplate.activitys.CarInfoActivity;
import com.alexanderpopov.car.nameplate.R;

import java.util.ArrayList;


public class MainActivityRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final String CAR_NAME_TEXT = "CAR_NAME_TEXT";
    private static final String CAR_LOGO_IMAGE = "CAR_LOGO_IMAGE";
    public static final String CAR_PLATE_SCHEME_IMAGE = "CAR_PLATE_SCHEME_IMAGE";
    public static final String CAR_PLATE_SCHEME_TEXT = "CAR_PLATE_SCHEME_TEXT";
    public static final String CAR_VIN_PHOTO = "CAR_VIN_PHOTO";
    public static final String CAR_VIN_PHOTO2 = "CAR_VIN_PHOTO2";
    public static final String CAR_COLOR_TABLE = "CAR_COLOR_TABLE";

    private ArrayList<CarResource> mCarResource;
    private Context context;

    public MainActivityRecyclerViewAdapter(ArrayList<CarResource> imageAndName, Context context) {
        mCarResource = imageAndName;
        this.context = context.getApplicationContext();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_activity_main, parent, false);
        holder = new CarViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CarViewHolder carViewHolder = (CarViewHolder) holder;
        carViewHolder.carName.setText(mCarResource.get(position).getCarName());
        carViewHolder.carModel.setImageResource(mCarResource.get(position).getCarLabel());
        carViewHolder.setItem(mCarResource.get(position).getCarLabel());
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mCarResource.size();
    }

    private class CarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView carName;
        private ImageView carModel;

        private CarViewHolder(View itemView) {
            super(itemView);

            carName = itemView.findViewById(R.id.nameCarTextViewRecyclerViewMainActivity);
            carModel = itemView.findViewById(R.id.imageImageViewRecyclerViewMainActivity);
            itemView.setOnClickListener(this);
            context = itemView.getContext();
        }

        private void setItem(int item) {
            int mItem = item;
        }

        @Override
        public void onClick(View v) {
            final Intent intent = new Intent(context, CarInfoActivity.class);
            intent.putExtra(CAR_NAME_TEXT, mCarResource.get(getLayoutPosition()).getCarName());
            intent.putExtra(CAR_LOGO_IMAGE, mCarResource.get(getLayoutPosition()).getCarLabel());
            intent.putExtra(CAR_PLATE_SCHEME_IMAGE, mCarResource.get(getLayoutPosition()).getCarVinSchemeImage());
            intent.putExtra(CAR_PLATE_SCHEME_TEXT, mCarResource.get(getLayoutPosition()).getCarSchemeInfoTex());
            intent.putExtra(CAR_VIN_PHOTO, mCarResource.get(getLayoutPosition()).getCarVinImage());
            intent.putExtra(CAR_VIN_PHOTO2, mCarResource.get(getLayoutPosition()).getCarVinImage2());
            intent.putExtra(CAR_COLOR_TABLE, mCarResource.get(getLayoutPosition()).getCarUrlColor());
            context.startActivity(intent);
        }
    }
}

