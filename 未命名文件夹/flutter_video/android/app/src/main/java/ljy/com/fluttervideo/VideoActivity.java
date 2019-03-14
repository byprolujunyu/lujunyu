package ljy.com.fluttervideo;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import com.bumptech.glide.Glide;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;
import com.xiao.nicevideoplayer.TxVideoPlayerController;

public class VideoActivity extends AppCompatActivity {
    private NiceVideoPlayer mNiceVideoPlayer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_change_clarity);
        mNiceVideoPlayer = (NiceVideoPlayer) findViewById(R.id.nice_video_player);
        mNiceVideoPlayer.setPlayerType(NiceVideoPlayer.TYPE_IJK); // IjkPlayer or MediaPlayer
        TxVideoPlayerController controller = new TxVideoPlayerController(this);
        controller.setTitle("茹茹");
        controller.setLenght(117000);

        String videoUrl = getIntent().getStringExtra("videoUrl");
        String imageUrl = getIntent().getStringExtra("imageUrl");

        Glide.with(this)
                .load(imageUrl)
                .into(controller.imageView());
        mNiceVideoPlayer.setUp(videoUrl, null);
        mNiceVideoPlayer.setController(controller);
    }

    @Override
    protected void onStop() {
        super.onStop();
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }

    @Override
    public void onBackPressed() {
        if (NiceVideoPlayerManager.instance().onBackPressd()) return;
        super.onBackPressed();
    }

    public void back(View view){
        finish();
    }
}
