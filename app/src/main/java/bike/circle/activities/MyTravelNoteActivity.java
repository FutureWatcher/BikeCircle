package bike.circle.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import bike.circle.app.R;

public class MyTravelNoteActivity extends BaseActivity implements View.OnClickListener{

    private Button mWriteTravelNote;
    private FrameLayout frameLayout;

    private TextView mTitle;

    private static final String LOGINNAME = "nikeName";
    private static final String HASBUTTON = "hasButton";

    public static Intent getIntent(Context context,String nikeName,Boolean hasButton){
        Intent intent = new Intent(context,MyTravelNoteActivity.class);
        intent.putExtra(LOGINNAME,nikeName);
        intent.putExtra(HASBUTTON,hasButton);
        return intent;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_my_travel_note;
    }

    @Override
    protected void initView() {
        setTitle();
        mWriteTravelNote = (Button) findViewById(R.id.wirte_travel_note);
        if(!getIntent().getExtras().getBoolean(HASBUTTON))
            mWriteTravelNote.setVisibility(View.INVISIBLE);
        frameLayout = (FrameLayout) findViewById(R.id.test);
    }

    private void setTitle(){
        mTitle = (TextView) findViewById(R.id.title);
        getIntent().getExtras().getString(LOGINNAME);
        mTitle.setText(getIntent().getExtras().getString(LOGINNAME));
    }

    @Override
    protected void bindEvent() {
        mWriteTravelNote.setOnClickListener(this);
        frameLayout.setOnClickListener(this);
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
            case R.id.wirte_travel_note:startActivity(WriteActivity.getIntent(MyTravelNoteActivity.this));break;
            case R.id.test:startActivity(TravelNoteDetailedActivity.getIntent(MyTravelNoteActivity.this));break;
        }
    }
}
