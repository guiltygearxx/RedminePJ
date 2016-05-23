package phi.redminepj.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import phi.redminepj.R;
import phi.redminepj.models.IssueStatus;
import phi.redminepj.viewholder.StatusViewHolder;

/**
 * Created by haconglinh1990 on 14/04/2016.
 */
public class RecyclerViewStatusAdapter extends RecyclerView.Adapter<StatusViewHolder>{
    Context context;
    ArrayList<IssueStatus> statusArrayList;
    IssueStatus status;

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

    public RecyclerViewStatusAdapter(Context context, ArrayList<IssueStatus> statusArrayList) {
        this.context = context;
        this.statusArrayList = statusArrayList;
    }

    @Override
    public StatusViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_project_list1, parent, false);
        return new StatusViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StatusViewHolder holder, int position) {
        status = statusArrayList.get(position);
        holder.viewNameProject.setText(status.getName());
    }

    @Override
    public int getItemCount() {
        return statusArrayList.size();
    }
}
