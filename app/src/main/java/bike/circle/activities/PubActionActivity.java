package bike.circle.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import bike.circle.app.R;

public class PubActionActivity extends BaseActivity implements View.OnClickListener {

    private Toolbar toolbar;

    public static Intent getIntent(Context context){
        return new Intent(context,PubActionActivity.class);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_pub_action;
    }

    @Override
    protected void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_q);
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

    @Override
    public void onClick(View v) {

    }
}
