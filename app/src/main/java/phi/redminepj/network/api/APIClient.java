package phi.redminepj.network.api;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import java.text.ParseException;
import java.util.ArrayList;

import phi.redminepj.activity.MainActivity;
import phi.redminepj.models.Issue;
import phi.redminepj.models.IssueDetailModel;
import phi.redminepj.models.IssueObjectModel;
import phi.redminepj.models.MemberShipObjectModel;
import phi.redminepj.models.ProjectObjectModel;
import phi.redminepj.models.StatusObjectModel;
import phi.redminepj.models.Tracker;
import phi.redminepj.models.TrackerObjectModel;
import phi.redminepj.models.User;
import phi.redminepj.models.UserObjectModel;
import phi.redminepj.network.response.IssueCallBack;
import phi.redminepj.network.response.IssueDetailCallBack;
import phi.redminepj.network.response.MemberCallBack;
import phi.redminepj.network.response.ProjectCallBack;
import phi.redminepj.network.response.StatusCallBack;
import phi.redminepj.network.response.TrackersCallBack;
import phi.redminepj.network.response.UserCallback;
import phi.redminepj.ultils.Remember;

/**
 * Created by haconglinh1990 on 05/04/2016.
 */
public class APIClient {
    public static final String PREFS_ID_PROJECT="idofproject";
    public static final String MY_TAG = "message_from_meomeo";
    public static final String API_PROJECT = "projects/";
    public static final String API_BASE_URL = "http://192.168.1.59/";
    public static final String API_USER = API_BASE_URL + "users/current.json";
    public static final String API_GET_ISSUE_ID = API_BASE_URL + "issues/";
    public static final String API_ALL_PROJECT = API_BASE_URL + "projects.json";
    public static final String API_ALL_TRACKERS = API_BASE_URL + "trackers.json";
    public static final String API_ALL_STATUS = API_BASE_URL + "issue_statuses.json";

//    /http://192.168.1.59/projects/8/memberships.json
    public static final String API_ALL_MEMBER_OF_PROJECT = API_BASE_URL + API_PROJECT;
    public static final String API_ALL_PROJECT_BY_ID = API_BASE_URL + "issues.json?project_id=";
    public static final String API_ALL_ISSUSE_CURENT_USER_ASSIGNEE = API_BASE_URL + "issues.json?assigned_to_id=me";
    Context context;

    //ArrayList<Issue> issueList;


    public APIClient(Context context) {
        this.context = context;
    }

