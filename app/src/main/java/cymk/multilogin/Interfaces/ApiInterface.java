package cymk.multilogin.Interfaces;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import cymk.multilogin.CustomUser;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Cyril Mathew on 7/11/2017.
 */

public interface ApiInterface
{
    String ENDPOINT = "http://ranse7.x10host.com/devstore/signup_form/";

    @Headers("Content-Type: application/json")
    @POST("signup.php")
    Call<List<CustomUser>> getUser(@Body CustomUser user);
}

