package phi.redminepj.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import phi.redminepj.R;
import phi.redminepj.activity.IssueInProjectActivity;
import phi.redminepj.models.Project;
import phi.redminepj.network.api.APIClient;
import phi.redminepj.network.response.ItemItemClickListener;
import phi.redminepj.viewholder.ProjectViewHolder;

/**
 * Created by haconglinh1990 on 14/04/2016.
 */
public class RecyclerViewProjectAdapter extends RecyclerView.Adapter<ProjectViewHolder>{
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

    public RecyclerViewProjectAdapter(Context context, ArrayList<Project> projectArrayList) {
        this.context = context;
        this.projectArrayList = projectArrayList;
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_project_list, parent, false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProjectViewHolder holder, final int position) {
        project = projectArrayList.get(position);
        holder.viewNameProject.setText(project.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Project project = projectArrayList.get(position);
                Intent intent = new Intent(context, IssueInProjectActivity.class);
                context.startActivity(intent);

                SharedPreferences preferences=context.getSharedPreferences(PREFS_ID_PROJECT, Context.MODE_PRIVATE);
                SharedPreferences.Editor edit=preferences.edit();
                edit.putInt("id_issue_of_project", project.getId());
                edit.commit();

                Log.d(APIClient.MY_TAG, String.valueOf(project.getId()));
                Log.d(APIClient.MY_TAG, String.valueOf(project.getName()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return projectArrayList.size();
    }
}
