package thaipbsradio.apppi.co.thaipbsradio.model.RadioAdapter;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpGet {
    private static final OkHttpClient okHttp = new OkHttpClient();
    public static String get(String url){
        String result = null;
        try {
            Request request = new Request.Builder().url(url).get().build();
            Response response = okHttp.newCall(request).execute();
            if (response.isSuccessful()) {
                result = response.body().string();
                response.body().close();
            }else {
                Log.e("HttpGet",response.toString());
            }
        }catch (Exception e){
            Log.e("HttpGet", "Http get Response error : " + e.getMessage());
        }
        return result;
    }
}
