package phi.redminepj.network.response;

import java.util.ArrayList;

import phi.redminepj.models.IssueStatus;
import phi.redminepj.models.Membership;

/**
 * Created by haconglinh1990 on 09/05/2016.
 */
public interface MemberCallBack {
    void onCompleted(int statusCode, ArrayList<Membership> memberships);
}
