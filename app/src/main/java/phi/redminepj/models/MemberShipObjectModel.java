package phi.redminepj.models;

/**
 * Created by guiltygearxx on 20-05-2016.
 */
import java.util.ArrayList;
        import java.util.List;
        import javax.annotation.Generated;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class MemberShipObjectModel {

    @SerializedName("memberships")
    @Expose
    private ArrayList<Membership> memberships = new ArrayList<Membership>();
    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    @SerializedName("limit")
    @Expose
    private Integer limit;

    /**
     *
     * @return
     * The memberships
     */
    public ArrayList<Membership> getMemberships() {
        return memberships;
    }

    /**
     *
     * @param memberships
     * The memberships
     */
    public void setMemberships(ArrayList<Membership> memberships) {
        this.memberships = memberships;
    }

    /**
     *
     * @return
     * The totalCount
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     *
     * @param totalCount
     * The total_count
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    /**
     *
     * @return
     * The offset
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     *
     * @param offset
     * The offset
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     *
     * @return
     * The limit
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     *
     * @param limit
     * The limit
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

}