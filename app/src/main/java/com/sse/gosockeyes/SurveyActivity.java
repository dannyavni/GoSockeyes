package com.sse.gosockeyes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class SurveyActivity extends AppCompatActivity {

    private RecyclerView mMainView;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<RecyclerViewClass> mItems;
    private CustomAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        mMainView = (RecyclerView) findViewById(R.id.survey_view);

        mMainView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mMainView.setLayoutManager(mLayoutManager);
        //mMainView.setItemAnimator(new DefaultItemAnimator());
        //mMainView.addItemDecoration(new RecyclerViewDecorator(this));
        //creating a rounded drawable for avatar

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


        //adding test items to the list
        mItems = new ArrayList<>();
        for(int i=0; i<5; i++){
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), player_images[i]);
            Drawable d = new BitmapDrawable(getResources(), bitmap);
            mItems.add(i, new RecyclerViewClass(player_names[i], i+" string2", d));
        }
        mAdapter = new CustomAdapter(this, mItems);
        mMainView.setAdapter(mAdapter);
    }


}
