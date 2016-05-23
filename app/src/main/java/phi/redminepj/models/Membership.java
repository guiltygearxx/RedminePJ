package phi.redminepj.models;

/**
 * Created by guiltygearxx on 20-05-2016.
 */
import java.util.ArrayList;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Membership {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("project")
    @Expose
    private Project project;
    @SerializedName("user")
    @Expose
    private UserSmall user;
    @SerializedName("roles")
    @Expose
    private ArrayList<Role> roles = new ArrayList<Role>();

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The project
     */
    public Project getProject() {
        return project;
    }

    /**
     *
     * @param project
     * The project
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     *
     * @return
     * The user
     */
    public UserSmall getUser() {
        return user;
    }

    /**
     *
     * @param user
     * The user
     */
    public void setUser(UserSmall user) {
        this.user = user;
    }

    /**
     *
     * @return
     * The roles
     */
    public ArrayList<Role> getRoles() {
        return roles;
    }

    /**
     *
     * @param roles
     * The roles
     */
    public void setRoles(ArrayList<Role> roles) {
        this.roles = roles;
    }

}