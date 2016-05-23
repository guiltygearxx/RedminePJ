package phi.redminepj.models;

import java.util.ArrayList;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by guiltygearxx on 20-05-2016.
 */
@Generated("org.jsonschema2pojo")
public class StatusObjectModel {

    @SerializedName("issue_statuses")
    @Expose
    private ArrayList<IssueStatus> issueStatuses = new ArrayList<IssueStatus>();

    /**
     * @return The issueStatuses
     */
    public ArrayList<IssueStatus> getIssueStatuses() {
        return issueStatuses;
    }

    /**
     * @param issueStatuses The issue_statuses
     */
    public void setIssueStatuses(ArrayList<IssueStatus> issueStatuses) {
        this.issueStatuses = issueStatuses;
    }


}
