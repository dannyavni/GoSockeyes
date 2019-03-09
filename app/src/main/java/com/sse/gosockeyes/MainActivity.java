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

public class MainActivity extends AppCompatActivity {

    private RecyclerView mMainView;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<RecyclerViewClass> mItems;
    private CustomAdapter mAdapter;

    private Toolbar mTopToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();
        mTopToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mTopToolbar);

        mMainView = (RecyclerView) findViewById(R.id.main_view);

        mMainView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mMainView.setLayoutManager(mLayoutManager);
        //mMainView.setItemAnimator(new DefaultItemAnimator());
        //mMainView.addItemDecoration(new RecyclerViewDecorator(this));
        //creating a rounded drawable for avatar

        class ContentItem {
            public int icon;
            public String url;
            public ContentItem(int icon, String url) {
                this.icon = icon;
                this.url = url;
            }
        }

        ContentItem[] content_items = {
                new ContentItem(R.drawable.twitter_icon, "file:///android_res/raw/crosby.html") ,
                new ContentItem(R.drawable.survey_icon, "file:///android_res/raw/survey.html"),
                new ContentItem(R.drawable.you_tube,"file:///android_res/raw/youtube.html"),
                new ContentItem(R.drawable.twitter_icon,"file:///android_res/raw/salmon.html"),
                new ContentItem(R.drawable.sockeyes_logo_small, "file:///android_res/raw/tickets.html"),
                new ContentItem(R.drawable.espn,"file:///android_res/raw/espn.html"),
                new ContentItem(R.drawable.tinder,"file:///android_res/raw/tinder.html")
        };

        //adding test items to the list
        mItems = new ArrayList<>();
        for(int i=0; i<content_items.length; i++){
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), content_items[i].icon);
            Drawable d = new BitmapDrawable(getResources(), bitmap);
            mItems.add(i, new RecyclerViewClass(content_items[i].url, "", d));
        }
        mAdapter = new CustomAdapter(this, mItems);
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
