package phi.redminepj.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import phi.redminepj.R;
import phi.redminepj.models.Project;
import phi.redminepj.models.Tracker;
import phi.redminepj.viewholder.ProjectViewHolder1;
import phi.redminepj.viewholder.TrackerViewHolder;

/**
 * Created by haconglinh1990 on 14/04/2016.
 */
public class RecyclerViewTrackersAdapter extends RecyclerView.Adapter<TrackerViewHolder>{
    Context context;
    ArrayList<Tracker> trackersArrayList;
    Tracker tracker;

    // Define listener member variable
    private static OnItemClickListener listener;
    // Define the listener interface
    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }
    // Define the method that allows the parent activity or fragment to define the listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public RecyclerViewTrackersAdapter(Context context, ArrayList<Tracker> trackersArrayList) {
        this.context = context;
        this.trackersArrayList = trackersArrayList;
    }

    @Override
    public TrackerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_project_list1, parent, false);
        return new TrackerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TrackerViewHolder holder, int position) {
        tracker = trackersArrayList.get(position);
        holder.viewNameProject.setText(tracker.getName());
    }

    @Override
    public int getItemCount() {
        return trackersArrayList.size();
    }
}
