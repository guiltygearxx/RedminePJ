package phi.redminepj.network.response;

import java.util.ArrayList;

import phi.redminepj.models.Issue;


/**
 * Created by haconglinh1990 on 09/05/2016.
 */
public interface IssueCallBack {
    void onCompleted(int statusCode, ArrayList<Issue> issueArrayList);
}
