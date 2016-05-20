package phi.redminepj.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import phi.redminepj.R;
import phi.redminepj.models.Project;

/**
 * Created by guiltygearxx on 20-05-2016.
 */
public class Item_project_adapter extends ArrayAdapter<Project> {
    public Item_project_adapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public Item_project_adapter(Context context, int resource, List<Project> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        Project project = getItem(position);
        if (project != null) {
//            TextView txtProject = (TextView) v.findViewById(R.id.txtProject);
//            txtProject.setText(project.getName());
        }
        return v;
    }
}
