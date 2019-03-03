package com.sse.gosockeyes;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//import com.zemosolabs.atif.recyclerview.R;
//import com.zemosolabs.atif.recyclerview.utils.RecyclerViewClass;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomRecyclerViewHolder>{

    List<RecyclerViewClass> mItems;
    Context mContext;
    boolean onLongPressReceived = false;
    UpdateMainClass updateMainClass;

    /**
     * Contructor to initialize context and list items.
     * @param context Context of the Activity on which RecyclerView is initialised
     * @param items List of POJO object that contains the data to update the rows
     */
    public CustomAdapter(Context context, List<RecyclerViewClass> items){
        mContext = context;
        mItems = items;
        //Check whether the Activity implements UpdateMainClass Interface or not
        if(context instanceof UpdateMainClass){
            updateMainClass = (UpdateMainClass)context;
        }
    }

    /**
     * <p>This method updates the long press status variable when called from the Activity</p>
     * <p>Helpful to prevent any unwanted changes to status variable</p>
     * @param status tell whether whether long press is clicked or not
     */
    public void setOnLongPressStatus(boolean status){
        onLongPressReceived = status;
        notifyDataSetChanged();
    }

    /**
     * Provides the long press status to the Activity
     * @return longPressReceived status
     */
    public boolean getLongPressStatus(){
        return onLongPressReceived;
    }

    @Override
    public CustomRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(mContext)
                .inflate(R.layout.card_layout, parent, false);
        //set the margin if any, will be discussed in next blog
        return new CustomRecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CustomRecyclerViewHolder holder, int position) {
        holder.mContentIcon.setImageDrawable(mItems.get(position).getmImage_url());
        holder.mContentText.loadUrl(mItems.get(position).getMessage1());
        holder.cardViewLayout.setBackgroundColor(mContext.getResources().getColor(R.color.colorPrimaryDark));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class CustomRecyclerViewHolder extends RecyclerView.ViewHolder{

        private ImageView mContentIcon;
        private WebView mContentText;
        private CardView  cardView;
        private LinearLayout cardViewLayout;


        /**
         * Initializes all the views of a ViewHolder
         * @param itemView parent view in which all the List Item views are present
         */
        public CustomRecyclerViewHolder(View itemView) {
            super(itemView);
            mContentIcon = (ImageView)itemView.findViewById(R.id.content_icon);
            mContentText = (WebView) itemView.findViewById(R.id.content_text);
            mContentText.getSettings().setDomStorageEnabled(true);
            mContentText.getSettings().setAppCacheEnabled(true);
            mContentText.getSettings().setLoadsImagesAutomatically(true);
            mContentText.getSettings().setJavaScriptEnabled(true);
            mContentText.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);

            mContentText.setWebViewClient(new WebViewClientHandler(mContext));

            cardView = (CardView)itemView.findViewById(R.id.card_layout);
            cardViewLayout = (LinearLayout) itemView.findViewById(R.id.card_layout_holder);
        }
    }



    public interface UpdateMainClass{
        void updateItemList(int position);
        void updateListBackground(int position, boolean isChecked);
    }
}
