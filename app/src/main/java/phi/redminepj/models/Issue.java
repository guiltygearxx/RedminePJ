
package phi.redminepj.models;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Issue {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("project")
    @Expose
    private Project project;
    @SerializedName("tracker")
    @Expose
    private Tracker tracker;
    @SerializedName("status")
    @Expose
    private IssueStatus status;
    @SerializedName("priority")
    @Expose
    private Priority priority;
    @SerializedName("author")
    @Expose
    private Author author;
    @SerializedName("assigned_to")
    @Expose
    private AssignedTo assignedTo;
    @SerializedName("subject")
    @Expose
    private String subject;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("start_date")
    @Expose
    private String startDate;

    @SerializedName("due_date")
    @Expose
    private String dueDate;

    @SerializedName("done_ratio")
    @Expose
    private Integer doneRatio;
    @SerializedName("spent_hours")
    @Expose
    private Double spentHours;
    @SerializedName("created_on")
    @Expose
    private String createdOn;
    @SerializedName("updated_on")
    @Expose
    private String updatedOn;
    @SerializedName("attachments")
    @Expose
    private List<Object> attachments = new ArrayList<Object>();
    @SerializedName("journals")
    @Expose
    private List<Journal> journals = new ArrayList<Journal>();

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The project
     */
    public Project getProject() {
        return project;
    }

    /**
     * 
     * @param project
     *     The project
     */
    public void setProject(Project project) {
        this.project = project;
    }

    public String getDueDate() {
        return dueDate;
    }

    /**
     * 
     * @param dueDate
     *     The due_date
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * 
     * @return
     *     The tracker
     */
    public Tracker getTracker() {
        return tracker;
    }

    /**
     * 
     * @param tracker
     *     The tracker
     */
    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }

    /**
     * 
     * @return
     *     The status
     */
    public IssueStatus getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(IssueStatus status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The priority
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * 
     * @param priority
     *     The priority
     */
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    /**
     * 
     * @return
     *     The author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * 
     * @param author
     *     The author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * 
     * @return
     *     The assignedTo
     */
    public AssignedTo getAssignedTo() {
        return assignedTo;
    }

    /**
     * 
     * @param assignedTo
     *     The assigned_to
     */
    public void setAssignedTo(AssignedTo assignedTo) {
        this.assignedTo = assignedTo;
    }

    /**
     * 
     * @return
     *     The subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 
     * @param subject
     *     The subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * 
     * @param startDate
     *     The start_date
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * 
     * @return
     *     The doneRatio
     */
    public Integer getDoneRatio() {
        return doneRatio;
    }

    /**
     * 
     * @param doneRatio
     *     The done_ratio
     */
    public void setDoneRatio(Integer doneRatio) {
        this.doneRatio = doneRatio;
    }

    /**
     * 
     * @return
     *     The spentHours
     */
    public Double getSpentHours() {
        return spentHours;
    }

    /**
     * 
     * @param spentHours
     *     The spent_hours
     */
    public void setSpentHours(Double spentHours) {
        this.spentHours = spentHours;
    }

    /**
     * 
     * @return
     *     The createdOn
     */
    public String getCreatedOn() {
        return createdOn;
    }

    /**
     * 
     * @param createdOn
     *     The created_on
     */
    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * 
     * @return
     *     The updatedOn
     */
    public String getUpdatedOn() {
        return updatedOn;
    }

    /**
     * 
     * @param updatedOn
     *     The updated_on
     */
    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    /**
     * 
     * @return
     *     The attachments
     */
    public List<Object> getAttachments() {
        return attachments;
    }

    /**
     * 
     * @param attachments
     *     The attachments
     */
    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    /**
     * 
     * @return
     *     The journals
     */
    public List<Journal> getJournals() {
        return journals;
    }

    /**
     * 
     * @param journals
     *     The journals
     */
    public void setJournals(List<Journal> journals) {
        this.journals = journals;
    }

}
