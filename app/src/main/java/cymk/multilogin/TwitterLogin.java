package cymk.multilogin;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

/**
 * Created by Cyril Mathew on 6/13/2017.
 */

class TwitterLogin
{
    private TwitterLoginButton loginButton;
    private Context context;

    TwitterLogin(Context context)
    {
        this.context = context;
        TwitterConfig config = new TwitterConfig.Builder(context)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig("xxx", "xxx"))
                .debug(true)
                .build();
        Twitter.initialize(config);

    }

    void setLoginButton(TwitterLoginButton button)
    {
        loginButton = button;

        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // Do something with result, which provides a TwitterSession for making API calls
                ((LoginActivity)context).loginFinish();
            }

            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
            }
        });
    }

    void loginResult(int requestCode, int resultCode, Intent data)
    {
        loginButton.onActivityResult(requestCode, resultCode, data);
    }

}
