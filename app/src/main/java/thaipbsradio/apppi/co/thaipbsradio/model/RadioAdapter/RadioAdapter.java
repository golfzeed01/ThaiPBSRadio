package thaipbsradio.apppi.co.thaipbsradio.model.RadioAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import java.util.List;

import thaipbsradio.apppi.co.thaipbsradio.R;
import thaipbsradio.apppi.co.thaipbsradio.Radioobject;
import thaipbsradio.apppi.co.thaipbsradio.pojo.Radio;
import thaipbsradio.apppi.co.thaipbsradio.pojo.TwoActivity;

/**
 * Created by pipatpong on 3/7/16 AD.
 */
public class RadioAdapter extends RecyclerView.Adapter<RadioAdapter.RadioHolder> {

    private List<Radioobject> mRadioList;
    private Context context;



    public RadioAdapter(List<Radioobject> l ,Context context){
        mRadioList = l;
        this.context = context;
    }
    public  void addListRadio(Radioobject Radio){
        mRadioList.add(Radio);
        notifyDataSetChanged();
    }

    @Override
    public RadioHolder onCreateViewHolder(ViewGroup parent, int viewType ) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_radio,parent,false);

        return new RadioHolder(view);

    }

    @Override
    public void onBindViewHolder(RadioHolder holder, int position) {
        final Radioobject Radio = mRadioList.get(position);
        //holder.mPhoto.setImageResource(Radio.getThump());
        holder.view.setTag(Radio.getTitle());

        Glide.with(context).load(Radio.getThump()).into(holder.mPhoto);
       holder.mName.setText(Radio.getTitle());
        holder.mAuthor.setText(Radio.getAuthor());
        holder.mTime.setText(Radio.getStarttime()+" - "+Radio.getEndtime());

        holder.mPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Gotwo = new Intent(context, TwoActivity.class);
                Gotwo.putExtra("imgePhoto",Radio.getThump());
                context.startActivity(Gotwo);

            }
        });

    }

    @Override
    public int getItemCount() {
       return mRadioList.size();
    }



    public class RadioHolder extends RecyclerView.ViewHolder{

        private ImageView mPhoto;
        private TextView mName;
        private TextView mAuthor;
        private View view;
        private TextView mTime;

        public RadioHolder(View itemView) {
            super(itemView);
            view = (View)itemView.findViewById(R.id.radioview);
            mPhoto = (ImageView)itemView.findViewById(R.id.imgPhoto);
            mName = (TextView)itemView.findViewById(R.id.textName);
            mAuthor = (TextView)itemView.findViewById(R.id.textauthor);
            mTime = (TextView)itemView.findViewById(R.id.textTime);



        }


    }
}
