package thaipbsradio.apppi.co.thaipbsradio;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import thaipbsradio.apppi.co.thaipbsradio.model.RadioAdapter.LoadFeed;
import thaipbsradio.apppi.co.thaipbsradio.model.RadioAdapter.RadioAdapter;
import thaipbsradio.apppi.co.thaipbsradio.pojo.Radio;
import thaipbsradio.apppi.co.thaipbsradio.pojo.TwoActivity;

/**
 * Created by pipatpong on 3/8/16 AD.
 */
public class RadioFragment extends Fragment implements View.OnClickListener {

    private RadioAdapter radioAdapter;
    private ArrayList<Radioobject> arrRadio;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.radio_fragment,container,false);
        arrRadio = new ArrayList<Radioobject>();
        List<Radio> radiosList = new ArrayList<>();





        for (int i=0;i<20;i++) {

            radiosList.add(new Radio(R.drawable.orange1, "กล้วย", "กล้วยน้ำว้า"));
           // radiosList.add(new Radio(R.drawable.orange1, "กล้วย", "กล้วยน้ำว้า"));
           // radiosList.add(new Radio(R.drawable.orange1, "กล้วย", "กล้วยน้ำว้า"));
        }

        radioAdapter = new RadioAdapter(arrRadio,getActivity(),this);

        recyclerView = (RecyclerView) view.findViewById(R.id.mRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        //recyclerView.setAdapter(radioAdapter);


        Loadcontent();

        return view;
    }
    public void Loadcontent(){

        LoadFeed Load = new LoadFeed(getActivity(),"http://wi.th/thaipbs_backend_cron/epgRadio_forJS");
        Load.showProgressDialog(true);
        Load.setLoaderListener(new LoadFeed.OnLoaderListener() {
            @Override
            public void onLoaderComplete(String result) {
                if (result != null) {
                    Log.d("result", result);
                    try {
                        JSONObject jsonObject = new JSONObject(result);
                        JSONArray jsonArray = jsonObject.getJSONArray("Schedule");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            Radioobject radioobject = new Radioobject(jsonArray.getJSONObject(i));
                            arrRadio.add(radioobject);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    recyclerView.setAdapter(radioAdapter);
                }

            }
        });
        Load.execute();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.radioview:
                Intent Gotwo = new Intent(getContext(), thaipbsradio.apppi.co.thaipbsradio.pojo.TwoActivity.class);
                Gotwo.putExtra("textName","textName");

                startActivity(Gotwo);
                break;
        }
    }
}
