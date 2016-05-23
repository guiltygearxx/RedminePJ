package phi.redminepj.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import phi.redminepj.R;


/**
 * Created by haconglinh1990 on 14/04/2016.
 */
public class StatusViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public RadioButton rbProject;
    public TextView viewNameProject;

    public StatusViewHolder(View itemView) {
        super(itemView);
        rbProject = (RadioButton) itemView.findViewById(R.id.rbProject);
        viewNameProject = (TextView) itemView.findViewById(R.id.name_project);

    }

    @Override
    public void onClick(View v) {

    }
}
