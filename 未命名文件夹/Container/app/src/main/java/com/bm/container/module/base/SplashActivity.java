package com.bm.container.module.base;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.bm.container.R;
import com.bm.container.Tools.SpUtil;
import com.bm.container.databinding.ActivitySplashBinding;
import com.bm.container.module.BaseActivity;
import com.bm.container.module.base.adapter.SplashAdapter;

import java.util.ArrayList;

/**
 * P2引导页
 */
public class SplashActivity extends BaseActivity {
    private ActivitySplashBinding binding;
    private Context context;
    public static SplashActivity instance;
    private SplashAdapter adapter;
    private ArrayList<View> images = new ArrayList<>();
    private float start_x;
    private float end_x;
    private int tag_vp;
    private int lock = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        context = this;
        instance = this;
        binding.refresh.setEnabled(false);
        binding.refresh.setRefreshing(true);
        initViewPager();
        initImage();
        setLoading();
        binding.refresh.setRefreshing(false);
    }

    private void setLoading() {
        setLoading(binding.refresh);
        binding.refresh.setEnabled(false);
        binding.refresh.setColorSchemeColors(loadingColors);
    }

    /**
     * 轮播图
     */
    private void initViewPager() {
        adapter = new SplashAdapter(images);
        binding.viewpager.setAdapter(adapter);
        // 划到最后一页自动跳转
        binding.viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                tag_vp = arg0;
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    /**
     * 轮播图
     */
    private void initImage() {
//		Collection.guidePic(this, bean -> {
//			for(int i = 0; i < bean.size(); i++){
//				ImageView imageView= new ImageView(this);
//				imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//				images.add(imageView);
//				Glide.with(this).load(Api.picUrl2+bean.get(i).getAdpath()).placeholder(R.drawable.banner1).into((ImageView)images.get(i));
//			}
//			adapter.notifyDataSetChanged();
//			hideLoading();
//		},error -> {
//			Log.e("接口请求失败", ((Throwable)error).getMessage());
        ImageView imageView1 = new ImageView(this);
        imageView1.setBackgroundResource(R.drawable.guide1);
        images.add(imageView1);
        ImageView imageView2 = new ImageView(this);
        imageView2.setBackgroundResource(R.drawable.guide2);
        images.add(imageView2);
        ImageView imageView3 = new ImageView(this);
        imageView3.setBackgroundResource(R.drawable.guide3);
        images.add(imageView3);
        adapter.notifyDataSetChanged();
//		});
    }

    /**
     * 监听touch事件
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                start_x = event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                end_x = event.getX();
                // 滑动方向的标记
                float direction_tag = end_x - start_x;
                if (tag_vp == (images.size() - 1)) {
                    if (direction_tag < 0 && lock == 0) {
                        lock = 1;
                        Intent i = new Intent(context, MainActivity.class);
                        startAc(i);
                        SpUtil.setBoolean("guideVaule", true);
                        finishAc();
                    }
                }

                break;

            default:
                break;
        }
        return super.dispatchTouchEvent(event);
    }

}
