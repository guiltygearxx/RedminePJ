
package phi.redminepj.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class IssueDetailModel {

    @SerializedName("issue")
    @Expose
    private Issue issue;

    /**
     * 
     * @return
     *     The issue
     */
    public Issue getIssue() {
        return issue;
    }

    /**
     * 
     * @param issue
     *     The issue
     */
    public void setIssue(Issue issue) {
        this.issue = issue;
    }

}
