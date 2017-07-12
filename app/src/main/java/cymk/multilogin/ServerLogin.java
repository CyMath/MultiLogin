package cymk.multilogin;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.twitter.sdk.android.core.models.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import cymk.multilogin.Interfaces.ApiInterface;
import okio.Buffer;
import okio.BufferedSink;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Cyril Mathew on 6/13/2017.
 */

class ServerLogin implements Callback<List<CustomUser>>
{
    ApiInterface apiInterface;
    ServerLogin()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.ENDPOINT)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);

    }

    @Override
    public void onResponse(Call<List<CustomUser>> call, Response<List<CustomUser>> response)
    {
        Log.e("JSON RESPONSE", response.body().toString());
        //Log.e("HTTP RESPONSE", response.raw().toString());
    }

    @Override
    public void onFailure(Call<List<CustomUser>> call, Throwable t)
    {
        Log.e("JSON RESPONSE", "NONE");
        t.printStackTrace();

    }

    public void postRequest()
    {
        // prepare call in Retrofit 2.0

            //BufferedSink sink = new Buffer();
            CustomUser user = new CustomUser("user", "password");

        //try{
            //(apiInterface.getUser(user)).request().body().writeTo(sink);
            //Log.e("APINT", sink.buffer().readUtf8());
            Call<List<CustomUser>> userCall = apiInterface.getUser(user);
            userCall.enqueue(this);
        /*}catch (IOException e)
        {
            e.printStackTrace();
        }*/

    }
}
