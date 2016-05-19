package phi.redminepj.network.response;

import java.util.ArrayList;

import phi.redminepj.models.Project;
import phi.redminepj.models.Projects;

/**
 * Created by haconglinh1990 on 09/05/2016.
 */
public interface ProjectCallBack {
    void onCompleted(int statusCode, ArrayList<Project> projectArrayList);
}
