package phi.redminepj.network.api;

/**
 * Created by guiltygearxx on 16-05-2016.
 */
public class Constants {
    public static final String MY_TAG = "message_from_system";
    public static final String API_BASE_URL = "http://192.168.1.59/";
    public static final String API_USER = API_BASE_URL + "users/current.json";
    public static final String API_ALL_PROJECT = API_BASE_URL + "projects.json";
    public static final String API_ALL_ISSUSE_CURENT_USER_ASSIGNEE = API_BASE_URL + "issues.json?assigned_to_id=me";
}
