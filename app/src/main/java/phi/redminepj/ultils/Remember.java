package phi.redminepj.ultils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import phi.redminepj.network.api.APIClient;
import phi.redminepj.network.response.APIKeyCallback;
import phi.redminepj.network.response.UserCallback;

/**
 * Created by guiltygearxx on 17-05-2016.
 */
public class Remember {
    public static final String PREFS_USER="user";
    public static final String PREFS_USERNAME="username";
    public static final String PREFS_PASSWORD="password";

    public static final String PREFS_APIKEY="key";
    public static void saveUser(Context context,String username, String password){
        SharedPreferences preferences=context.getSharedPreferences(PREFS_USER, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit=preferences.edit();
        edit.putString(PREFS_USERNAME, username);
        edit.putString(PREFS_PASSWORD, password);
        edit.commit();
    }
    public static void restoreUser(Context context, UserCallback userCallback){
        SharedPreferences preferences=context.getSharedPreferences(PREFS_USER, Context.MODE_PRIVATE);
        String username=preferences.getString(PREFS_USERNAME, "");
        String password=preferences.getString(PREFS_PASSWORD, "");
        boolean check=false;
        if (!username.isEmpty() && !password.isEmpty()){
            check=true;
            userCallback.User(username, password,check);
        }else {
            check=false;
            userCallback.User(null,null,check);
        }

    }
    public static void saveApiKey(Context context, String apiKey){
        SharedPreferences preferences=context.getSharedPreferences(PREFS_USER, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit=preferences.edit();
        edit.putString(PREFS_APIKEY,apiKey);
        edit.commit();
    }


    public static void restoreApiKey(Context context, APIKeyCallback callback){
        SharedPreferences preferences=context.getSharedPreferences(PREFS_USER, Context.MODE_PRIVATE);
        String apiKey=preferences.getString(PREFS_APIKEY,"");
        if (apiKey != null) {
            callback.Key(apiKey);
        }else {
            callback.Key(null);
        }
    }
    public static String apiKey(Context context){
        SharedPreferences preferences=context.getSharedPreferences(PREFS_USER, Context.MODE_PRIVATE);
        String apiKey=preferences.getString(PREFS_APIKEY,"");
        return apiKey;
    }
}

