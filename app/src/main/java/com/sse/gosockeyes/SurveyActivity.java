package com.sse.gosockeyes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class SurveyActivity extends AppCompatActivity {

    private RecyclerView mMainView;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<RecyclerViewClass> mItems;
    private CustomSurveyAdapter mAdapter;

    private Toolbar mTopToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);


        mMainView = (RecyclerView) findViewById(R.id.survey_view);

        mMainView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mMainView.setLayoutManager(mLayoutManager);

        mTopToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mTopToolbar);

        int[] player_images = {
                R.drawable.brady_austin,
                R.drawable.alexander_burmistrov,
                R.drawable.jared_boll,
                R.drawable.linus_arnesson,
                R.drawable.matt_bartkowski
        };

        String[] player_names = {
                "Brady Austin",
                "Alexander Burmistrov",
                "Jared Boll",
                "Linus Arnesson",
                "Matt Bartkowski"
        };

        String[] player_info = {
                "RW, 26, 6'3\",\nBoston Bruins ",
                "LW, 28, 6'1\",\nChicago Blackhawks",
                "C, 32, 6'0\",\nPittsburg Penguins",
                "RW, 22, 5'11\",\nDown the Block",
                "LW, 24, 6'2\",\nWashington Capitals"
        };

        //adding test items to the list
        mItems = new ArrayList<>();
        for(int i=0; i<5; i++){
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), player_images[i]);
            Drawable d = new BitmapDrawable(getResources(), bitmap);
            mItems.add(i, new RecyclerViewClass(player_names[i], player_info[i], d));
        }
        mAdapter = new CustomSurveyAdapter(this, mItems);
        mMainView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
