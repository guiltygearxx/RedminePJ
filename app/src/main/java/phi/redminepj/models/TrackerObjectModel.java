package phi.redminepj.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by guiltygearxx on 20-05-2016.
 */
@Generated("org.jsonschema2pojo")
public class TrackerObjectModel {

    @SerializedName("trackers")
    @Expose
    private ArrayList<Tracker> trackers = new ArrayList<Tracker>();

    /**
     * @return The trackers
     */
    public ArrayList<Tracker> getTrackers() {
        return trackers;
    }

    /**
     * @param trackers The trackers
     */
    public void setTrackers(ArrayList<Tracker> trackers) {
        this.trackers = trackers;
    }
}
