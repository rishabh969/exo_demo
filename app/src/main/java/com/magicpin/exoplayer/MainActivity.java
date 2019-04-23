package com.magicpin.exoplayer;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import com.magicpin.exoplayer.adapter.VideoRecyclerViewAdapter;
import com.magicpin.exoplayer.model.VideoInfo;
import com.magicpin.exoplayer.ui.ExoPlayerRecyclerView;
import com.magicpin.exoplayer.utils.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.widget.LinearLayout.VERTICAL;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerViewFeed)
    ExoPlayerRecyclerView recyclerViewFeed;

    private List<VideoInfo> videoInfoList = new ArrayList<>();
    private VideoRecyclerViewAdapter mAdapter;
    private boolean firstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        prepareVideoList();
        recyclerViewFeed.setVideoInfoList(videoInfoList);
        mAdapter = new VideoRecyclerViewAdapter(videoInfoList);
        recyclerViewFeed.setLayoutManager(new LinearLayoutManager(this, VERTICAL, false));
        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.divider_drawable);
        recyclerViewFeed.addItemDecoration(new DividerItemDecoration(dividerDrawable));
        recyclerViewFeed.setItemAnimator(new DefaultItemAnimator());
        recyclerViewFeed.setAdapter(mAdapter);

        if (firstTime) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    recyclerViewFeed.playVideo();
                }
            });
            firstTime = false;
        }
        recyclerViewFeed.scrollToPosition(0);

    }

    private void prepareVideoList() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setId(1);
        videoInfo.setUserHandle("@magicpin");
        videoInfo.setTitle("Be Happy. Be Bright. Be Happy.");
        videoInfo.setCoverUrl("https://d15xs3htl97jic.cloudfront.net/Rmkt/partner_logo3.jpg");
        videoInfo.setUrl("https://player.vimeo.com/external/286837767.m3u8?s=42570e8c4a91b98cdec7e7bfdf0eccf54e700b69");

        VideoInfo videoInfo2 = new VideoInfo();
        videoInfo2.setId(2);
        videoInfo2.setUserHandle("@magicpin");
        videoInfo2.setTitle("Don’T Wish For It. Work For It.");
        videoInfo2.setCoverUrl("https://d15xs3htl97jic.cloudfront.net/Rmkt/partner_logo3.jpg");
        videoInfo2.setUrl("https://player.vimeo.com/external/286837810.m3u8?s=610b4fee49a71c2dbf22c01752372ff1c6459b9e");

        VideoInfo videoInfo3 = new VideoInfo();
        videoInfo3.setId(3);
        videoInfo3.setUserHandle("@magicpin");
        videoInfo3.setTitle("Sometimes It’S Ok To Be Selfish.");
        videoInfo3.setCoverUrl("https://d15xs3htl97jic.cloudfront.net/Rmkt/partner_logo3.jpg");
        videoInfo3.setUrl("https://player.vimeo.com/external/286837723.m3u8?s=3df60d3c1c6c7a11df4047af99c5e05cc2e7ae96");

        VideoInfo videoInfo4 = new VideoInfo();
        videoInfo4.setId(4);
        videoInfo4.setUserHandle("@magicpin");
        videoInfo4.setTitle("Dreams Doesn’T Work Unless You Do.");
        videoInfo4.setCoverUrl("https://d15xs3htl97jic.cloudfront.net/Rmkt/partner_logo3.jpg");
        videoInfo4.setUrl("https://player.vimeo.com/external/286837649.m3u8?s=9e486e9b932be72a8875afc6eaae21bab124a35a");

        VideoInfo videoInfo5 = new VideoInfo();
        videoInfo5.setId(5);
        videoInfo5.setUserHandle("@magicpin");
        videoInfo5.setTitle("Always Do Small Things With Great Love.");
        videoInfo5.setCoverUrl("https://d15xs3htl97jic.cloudfront.net/Rmkt/partner_logo3.jpg");
        videoInfo5.setUrl("https://player.vimeo.com/external/286837529.m3u8?s=20f83af6ea8fbfc8ce0c2001f32bf037f8b0f65f");


        VideoInfo videoInfo6 = new VideoInfo();
        videoInfo6.setId(6);
        videoInfo6.setUserHandle("@magicpin");
        videoInfo6.setTitle("When did you last cry in front of someone?");
        videoInfo6.setCoverUrl("https://d15xs3htl97jic.cloudfront.net/Rmkt/partner_logo3.jpg");
        videoInfo6.setUrl("https://player.vimeo.com/external/286837402.m3u8?s=7e01c398e2f01c29ecbd46e5e2dd53e0d6c1905d");

        videoInfoList.add(videoInfo);
        videoInfoList.add(videoInfo2);
        videoInfoList.add(videoInfo3);
        videoInfoList.add(videoInfo4);
        videoInfoList.add(videoInfo5);
        videoInfoList.add(videoInfo);
        videoInfoList.add(videoInfo2);
        videoInfoList.add(videoInfo3);
        videoInfoList.add(videoInfo4);
        videoInfoList.add(videoInfo5);

    }


    @Override
    protected void onDestroy() {
        if(recyclerViewFeed!=null)
        recyclerViewFeed.onRelease();
        super.onDestroy();
    }
}
