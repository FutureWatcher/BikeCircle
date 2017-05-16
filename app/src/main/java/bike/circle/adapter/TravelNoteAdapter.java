package bike.circle.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import bike.circle.app.R;
import bike.circle.dto.TravelNoteZoom;

/**
 * Created by MrH on 2017/5/5.
 */

public class TravelNoteAdapter extends RecyclerView.Adapter<TravelNoteViewHolder> {
    private List<TravelNoteZoom> travelNoteZooms ;
    private LayoutInflater layoutInflater;

    private Context context;

    public TravelNoteAdapter(List<TravelNoteZoom> travelNoteZooms ,LayoutInflater layoutInflater,Context context) {
        this.travelNoteZooms = travelNoteZooms;
        this.layoutInflater = layoutInflater;
        this.context = context;
    }

    @Override
    public TravelNoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TravelNoteViewHolder(layoutInflater.inflate(R.layout.travel_note,parent,false),context);
    }

    @Override
    public void onBindViewHolder(TravelNoteViewHolder holder, int position) {
        holder.bindView(travelNoteZooms.get(position));
    }

    @Override
    public int getItemCount() {
        return travelNoteZooms.size();
    }


}