    public void logInUseAPI(String address, final String username, final String password) {
        Ion.with(context).load(address).basicAuthentication(username, password).asJsonObject().withResponse().setCallback(
                new FutureCallback<Response<JsonObject>>() {

                    @Override
                    public void onCompleted(Exception e, Response<JsonObject> result) {
                        int status = result.getHeaders().code();
                        Gson gson = new Gson();
                        UserObjectModel userModel = gson.fromJson(result.getResult(), UserObjectModel.class);
                        User user = userModel.getUser();
                        String apiKey = user.getApiKey();

                        if (status == 200 && apiKey != null) {
                            Remember.saveUser(context, username, password);
                            Remember.saveApiKey(context, apiKey);
                            Toast.makeText(context, "Login successfull !!!", Toast.LENGTH_SHORT).show();
                            Log.v(MY_TAG, "APIKey is: " + apiKey + ", Username: " + username + ", Password: " + password);
                            context.startActivity(new Intent(context, MainActivity.class));
                        } else {
                            Log.v(MY_TAG, "IssueStatus is not 200 or APIKey is null");
                            Toast.makeText(context, "Error Login, wrong username or password", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
    }

    public void getProjectofCurentUser(final ProjectCallBack projectCallBack) {
        //String username_restore, password_restore;
        //ArrayList<Project> projectList = new ArrayList<>();
        Log.d(MY_TAG, "In getProjectofCurentUser API");

        Remember.restoreUser(context, new UserCallback() {
            @Override
            public void User(String username, String password, boolean check) {
                Log.v(MY_TAG, "In getProjectofCurentUser, Username: " + username + ", Password: " + password + ", Check: " + check);
                if (check == true) {

                    Ion.with(context).load(API_ALL_PROJECT).basicAuthentication(username, password)
                            .asJsonObject().withResponse().setCallback(new FutureCallback<Response<JsonObject>>() {
                        @Override
                        public void onCompleted(Exception e, Response<JsonObject> result) {

                            int status = result.getHeaders().code();
                            Gson gson = new Gson();
                            Log.v(MY_TAG, " " + result.getResult().toString() + "IssueStatus: " + status);
                            ProjectObjectModel projectObjectModel = gson.fromJson(result.getResult(), ProjectObjectModel.class);

                            if (status == 200) {
                                Log.v(MY_TAG, "Get project with apikey saved from Server successfull");
                                projectCallBack.onCompleted(status, projectObjectModel.getProjects());

                            } else {
                                Log.v(MY_TAG, "IssueStatus is not 200. Can't get project from Server");
                                projectCallBack.onCompleted(status, null);
                            }
                        }
                    });

                    Log.d(MY_TAG, "Username: " + username + " ,Pass: " + password);
                } else {
                    Log.d(MY_TAG, "Can not get username, pass");
                }
            }
        });


    }



    public void getTrackersforProject(final TrackersCallBack trackersCallBack) {
        //String username_restore, password_restore;
        //ArrayList<Project> projectList = new ArrayList<>();
        Log.d(MY_TAG, "In getTRACKERS API");

        Remember.restoreUser(context, new UserCallback() {
            @Override
            public void User(String username, String password, boolean check) {
                Log.v(MY_TAG, "In getTRACKERS, Username: " + username + ", Password: " + password + ", Check: " + check);
                if (check == true) {

                    Ion.with(context).load(API_ALL_TRACKERS).basicAuthentication(username, password)
                            .asJsonObject().withResponse().setCallback(new FutureCallback<Response<JsonObject>>() {
                        @Override
                        public void onCompleted(Exception e, Response<JsonObject> result) {

                            int status = result.getHeaders().code();
                            Gson gson = new Gson();
                            Log.v(MY_TAG, " " + result.getResult().toString() + "IssueStatus: " + status);
                            TrackerObjectModel trackerObjectModel = gson.fromJson(result.getResult(), TrackerObjectModel.class);

                            if (status == 200) {
                                Log.v(MY_TAG, "Get project with apikey saved from Server successfull");
                                trackersCallBack.onCompleted(status, (trackerObjectModel.getTrackers()));

                            } else {
                                Log.v(MY_TAG, "IssueStatus is not 200. Can't get project from Server");
                                trackersCallBack.onCompleted(status, null);
                            }
                        }
                    });

                    Log.d(MY_TAG, "Username: " + username + " ,Pass: " + password);
                } else {
                    Log.d(MY_TAG, "Can not get username, pass");
                }
            }
        });
    }


    public void getStatusforProject(final StatusCallBack statusCallBack) {
        Log.d(MY_TAG, "In getSTATUS API");

        Remember.restoreUser(context, new UserCallback() {
            @Override
            public void User(String username, String password, boolean check) {
                Log.v(MY_TAG, "In getSTATUS, Username: " + username + ", Password: " + password + ", Check: " + check);
                if (check == true) {

                    Ion.with(context).load(API_ALL_STATUS).basicAuthentication(username, password)
                            .asJsonObject().withResponse().setCallback(new FutureCallback<Response<JsonObject>>() {
                        @Override
                        public void onCompleted(Exception e, Response<JsonObject> result) {

                            int status = result.getHeaders().code();
                            Gson gson = new Gson();
                            Log.v(MY_TAG, " " + result.getResult().toString() + "IssueStatus: " + status);
                            StatusObjectModel statusObjectModel = gson.fromJson(result.getResult(), StatusObjectModel.class);

                            if (status == 200) {
                                Log.v(MY_TAG, "Get project with apikey saved from Server successfull");
                                statusCallBack.onCompleted(status, (statusObjectModel.getIssueStatuses()));

                            } else {
                                Log.v(MY_TAG, "IssueStatus is not 200. Can't get project from Server");
                                statusCallBack.onCompleted(status, null);
                            }
                        }
                    });

                    Log.d(MY_TAG, "Username: " + username + " ,Pass: " + password);
                } else {
                    Log.d(MY_TAG, "Can not get username, pass");
                }
            }
        });


    }


    public void getMemberofProject(final MemberCallBack memberCallBack) {
        Log.d(MY_TAG, "In getSTATUS API");

        Remember.restoreUser(context, new UserCallback() {
            @Override
            public void User(String username, String password, boolean check) {
                Log.v(MY_TAG, "In getSTATUS, Username: " + username + ", Password: " + password + ", Check: " + check);
                if (check == true) {
                    SharedPreferences preferences = context.getSharedPreferences(PREFS_ID_PROJECT, Context.MODE_PRIVATE);
                    int idproject = preferences.getInt("id_issue_of_project", 0);
                    Log.d(APIClient.MY_TAG,"This is id of project for Create Issues:"+idproject);
                    Ion.with(context).load(API_ALL_MEMBER_OF_PROJECT+idproject+"/memberships.json").basicAuthentication(username, password)
                            .asJsonObject().withResponse().setCallback(new FutureCallback<Response<JsonObject>>() {
                        @Override
                        public void onCompleted(Exception e, Response<JsonObject> result) {

                            int status = result.getHeaders().code();
                            Gson gson = new Gson();
                            Log.v(MY_TAG, " " + result.getResult().toString() + "IssueStatus: " + status);
                            MemberShipObjectModel memberShipObjectModel = gson.fromJson(result.getResult(), MemberShipObjectModel.class);

                            if (status == 200) {
                                Log.v(MY_TAG, "Get Membership with apikey saved from Server successfull");
                                memberCallBack.onCompleted(status, (memberShipObjectModel.getMemberships()));

                            } else {
                                Log.v(MY_TAG, "Membership is not 200. Can't get project from Server");
                                memberCallBack.onCompleted(status, null);
                            }
                        }
                    });

                    Log.d(MY_TAG, "Username: " + username + " ,Pass: " + password);
                } else {
                    Log.d(MY_TAG, "Can not get username, pass");
                }
            }
        });


    }

    public void getIssues(final String urlQuery, final IssueCallBack issueCallBack) {
//        issueList = new ArrayList<>();
//        issuesObjectModel = new IssuesObjectModel();


        Remember.restoreUser(context, new UserCallback() {
            @Override
            public void User(String username, String password, boolean check) {
                Log.d(MY_TAG, "In getIssuesofCurentUser API, Username = " + username + ", Password: " + password + ", Check: " + check);
                if (check == true) {

                    Ion.with(context).load(urlQuery).basicAuthentication(username, password)
                            .asJsonObject().withResponse().setCallback(new FutureCallback<Response<JsonObject>>() {
                        @Override
                        public void onCompleted(Exception e, Response<JsonObject> result) {
                            int status = result.getHeaders().code();
                            Gson gson = new Gson();

                            IssueObjectModel issuesObjectModel = gson.fromJson(result.getResult(), IssueObjectModel.class);
                            if (status == 200) {
                                Log.d(MY_TAG, "Get issues successfull");
                                issueCallBack.onCompleted(status, issuesObjectModel.getIssues());

                            } else {
                                Log.d(MY_TAG, "Error when get issues from API");
                                issueCallBack.onCompleted(status, null);
                            }

                        }
                    });

                } else {
                    Log.d(MY_TAG, "Can not get username, pass");
                }
            }
        });
    }

    public void addnewIssue(final String urlQuery, final IssueCallBack issueCallBack) {
//        issueList = new ArrayList<>();
//        issuesObjectModel = new IssuesObjectModel();


        Remember.restoreUser(context, new UserCallback() {
            @Override
            public void User(String username, String password, boolean check) {
                Log.d(MY_TAG, "In getIssuesofCurentUser API, Username = " + username + ", Password: " + password + ", Check: " + check);
                if (check == true) {

                    Ion.with(context).load(urlQuery).basicAuthentication(username, password)
                            .asJsonObject().withResponse().setCallback(new FutureCallback<Response<JsonObject>>() {
                        @Override
                        public void onCompleted(Exception e, Response<JsonObject> result) {
                            int status = result.getHeaders().code();
                            Gson gson = new Gson();

                            IssueObjectModel issuesObjectModel = gson.fromJson(result.getResult(), IssueObjectModel.class);
                            if (status == 200) {
                                Log.d(MY_TAG, "Get issues successfull");
                                issueCallBack.onCompleted(status, issuesObjectModel.getIssues());

                            } else {
                                Log.d(MY_TAG, "Error when get issues from API");
                                issueCallBack.onCompleted(status, null);
                            }

                        }
                    });

                } else {
                    Log.d(MY_TAG, "Can not get username, pass");
                }
            }
        });
    }


    public void getDetailIssues(final String urlQuery, final IssueDetailCallBack issueDetailCallBack) {
//        issueList = new ArrayList<>();
//        issuesObjectModel = new IssuesObjectModel();


        Remember.restoreUser(context, new UserCallback() {
            @Override
            public void User(String username, String password, boolean check) {
                Log.d(MY_TAG, "In getIssuesofCurentUser API, Username = " + username + ", Password: " + password + ", Check: " + check);
                if (check == true) {

                    Ion.with(context).load(urlQuery).basicAuthentication(username, password)
                            .asJsonObject().withResponse().setCallback(new FutureCallback<Response<JsonObject>>() {
                        @Override
                        public void onCompleted(Exception e, Response<JsonObject> result) {
                            int status = result.getHeaders().code();
                            Gson gson = new Gson();

                            IssueDetailModel issueDetailModel = gson.fromJson(result.getResult(), IssueDetailModel.class);
                            Issue issues = issueDetailModel.getIssue();
                            if (status == 200) {
                                Log.d(MY_TAG, "Get issues successfull" + status);
                                try {
                                    issueDetailCallBack.onCompleted(status, issues);
                                } catch (ParseException e1) {
                                    e1.printStackTrace();
                                }

                            } else {
                                Log.d(MY_TAG, "Error when get issues from API" + status);
                                try {
                                    issueDetailCallBack.onCompleted(status, issues);
                                } catch (ParseException e1) {
                                    e1.printStackTrace();
                                }
                            }

                        }
                    });

                } else {
                    Log.d(MY_TAG, "Can not get username, pass");
                }
            }
        });
    }


}
