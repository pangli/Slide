package com.pangli.slide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnStart, btnStop;
    private ViewFlipper viewFlipper;
    private int[] imgs = {R.drawable.aa, R.drawable.bb, R.drawable.cc, R.drawable.dd};//图片源

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = (Button) findViewById(R.id.btn_start);
        btnStop = (Button) findViewById(R.id.btn_stop);
        viewFlipper = (ViewFlipper) findViewById(R.id.view_flipper);
        for (int i = 0; i < imgs.length; i++) { // 动态添加图片源
            ImageView iv = new ImageView(this);
            iv.setImageResource(imgs[i]);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(iv, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout
                    .LayoutParams.MATCH_PARENT));
        }
        // viewFlipper.setAutoStart(true); // 设置自动播放功能（点击事件，前自动播放）
        viewFlipper.setFlipInterval(3000);//间隔3秒
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                if (!viewFlipper.isFlipping()) {
                    viewFlipper.startFlipping();//开始播放
                    viewFlipper.setInAnimation(this,android.support.v7.appcompat.R.anim.abc_grow_fade_in_from_bottom);
                    viewFlipper.setOutAnimation(this, android.support.v7.appcompat.R.anim.abc_shrink_fade_out_from_bottom);
                }
                break;
            case R.id.btn_stop:
                if (viewFlipper.isFlipping()) {
                    viewFlipper.stopFlipping();//停止播放
                }
                break;
            default:
                break;
        }
    }
}
