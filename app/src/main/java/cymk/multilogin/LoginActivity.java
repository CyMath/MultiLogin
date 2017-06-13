package cymk.multilogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.facebook.login.widget.LoginButton;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class LoginActivity extends AppCompatActivity
{

    //Facebook Login Object
    FBLogin fbLogin;

    //Twitter Login Object
    TwitterLogin tLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Twitter must be initialized BEFORE the button is inflated.
        tLogin = new TwitterLogin(this);
        setContentView(R.layout.activity_login);

        //Facebook
        LoginButton FBLoginButton = (LoginButton) findViewById(R.id.fb_login_button);
        fbLogin = new FBLogin(FBLoginButton, this);

        //Twitter Button
        TwitterLoginButton twtLoginButton = (TwitterLoginButton) findViewById(R.id.twitter_loginButton);
        tLogin.setLoginButton(twtLoginButton);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Send result of activity to Facebook Login, if it was facebook.
        fbLogin.loginResult(requestCode, resultCode, data);

        //Send result of activity to Twitter Login, if it was Twitter
        tLogin.loginResult(requestCode, resultCode, data);
    }

    //Don't want the user to be able to go back from the login
    @Override
    public void onBackPressed()
    {

    }

    public void loginFinish()
    {
        finish();
    }
}
