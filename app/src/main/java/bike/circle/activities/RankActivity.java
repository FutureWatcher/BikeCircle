package bike.circle.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import bike.circle.app.R;

public class RankActivity extends BaseActivity implements View.OnClickListener{

    private ImageView mBack;

    public static Intent getIntent(Context context){
        return new Intent(context,RankActivity.class);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_rank;
    }

    @Override
    protected void initView() {
        mBack = (ImageView) findViewById(R.id.back);

    }

    @Override
    protected void bindEvent() {
        mBack.setOnClickListener(this);
    }

    @Override
    protected void service() {

    }

    @Override
    protected void init() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:finish();break;
        }
    }
}
