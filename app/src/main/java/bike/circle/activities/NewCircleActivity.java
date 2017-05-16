package bike.circle.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import bike.circle.app.R;

public class NewCircleActivity extends BaseActivity {

    public static Intent getIntent(Context context){
        return new Intent(context,NewCircleActivity.class);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_new_circle;
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
