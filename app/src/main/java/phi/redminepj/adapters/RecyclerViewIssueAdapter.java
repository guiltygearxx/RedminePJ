package phi.redminepj.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.nfc.Tag;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.ArrayList;

import phi.redminepj.R;
import phi.redminepj.activity.DetailsIssueInProjectActivity;
import phi.redminepj.activity.IssueInProjectActivity;
import phi.redminepj.models.Issue;
import phi.redminepj.network.api.APIClient;
import phi.redminepj.viewholder.IssueViewHolder;


/**
 * Created by haconglinh1990 on 22/04/2016.
 */
public class RecyclerViewIssueAdapter extends RecyclerView.Adapter<IssueViewHolder>{
    public static final String PREFS_ID_ISSUE="idoissue";
    Context context;
    ArrayList<Issue> issuesList;
    Issue issues;

    public RecyclerViewIssueAdapter(Context context, ArrayList<Issue> issuesList) {
        this.context = context;
        this.issuesList = issuesList;
    }

    @Override
    public IssueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_issue_list, parent, false);
        return new IssueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IssueViewHolder holder, final int position) {
        int color, textColor;
        issues = issuesList.get(position);

        holder.viewNameIssue.setText(issues.getSubject());
        //Log.v(APIClient.MY_TAG, "Version: " + issues.getFixedVersion().getName());
        holder.viewIdIssue.setText("#" + issues.getId());
        holder.viewStatus.setText("  " + issues.getStatus().getName());

        switch (issues.getPriority().getName()) {
            case "Low":
                textColor = Color.rgb(191, 255, 0);
                break;

            case "Normal":
                textColor = Color.rgb(64, 255, 0);
                break;
            case "High":
                textColor = Color.rgb(255, 128, 0);
                break;
            case "Urgent":
                textColor = Color.rgb(255, 0, 0);
                break;
            case "Immediate":
                textColor = Color.rgb(0, 0, 0);
                break;

            default:
                textColor = Color.rgb(255, 230, 230);
                break;
        }

        holder.viewPriority.setTextColor(textColor);
//        holder.viewNameUserAssigned.setText(" " + issues.getAssignedTo().getName());
        holder.viewPriority.setText("  " + issues.getPriority().getName());
        holder.viewDueDate.setText(" " + issues.getDueDate());
        holder.viewNameProject.setText(issues.getProject().getName());
        holder.viewVersionProject.setText("  v0.1");
        holder.viewNumberPercent.setText(issues.getDoneRatio() + "%");

//        TextDrawable iconUserDrawable = TextDrawable.builder()
//                .beginConfig()
//                .fontSize(16) /* size in px */
//                .bold()
//                .endConfig()
//                .buildRound(issues.getAuthor().getName().substring(0, 1), ColorGenerator.MATERIAL.getRandomColor());
//        holder.viewIconUser.setImageDrawable(iconUserDrawable);

        switch (issues.getTracker().getName()) {
            case "Feature":
                color = Color.rgb(0, 0, 255);
                break;
            case "Develop":
                color = Color.rgb(0, 191, 255);
                break;
            case "Design":
                color = Color.rgb(0, 255, 255);
                break;
            case "Support":
                color = Color.rgb(0, 255, 128);
                break;
            case "Test":
                color = Color.rgb(64, 255, 0);
                break;
            case "Bug":
                color = Color.rgb(255, 64, 0);
                break;
            case "Research":
                color = Color.rgb(255, 255, 0);
                break;

            default:
                color = Color.rgb(255, 230, 230);
                break;
        }


        TextDrawable iconTrackerDrawable = TextDrawable.builder()
                .beginConfig()
                .textColor(Color.BLACK)
                .fontSize(20) /* size in px */
                .bold()
                .endConfig()
                .buildRoundRect(issues.getTracker().getName(), color, 4);

        holder.viewIconTracker.setImageDrawable(iconTrackerDrawable);
        holder.viewIconClock.setImageResource(R.drawable.icon_clock);

        holder.progressBarIssue.setProgress(issues.getDoneRatio());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Issue issue = issuesList.get(position);

                Intent intent = new Intent(context, DetailsIssueInProjectActivity.class);
                context.startActivity(intent);

                SharedPreferences preferences=context.getSharedPreferences(PREFS_ID_ISSUE, Context.MODE_PRIVATE);
                SharedPreferences.Editor edit=preferences.edit();
                edit.putInt("id_issue_in_details", issue.getId());
                edit.commit();

                Log.d(APIClient.MY_TAG, "ID Issue of Project: "+issue.getId());
                Log.d(APIClient.MY_TAG, "ID Issue of Project: "+issue.getSubject());
            }
        });
    }

    @Override
    public int getItemCount() {
        return issuesList.size();
    }
}
