package bike.circle.fragement.tab;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import bike.circle.activities.NewCircleActivity;
import bike.circle.activities.SearchActivity;
import bike.circle.app.R;

/**
 * Created by MrH on 2017/5/16.
 */

public class CircleTab extends BaseTab {

    private LinearLayout mJoinCircle;

    private LinearLayout mCreateCircle;

    public CircleTab(Context context) {
        super(context);
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_riding_friends_circle;
    }

    @Override
    protected void initView() {
        mCreateCircle = (LinearLayout) findViewById(R.id.create_circle);
        mJoinCircle = (LinearLayout) findViewById(R.id.join);
    }

    @Override
    protected void bindEvent() {
        mCreateCircle.setOnClickListener(this);
        mJoinCircle.setOnClickListener(this);
    }

    @Override
    protected void service() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.join:startActivity(SearchActivity.getIntent(getContext()));break;
            case R.id.create_circle:startActivity(NewCircleActivity.getIntent(getContext()));break;
        }
    }
}
