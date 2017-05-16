package bike.circle.fragement;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import bike.circle.activities.MainActivity;
import bike.circle.activities.MapActivity;
import bike.circle.activities.MyActionActivity;
import bike.circle.activities.MyTravelNoteActivity;
import bike.circle.adapter.TravelNoteAdapter;
import bike.circle.app.R;
import bike.circle.dto.TravelNoteZoom;
import bike.circle.pool.NetResPool;
import bike.circle.pool.StaticPool;

public class CircleFragment extends Fragment implements View.OnClickListener{
    private View view;
    private Toolbar toolbar;
    private RecyclerView mFriendTravel;
    private LinearLayoutManager mLinearLayoutManager;
    private List<TravelNoteZoom> mHotTravelNotes;
    private TravelNoteAdapter mTravelNoteAdapter;


    private Button mTravelNote;
    private Button mAction;

    private FrameLayout mActionOne;



    public CircleFragment() {
    }

    public static CircleFragment newInstance() {
        CircleFragment fragment = new CircleFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_circle, container, false);
        if(getActivity()!=null){
            initView();
            bindEvent();
        }
        return view;
    }

    private void bindEvent() {
        mTravelNote.setOnClickListener(this);
        mAction.setOnClickListener(this);
        mActionOne.setOnClickListener(this);
    }

    private void initView() {
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mFriendTravel = (RecyclerView) view.findViewById(R.id.firend_travel);
        mHotTravelNotes = new ArrayList<>();
        mTravelNoteAdapter = new TravelNoteAdapter( mHotTravelNotes , LayoutInflater.from(getActivity()));
        mFriendTravel.setAdapter(mTravelNoteAdapter);
        mFriendTravel.setLayoutManager(mLinearLayoutManager);
        new StaticPool(getActivity()).getHotTravelNote(new NetResPool.PoolCallBack() {
            @Override
            public void before() {

            }
            @Override
            public void after(Object res) {
                mHotTravelNotes.addAll((Collection<? extends TravelNoteZoom>) res);
                mTravelNoteAdapter.notifyDataSetChanged();
            }

        });
        setToolBar();
        mTravelNote = (Button) view.findViewById(R.id.travel_note);
        mAction = (Button) view.findViewById(R.id.action);
        mActionOne = (FrameLayout) view.findViewById(R.id.action_one);
    }


    private void setToolBar(){
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_menu_friend));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.travel_note:getActivity().startActivity(MyTravelNoteActivity.getIntent(getActivity()));break;
            case R.id.action:getActivity().startActivity(MyActionActivity.getIntent(getActivity()));break;
            case R.id.action_one:action();break;
        }
    }

    private void action(){
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.activity_my_action_dialog,null);
        TextView start = (TextView) view.findViewById(R.id.start);
        TextView end = (TextView) view.findViewById(R.id.end);
        start.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(MapActivity.getIntent(getActivity()));
            }
        });
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MapActivity.getIntent(getActivity()));
            }
        });

        Button mJoin = (Button) view.findViewById(R.id.funciton_button);
        mJoin.setText("加入");
        new AlertDialog.Builder(getActivity()).setView(view).create().show();
    }

}
