package bike.circle.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import bike.circle.app.R;

public class MapActivity extends BaseActivity {

    public static Intent getIntent(Context context){
        return new Intent(context,MapActivity.class);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_map;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void bindEvent() {

    }

    @Override
    protected void service() {

    }

    @Override
    protected void init() {

    }

}
