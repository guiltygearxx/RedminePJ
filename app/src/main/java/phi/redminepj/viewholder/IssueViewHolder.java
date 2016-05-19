package phi.redminepj.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import phi.redminepj.R;

/**
 * Created by haconglinh1990 on 22/04/2016.
 */
public class IssueViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public ProgressBar progressBarIssue;
    public ImageView viewIconTracker, viewIconUser, viewIconClock;
    public TextView viewNameIssue, viewIdIssue, viewNameProject, viewVersionProject,
            viewStatus, viewPriority, viewNameUserAssigned, viewDueDate, viewNumberPercent;

    public IssueViewHolder(View itemView) {
        super(itemView);
        viewIconUser = (ImageView) itemView.findViewById(R.id.card_view_imgv_icon_user);
        viewIconTracker = (ImageView) itemView.findViewById(R.id.card_view_imgv_icon_tracker);
        viewIconClock = (ImageView) itemView.findViewById(R.id.card_view_imgv_icon_clock);

        progressBarIssue = (ProgressBar) itemView.findViewById(R.id.card_view_progressbar_issue);

        viewNameIssue = (TextView) itemView.findViewById(R.id.card_view_tv_name_issue);
        viewIdIssue = (TextView) itemView.findViewById(R.id.card_view_tv_id_issue);
        viewStatus = (TextView) itemView.findViewById(R.id.card_view_tv_status_issue);
        viewNameUserAssigned = (TextView) itemView.findViewById(R.id.card_view_tv_name_user_assigned);
        viewPriority = (TextView) itemView.findViewById(R.id.card_view_tv_priority);
        viewDueDate = (TextView) itemView.findViewById(R.id.card_view_tv_due_date);
        viewNameProject = (TextView) itemView.findViewById(R.id.card_view_tv_name_project);
        viewVersionProject = (TextView) itemView.findViewById(R.id.card_view_tv_version_project);
        viewNumberPercent = (TextView) itemView.findViewById(R.id.card_view_tv_number_percent);
    }

    @Override
    public void onClick(View view) {

    }
}
