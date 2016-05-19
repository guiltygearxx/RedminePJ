package phi.redminepj.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import phi.redminepj.R;


/**
 * Created by haconglinh1990 on 14/04/2016.
 */
public class ProjectViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView viewIconProject;
    public TextView viewNameProject;

    public ProjectViewHolder(View itemView) {
        super(itemView);
//        viewIconProject = (ImageView) itemView.findViewById(R.id.icon_project);
        viewNameProject = (TextView) itemView.findViewById(R.id.name_project);

    }

    @Override
    public void onClick(View v) {

    }
}
