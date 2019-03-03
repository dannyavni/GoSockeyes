package com.sse.gosockeyes;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

//import com.zemosolabs.atif.recyclerview.R;
//import com.zemosolabs.atif.recyclerview.utils.RecyclerViewClass;

public class CustomSurveyAdapter extends RecyclerView.Adapter<CustomSurveyAdapter.CustomRecyclerViewHolder>{

    List<RecyclerViewClass> mItems;
    Context mContext;
    boolean onLongPressReceived = false;
    UpdateMainClass updateMainClass;

    /**
     * Contructor to initialize context and list items.
     * @param context Context of the Activity on which RecyclerView is initialised
     * @param items List of POJO object that contains the data to update the rows
     */
    public CustomSurveyAdapter(Context context, List<RecyclerViewClass> items){
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
                .inflate(R.layout.survey_card_layout, parent, false);
        //set the margin if any, will be discussed in next blog
        return new CustomRecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CustomRecyclerViewHolder holder, int position) {
        holder.mPlayerImageView.setImageDrawable(mItems.get(position).getmImage_url());
        holder.mPlayerNameTextView.setText(mItems.get(position).getMessage1());
        //holder.mMsg2.setText(mItems.get(position).getMessage2());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class CustomRecyclerViewHolder extends RecyclerView.ViewHolder{

        private ImageView mPlayerImageView;
        private TextView  mPlayerNameTextView;
        private CardView  cardView;


        /**
         * Initializes all the views of a ViewHolder
         * @param itemView parent view in which all the List Item views are present
         */
        public CustomRecyclerViewHolder(View itemView) {
            super(itemView);
            mPlayerImageView = (ImageView)itemView.findViewById(R.id.player_image);
            mPlayerNameTextView = (TextView) itemView.findViewById(R.id.player_name);

            cardView = (CardView)itemView.findViewById(R.id.survey_card_layout);

        }
    }
    public interface UpdateMainClass{
        void updateItemList(int position);
        void updateListBackground(int position, boolean isChecked);
    }
}
