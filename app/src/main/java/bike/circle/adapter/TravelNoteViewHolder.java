package bike.circle.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import bike.circle.activities.TravelNoteDetailedActivity;
import bike.circle.app.R;
import bike.circle.dto.TravelNoteZoom;

/**
 * Created by MrH on 2017/5/5.
 */

public class TravelNoteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private ImageView mPortrait;
    private TextView mNikeName;
    private TextView mContent;
    private ImageView mImage_one;
    private ImageView mImage_two;
    private ImageView mLike;
    private ImageView mComment;
    private TextView mLikeCount;
    private TextView mCommentCount;

    private Context context;

    public TravelNoteViewHolder(View itemView , Context context) {
        super(itemView);
        mContent = (TextView) itemView.findViewById(R.id.content);
        this.context = context;
    }

    public void bindView(TravelNoteZoom travelNoteZoom)
    {
        mContent.setText(travelNoteZoom.getPartContent());
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        context.startActivity(TravelNoteDetailedActivity.getIntent(context));
    }
}
