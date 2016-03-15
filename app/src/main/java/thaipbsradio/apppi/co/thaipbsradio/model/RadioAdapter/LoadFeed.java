package thaipbsradio.apppi.co.thaipbsradio.model.RadioAdapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;



/**
 * Created by POSEIDON on 14/9/2558.
 */
public class LoadFeed extends AsyncTask<Void, Void, String> {

    private ProgressDialog progressDialog;
    private boolean isShowProgressDialog = false;
    private OnLoaderListener loaderListener;
    private String feedUrl;

    public LoadFeed(Context context,String feedUrl) {
        this.feedUrl = feedUrl;
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(true);
        progressDialog.setMessage("Loading...");
    }


    public void showProgressDialog(boolean isShow) {
        isShowProgressDialog = isShow;
    }

    public void setLoaderListener(OnLoaderListener loaderListener) {
        this.loaderListener = loaderListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (isShowProgressDialog) {
            progressDialog.show();
        }
    }

    @Override
    protected String doInBackground(Void... params) {
        return HttpGet.get(feedUrl);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        if (loaderListener != null) {
            loaderListener.onLoaderComplete(result);
        }
    }

    public interface OnLoaderListener {
        void onLoaderComplete(String result);
    }
}
