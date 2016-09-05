package com.example.nurmemet.frescoexample;

import android.net.Uri;
import android.os.Environment;
import android.support.v4.os.EnvironmentCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private boolean isCacheInDisk;
    private String imgAddress = "http://img3.imgtn.bdimg.com/it/u=2093281992,1989175113&fm=11&gp=0.jpg";

    SimpleDraweeView fromeCache;
    SimpleDraweeView fromeLocal;
    SimpleDraweeView fromeAsset;
    SimpleDraweeView fromeRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fromeCache= (SimpleDraweeView) findViewById(R.id.frome_cache);
        //检查缓存
        isCacheInDisk = Fresco.getImagePipelineFactory().getMainFileCache().hasKey(new SimpleCacheKey(imgAddress));
        if (!isCacheInDisk) {
            //缓存
            ImageRequest request = ImageRequestBuilder
                    .newBuilderWithSource(Uri.parse(imgAddress)).build();
            Fresco.getImagePipelineFactory().getImagePipeline().prefetchToDiskCache(request, null);
        }else{
            fromeCache.setImageURI(Uri.parse(imgAddress));
        }
        fromeAsset = (SimpleDraweeView) findViewById(R.id.frome_asset);
        fromeAsset.setImageURI(Uri.parse("asset:///frome_asset.jpg"));
        fromeLocal = (SimpleDraweeView) findViewById(R.id.frome_local);
        fromeLocal.setImageURI(Uri.parse("file:///" + Environment.getExternalStorageDirectory().getAbsolutePath() + "/aatest/frome_local.jpg"));
        fromeRes = (SimpleDraweeView) findViewById(R.id.frome_res);
        fromeRes.setImageURI(Uri.parse("res:///" + R.mipmap.frome_res));


    }
}
