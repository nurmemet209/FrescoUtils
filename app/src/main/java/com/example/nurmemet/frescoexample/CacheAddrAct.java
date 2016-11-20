package com.example.nurmemet.frescoexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.request.ImageRequest;

import java.io.File;

/**
 * Created by nurmemet on 2016/11/20.
 */

public class CacheAddrAct extends AppCompatActivity {


    TextView mChacheAddr;
    SimpleDraweeView mImg;

    private static final String url = "http://img5.duitang.com/uploads/item/201507/29/20150729101145_PjwFA.jpeg";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cache_addr_act);

        mChacheAddr = (TextView) findViewById(R.id.cache_addr);
        mImg = (SimpleDraweeView) findViewById(R.id.image);
        mImg.setImageURI(url);
    }


    public void getChachedAddr(View view) {
        ImageRequest request = ImageRequest.fromUri(url);
        CacheKey cacheKey = DefaultCacheKeyFactory.getInstance().getEncodedCacheKey(request, null);
        boolean hasCached = ImagePipelineFactory.getInstance().getMainFileCache().hasKey(cacheKey);
        if (hasCached) {
            BinaryResource binaryResource = ImagePipelineFactory.getInstance().getMainFileCache().getResource(cacheKey);
            File file = ((FileBinaryResource) binaryResource).getFile();
            if (file != null) {
                mChacheAddr.setText(file.getAbsolutePath());
            }
        }
    }
}
