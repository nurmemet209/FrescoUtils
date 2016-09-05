package com.example.nurmemet.frescoexample;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;

/**
 * Created by nurmemet on 9/3/2016.
 */
public class ImagePiplineController extends Activity {
    private String imgAddress = "http://img3.imgtn.bdimg.com/it/u=2093281992,1989175113&fm=11&gp=0.jpg";
    private SimpleDraweeView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pipline_controller);
        img = (SimpleDraweeView) findViewById(R.id.pipline_test);
        img.setImageURI(Uri.parse(imgAddress));
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        Uri uri = Uri.parse(imgAddress);

        // 从内存中删除
        imagePipeline.evictFromMemoryCache(uri);
        // 从磁盘中删除
        imagePipeline.evictFromDiskCache(uri);
        // 同时从文件和磁盘中删除当前uri的缓存
        imagePipeline.evictFromCache(uri);

        imagePipeline.clearMemoryCaches();
        imagePipeline.clearDiskCaches();
        // 同时清除内存和磁盘缓存
        imagePipeline.clearCaches();

    }
}
