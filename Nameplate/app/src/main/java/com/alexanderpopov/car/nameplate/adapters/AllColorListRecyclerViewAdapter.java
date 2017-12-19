package com.alexanderpopov.car.nameplate.adapters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alexanderpopov.car.nameplate.resources.ParseColorResource;
import com.alexanderpopov.car.nameplate.R;

import java.util.ArrayList;

public class AllColorListRecyclerViewAdapter extends RecyclerView.Adapter<AllColorListRecyclerViewAdapter.ColorViewHolder> {
    private Context mContext;
    private ArrayList<ParseColorResource> mArrayColorInfo;
    private View v;

    public AllColorListRecyclerViewAdapter(Context context, ArrayList<ParseColorResource> arrayColorInfo) {
        mArrayColorInfo = arrayColorInfo;
        mContext = context.getApplicationContext();
    }
    @Override
    public ColorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_color_table, parent, false);
        holder = new ColorViewHolder(v);
        return (ColorViewHolder) holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    @Override
    public void onBindViewHolder(ColorViewHolder holder, int position) {
        holder.mColor.setBackgroundColor(Color.parseColor(mArrayColorInfo.get(position).getColor()));
        holder.mColorName.setText(mArrayColorInfo.get(position).getColorName());
        holder.mColorCode.setText(mArrayColorInfo.get(position).getColorCode());
        holder.setItem(mArrayColorInfo.get(position).getColor());
    }

    @Override
    public int getItemCount() {
        return mArrayColorInfo.size();
    }

    class ColorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private LinearLayout mColor;
        private TextView mColorName;
        private TextView mColorCode;

        @SuppressLint({"ResourceType", "CutPasteId"})

        ColorViewHolder(View itemView) {
            super(itemView);

            mColor = itemView.findViewById(R.id.colorItemColorTable);
            mColorName = itemView.findViewById(R.id.colorNameColorTable);
            mColorCode = itemView.findViewById(R.id.colorCodeColorTable);

            itemView.setOnClickListener(this);

            mContext = itemView.getContext();
        }

        private void setItem(String item) {
            String mItem = item;
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder;
            AlertDialog dialog;
            builder = new AlertDialog.Builder(mContext);
            builder.setView(R.layout.dialog_color_item);
            dialog = builder.create();
            dialog.show();
        }
    }
}
