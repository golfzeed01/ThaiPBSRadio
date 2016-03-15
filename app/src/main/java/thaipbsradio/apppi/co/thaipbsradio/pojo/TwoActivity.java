package thaipbsradio.apppi.co.thaipbsradio.pojo;


import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import thaipbsradio.apppi.co.thaipbsradio.MainActivity;
import thaipbsradio.apppi.co.thaipbsradio.R;

/**
 * Created by pipatpong on 3/11/16 AD.
 */
public class TwoActivity extends Activity{

    public class MainActivity extends Activity {

        private MediaPlayer player = null;
        private boolean isPause = false;
        private ImageButton btnStart ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_activity);
        btnStart = (ImageButton) findViewById(R.id.btn_start);
        btnStart.setOnClickListener(btnStartOnClickListener);

    }

    }
}
