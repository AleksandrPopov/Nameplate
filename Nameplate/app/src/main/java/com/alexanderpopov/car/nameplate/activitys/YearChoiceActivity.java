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

public class YearChoiceActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static final String URL = "URL";
    public static final String YEAR = "YEAR";

    private GridView mGridView;
    private ArrayList<String> mArray;
    private ArrayList<String> mArrayUrl;
    private ArrayAdapter<String> mAdapter;
    private String mFinalUrl;
    private Intent mIntent;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        mIntent = getIntent();

        mGridView = findViewById(R.id.listModelAndYearChoiceActivity);
        mArray = new ArrayList<>();
        mArrayUrl = new ArrayList<>();
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mArray);
        mGridView.setOnItemClickListener(this);

        String mModel = mIntent.getStringExtra(ModelChoiceActivity.MODEL);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(mModel);

        String mName = getString(mIntent.getIntExtra(MainActivityRecyclerViewAdapter.CAR_NAME_TEXT, 1));

        if (Objects.equals(mName, "MERCEDES")) {
            mName = mName + "benz";
        }
        if (Objects.equals(mName, "LAND ROVER")) {
            mName = "landrover";
        }

        mFinalUrl = "http://xn--80ahnfbbysk.xn--p1ai/8.php?mk=" + mName + "&md=" + mModel;
        yearChoice();
    }

    private void yearChoice() {
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
                    Document doc = Jsoup.connect(mFinalUrl).get();
                    Elements all = doc.select("ul");
                    for (int i = 0; i < all.size(); i++) {
                        Element ul = all.get(i);
                        Elements li = ul.select("li");
                        for (Element element : li) {
                            Elements years = element.select("li");
                            String yearsUrl = element.select("a").attr("href");
                            mArray.add(years.text());
                            mArrayUrl.add(yearsUrl);
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
                mGridView.setAdapter(mAdapter);
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
        Intent intent2 = new Intent(this, ModelColorListActivity.class);
        String url = mArrayUrl.get(position);
        String year = mArray.get(position);
        intent2.putExtras(mIntent);
        intent2.putExtra(URL, url);
        intent2.putExtra(YEAR, year);
        startActivity(intent2);
    }
}
