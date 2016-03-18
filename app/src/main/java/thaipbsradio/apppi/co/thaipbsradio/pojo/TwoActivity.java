package thaipbsradio.apppi.co.thaipbsradio.pojo;


import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import thaipbsradio.apppi.co.thaipbsradio.MainActivity;
import thaipbsradio.apppi.co.thaipbsradio.R;

/**
 * Created by pipatpong on 3/11/16 AD.
 */
public class TwoActivity extends Activity{

        private String photo;
        private MediaPlayer player = null;
        private boolean isPause = false;
        private ImageButton btnStart ;

    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_activity);

        imageView = (ImageView)findViewById(R.id.imgPhoto1);

        photo = getIntent().getExtras().getString("imgePhoto");

        Glide.with(this).load(photo).into(imageView);

    }


}
