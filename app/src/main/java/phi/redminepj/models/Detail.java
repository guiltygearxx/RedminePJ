
package phi.redminepj.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Detail {

    @SerializedName("property")
    @Expose
    private String property;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("new_value")
    @Expose
    private String newValue;

    /**
     * 
     * @return
     *     The property
     */
    public String getProperty() {
        return property;
    }

    /**
     * 
     * @param property
     *     The property
     */
    public void setProperty(String property) {
        this.property = property;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The newValue
     */
    public String getNewValue() {
        return newValue;
    }

    /**
     * 
     * @param newValue
     *     The new_value
     */
    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

}
