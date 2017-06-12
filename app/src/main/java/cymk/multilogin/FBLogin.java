package cymk.multilogin;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * Created by Cyril Mathew on 6/12/2017.
 * Facebook Login class used to handle all the logic and details behind logging into Facebook
 */

class FBLogin
{
    CallbackManager callBackManager;

    FBLogin(LoginButton loginButton, final Context context)
    {
        callBackManager = CallbackManager.Factory.create();
        loginButton.setReadPermissions("email");

        // Callback registration
        loginButton.registerCallback(callBackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult)
            {
                ((LoginActivity)context).loginFinish();
                Log.e("SUCESS", "Igot it");
            }

            @Override
            public void onCancel()
            {
                Log.e("CANCEL", "DIDN't work brah");
            }

            @Override
            public void onError(FacebookException exception)
            {
                Log.e("ERROR", "Something dun goofed");
            }
        });
    }

    void loginResult(int requestCode, int resultCode, Intent data)
    {
        callBackManager.onActivityResult(requestCode, resultCode, data);
    }
}

