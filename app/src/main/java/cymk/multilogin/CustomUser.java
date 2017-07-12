package cymk.multilogin;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cyril Mathew on 7/11/2017.
 */


public class CustomUser {

    @SerializedName("username")
    String username;

    @SerializedName("password")
    String pass;

    public CustomUser(String username, String pass)
    {
        this.username = username;
        this.pass = pass;
    }
}