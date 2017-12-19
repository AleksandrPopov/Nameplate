package com.alexanderpopov.car.nameplate.activitys;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ProgressBar;

import com.alexanderpopov.car.nameplate.R;
import com.alexanderpopov.car.nameplate.adapters.MainActivityRecyclerViewAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ModelChoiceActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static final String MODEL = "URL_SEND";

    private GridView mListModel;
    private ArrayList<String> mModelArray;
    private ArrayAdapter<String> mAdapter;
    private String mUrl;
    private Intent mIntent;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        mModelArray = new ArrayList<>();

        mListModel = findViewById(R.id.listModelAndYearChoiceActivity);

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mModelArray);
        mListModel.setAdapter(mAdapter);
        mListModel.setNumColumns(2);
        mListModel.setOnItemClickListener(this);

        mIntent = getIntent();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(mIntent.getIntExtra(MainActivityRecyclerViewAdapter.CAR_NAME_TEXT, 1));

        String mName = getString(mIntent.getIntExtra(MainActivityRecyclerViewAdapter.CAR_NAME_TEXT, 1)).toLowerCase();

        if (Objects.equals(mName, "land rover")) {
            mName = "land-rover";
        }
        mUrl = "http://xn--80ahnfbbysk.xn--p1ai/" + mName + ".html";
        modelChoice();
    }

    private void modelChoice() {
        @SuppressLint("StaticFieldLeak")
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {

            ProgressBar progressBar = findViewById(R.id.progressBarModel);

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Document siteUrl = Jsoup.connect(mUrl).get();
                    Element table = siteUrl.select("table.mdl").first();
                    Elements tr = table.select("tr");
                    for (int i = 0; i < tr.size(); i++) {
                        Element row = tr.get(i);
                        Elements column = row.select("td");
                        for (Element e : column) {
                            String model = e.select("td").attr("id");
                            mModelArray.add(model);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                mListModel.setAdapter(mAdapter);
                progressBar.setVisibility(View.GONE);
            }
        };
        task.execute();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, YearChoiceActivity.class);
        String model = mModelArray.get(position);
        intent.putExtras(mIntent);
        intent.putExtra(MODEL, model);
        startActivity(intent);
    }
}

