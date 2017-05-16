package bike.circle.activities;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import bike.circle.app.R;

/**
 * Created by MrH on 2017/5/16.
 */

public class FriendInfoActivity extends BaseActivity implements View.OnClickListener{


    private Toolbar toolbar;
    private TextView mTitle;
    private AppBarLayout appBarLayout;
    private TextView mNikeName;
    private ImageView mPortraitBig;
    private NestedScrollView nestedScrollView;
    private LinearLayout mAppbarGroup;
    private LinearLayout main;
    private TextView mSeeMore;

    private static final String HASBUTTON = "hasButton";

    private Button mSendMessage;

    public static Intent getIntent(Context context , boolean i){
        Intent intent = new Intent(context,FriendInfoActivity.class);
        intent.putExtra("hasButton",i);
        return intent;
    }


    @Override
    protected int getContentViewId() {
        return R.layout.activity_userinfo;
    }

    @Override
    protected void initView() {
        mSendMessage = (Button) findViewById(R.id.three_function_button);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbarlayout);
        mNikeName = (TextView) findViewById(R.id.nikename);
        mPortraitBig = (ImageView) findViewById(R.id.portrait_big);
        mTitle = (TextView) findViewById(R.id.title);
        nestedScrollView = (NestedScrollView) findViewById(R.id.nes);
        mAppbarGroup = (LinearLayout) findViewById(R.id.appbar_group);
        main = (LinearLayout) findViewById(R.id.main);
        mSeeMore = (TextView) findViewById(R.id.see_more);
        initActionBar();
    }

    private void initButton(){
        if(getIntent().getExtras().getBoolean(HASBUTTON))
            mSendMessage.setText("发消息");
        else
            mSendMessage.setVisibility(View.INVISIBLE);
    }


    private void initActionBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {

            private FrameLayout.LayoutParams lp;
            private int topMargin;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                Boolean hasButton = getIntent().getExtras().getBoolean(HASBUTTON);
                initButton();
                if(lp == null){
                    lp = (FrameLayout.LayoutParams) main.getLayoutParams();
                    topMargin = lp.topMargin;
                }
                if (getSupportActionBar().getHeight() - appBarLayout.getHeight() == verticalOffset) {
                    mTitle.setText("好友信息");
                    if(hasButton)
                    mSendMessage.setVisibility(View.INVISIBLE);
                    lp.topMargin = 0;
                    main.setLayoutParams(lp);
                    mAppbarGroup.setVisibility(View.INVISIBLE);
                }else if(getSupportActionBar().getHeight() <= appBarLayout.getHeight()){
                    mTitle.setText("");
                    lp.topMargin = topMargin;
                    main.setLayoutParams(lp);
                    mAppbarGroup.setVisibility(View.VISIBLE);
                    if(hasButton)
                    mSendMessage.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    protected void bindEvent() {
        mSendMessage.setOnClickListener(this);
        mSeeMore.setOnClickListener(this);
    }

    @Override
    protected void service() {

    }

    @Override
    protected void init() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.three_function_button:startActivity(ChatActivity.getIntent(FriendInfoActivity.this));break;
            case R.id.see_more:startActivity(MyTravelNoteActivity.getIntent(FriendInfoActivity.this,"XXXX的动态",false));
        }
    }
}
