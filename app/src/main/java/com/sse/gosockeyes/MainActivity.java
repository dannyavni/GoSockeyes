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

public class MainActivity extends AppCompatActivity {

    private RecyclerView mMainView;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<RecyclerViewClass> mItems;
    private CustomAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainView = (RecyclerView) findViewById(R.id.main_view);

        mMainView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mMainView.setLayoutManager(mLayoutManager);
        //mMainView.setItemAnimator(new DefaultItemAnimator());
        //mMainView.addItemDecoration(new RecyclerViewDecorator(this));
        //creating a rounded drawable for avatar

        int[] content_Icons = {
                R.drawable.twitter_icon,
                R.drawable.survey_icon,
                R.drawable.you_tube,
                R.drawable.twitter_icon,
        };

        String[] content_Text = {
                "Did you see what just happened?!? Crosby is signing up with the Sockeyes, we are going for the cup. #winners",
                "Help the Sockeys pick the best team! Answer our draft survey",
                "Upload a view to the Sockeyes channel for a chance to win season tickets. <a href='https://www.youtube.com'>Tap Here!</a> ",
                "Should Seattle restaurants stop serving Salmon out of respect to our new team?"

        };

        //adding test items to the list
        mItems = new ArrayList<>();
        for(int i=0; i<content_Text.length; i++){
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), content_Icons[i]);
            Drawable d = new BitmapDrawable(getResources(), bitmap);
            mItems.add(i, new RecyclerViewClass(content_Text[i], "", d));
        }
        mAdapter = new CustomAdapter(this, mItems);
        mMainView.setAdapter(mAdapter);
    }


}