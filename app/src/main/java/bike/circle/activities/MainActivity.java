package bike.circle.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import bike.circle.app.R;
import bike.circle.fragement.CircleFragment;
import bike.circle.fragement.HomeFragment;
import bike.circle.fragement.RidingFriendsFragment;

public class MainActivity extends BaseActivity implements FragmentTabHost.OnTabChangeListener ,View.OnClickListener{
    private FragmentTabHost mTabHost;
    private LayoutInflater layoutInflater;
    private SlidingMenu menu;
    private Class mFragmentClass[] = { HomeFragment.class, RidingFriendsFragment.class,CircleFragment.class};

    private int mTabImage[] = { R.drawable.main_home_item,R.drawable.main_friend_item,R.drawable.main_circle_item };
    private String mTabTitle[] = { "首页", "圈友", "骑行圈" };

    private LinearLayout mMyRank;
    private LinearLayout mMyInfo;
    private LinearLayout mMyAction;
    private LinearLayout mAboutUs;

    private TextView mLogOut;

    public static Intent getIntent(Context context){
        return new Intent(context,MainActivity.class);
    }


    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(MainActivity.this,getSupportFragmentManager(),R.id.tabs_container);
        layoutInflater = LayoutInflater.from(MainActivity.this);
        for(int i= 0 ; i< mFragmentClass.length ; i++){
            TabHost.TabSpec tabSpec =mTabHost.newTabSpec(mTabTitle[i]).setIndicator(getTabItemView(i));
            mTabHost.addTab(tabSpec,mFragmentClass[i],null);
        }
        initSlidingMenu();

    }

    @Override
    protected void bindEvent() {
        mTabHost.setOnTabChangedListener(this);
    }

    @Override
    protected void service() {
        updateTab();
    }

    @Override
    protected void init() {

    }

    private View getTabItemView(int index){
        View view = layoutInflater.inflate(R.layout.main_tab_item , null);
        ImageView imageView = (ImageView) view.findViewById(R.id.tab_item);
        imageView.setImageResource(mTabImage[index]);
        TextView textView = (TextView) view.findViewById(R.id.tab_title);
        textView.setText(mTabTitle[index]);
        return view;
    }


    @Override
    public void onTabChanged(String tabId) {
        updateTab();
    }

    public void initSlidingMenu(){
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setFadeEnabled(true);
        menu.setFadeDegree(0.35f);
        menu.setBehindOffset(getWindowManager().getDefaultDisplay().getWidth()/4);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(setMenu());
    }

    private View setMenu(){
        View view = layoutInflater.inflate(R.layout.silder_menu,null);
        mMyInfo = (LinearLayout) view.findViewById(R.id.my_info);
        mMyRank = (LinearLayout) view.findViewById(R.id.my_rank);
        mMyAction = (LinearLayout) view.findViewById(R.id.my_action);
        mAboutUs=(LinearLayout) view.findViewById(R.id.about_us);
        mLogOut = (TextView) view.findViewById(R.id.log_out);
        setMenuEvent();
        return view;
    }

    private void setMenuEvent(){
        mMyInfo.setOnClickListener(this);
        mMyRank.setOnClickListener(this);
        mAboutUs.setOnClickListener(this);
        mMyAction.setOnClickListener(this);
        mLogOut.setOnClickListener(this);
    }

    private void updateTab(){
        TabWidget tabw=mTabHost.getTabWidget();
        for(int i=0;i<tabw.getChildCount();i++){
            View view=tabw.getChildAt(i);
            ImageView iv=(ImageView)view.findViewById(R.id.tab_item);
            if(i==mTabHost.getCurrentTab()){

                ((TextView)view.findViewById(R.id.tab_title)).setTextColor(getResources().getColor(R.color.colorPrimary));

                if(i == 0)
                    iv.setImageResource(R.drawable.main_home_item_active);
                else if(i == 1)
                    iv.setImageResource(R.drawable.main_friend_item_active);
                else if(i == 2)
                    iv.setImageResource(R.drawable.main_circle_item_active);
            }else{

                ((TextView)view.findViewById(R.id.tab_title)).setTextColor(getResources().getColor(R.color.colorLine));

                if(i == 0)
                    iv.setImageResource(R.drawable.main_home_item);
                else if(i == 1)
                    iv.setImageResource(R.drawable.main_friend_item);
                else if(i == 2)
                    iv.setImageResource(R.drawable.main_circle_item);
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:menu.toggle();break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_info:startActivity(UserInfoActivity.getIntent(MainActivity.this));break;
            case R.id.my_rank:startActivity(MyRankActivity.getIntent(MainActivity.this));break;
            case R.id.my_action:startActivity(MyActionActivity.getIntent(MainActivity.this));break;
            case R.id.about_us:startActivity(AboutUsActivity.getIntent(MainActivity.this));break;
            case R.id.log_out:finish();break;
        }
    }
}
