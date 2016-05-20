package phi.redminepj.adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import phi.redminepj.R;
import phi.redminepj.activity.IssueInProjectActivity;
import phi.redminepj.models.Project;
import phi.redminepj.network.api.APIClient;
import phi.redminepj.viewholder.ProjectViewHolder;
import phi.redminepj.viewholder.ProjectViewHolder1;

/**
 * Created by haconglinh1990 on 14/04/2016.
 */
public class RecyclerViewProjectAdapter1 extends RecyclerView.Adapter<ProjectViewHolder1>{
    public static final String PREFS_ID_PROJECT="idofproject";
    Context context;
    ArrayList<Project> projectArrayList;
    Project project;

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

    public RecyclerViewProjectAdapter1(Context context, ArrayList<Project> projectArrayList) {
        this.context = context;
        this.projectArrayList = projectArrayList;
    }

    @Override
    public ProjectViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_project_list1, parent, false);
        return new ProjectViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(final ProjectViewHolder1 holder, final int position) {
        project = projectArrayList.get(position);
        holder.viewNameProject.setText(project.getName());
    }

    @Override
    public int getItemCount() {
        return projectArrayList.size();
    }
}
