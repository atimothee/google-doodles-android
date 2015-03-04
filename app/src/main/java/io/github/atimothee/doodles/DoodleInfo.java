package io.github.atimothee.doodles;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

/**
 * Created by CrowdStar on 3/2/2015.
 */
public class DoodleInfo extends AsyncTask<String, String, String> {
    private String mYear;
    private String mMonth;
    private DoodleRequestListener mDoodleRequestListener;// our implemented callback that help tracks the result of what happen pn async task

    public DoodleInfo(DoodleRequestListener listener, String year, String month) {
        mYear = year;
        mDoodleRequestListener = listener;
        mMonth = month;
    }

    @Override
    protected String doInBackground(String[] params) {
        Uri uri = new Uri.Builder()
                .scheme("http")
                .authority("google.com")
                .path("doodles/json/" + mYear + "/" + mMonth)
                .build();
        Log.e("info kjdkb", uri.toString());
        HttpGet httpGet = new HttpGet(uri.toString());
        HttpClient httpClient = new DefaultHttpClient();
        ResponseHandler<String> handler = new BasicResponseHandler();

        try {
            return httpClient.execute(httpGet, handler);
        } catch (IOException e) {
            return "" + ServerConstant.UNEXPECTED_ERROR;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (result.trim().equalsIgnoreCase("" + ServerConstant.UNEXPECTED_ERROR)) {
            mDoodleRequestListener.onFailed();
        } else {
            mDoodleRequestListener.onSuccess(result);
        }
    }
}
