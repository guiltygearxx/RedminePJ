package phi.redminepj.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import phi.redminepj.R;
import phi.redminepj.network.api.APIClient;

public class LoginActivity extends AppCompatActivity {
    String server, username, password;
    EditText edServier, edUser, edPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edServier = (EditText)findViewById(R.id.edServer);
        edUser = (EditText)findViewById(R.id.edUser);
        edPassword = (EditText)findViewById(R.id.edPassword);

        server = edServier.getText().toString()+"/users/current.json";
        username = edUser.getText().toString();
        password = edPassword.getText().toString();

        Log.d(APIClient.MY_TAG,""+username);
        Log.d(APIClient.MY_TAG,""+password);
    }

    public void loginredmine(View view){
        Toast.makeText(LoginActivity.this,"Login",Toast.LENGTH_LONG).show();
        new APIClient(LoginActivity.this).logInUseAPI(server, username, password);
    }
}
