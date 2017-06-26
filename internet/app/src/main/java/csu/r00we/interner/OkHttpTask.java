package csu.r00we.interner;

import android.os.AsyncTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by r00we on 24/06/2017.
 */

public class OkHttpTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... urls) {
        try {
            return downloadOneUrl(urls[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }

    private String downloadOneUrl(String address) throws IOException {
        OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(address)
                    .build();

            Response response = client.newCall(request).execute();
            return response.body().string();
    }
}