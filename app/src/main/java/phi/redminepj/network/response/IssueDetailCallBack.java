package phi.redminepj.network.response;

import java.text.ParseException;

import phi.redminepj.models.Issue;

/**
 * Created by guiltygearxx on 18-05-2016.
 */
public interface IssueDetailCallBack {
    void onCompleted(int statusCode, Issue issue) throws ParseException;
}
