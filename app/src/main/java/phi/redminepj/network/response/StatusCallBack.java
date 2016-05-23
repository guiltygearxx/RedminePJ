package phi.redminepj.network.response;

import java.util.ArrayList;

import phi.redminepj.models.IssueStatus;

/**
 * Created by haconglinh1990 on 09/05/2016.
 */
public interface StatusCallBack {
    void onCompleted(int statusCode, ArrayList<IssueStatus> statusArrayList);
}
