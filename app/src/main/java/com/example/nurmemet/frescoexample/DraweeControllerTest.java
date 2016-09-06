package com.example.nurmemet.frescoexample;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/**
 * Created by nurmemet on 9/3/2016.
 * 监听图片加载
 */
public class DraweeControllerTest extends Activity {

    private SimpleDraweeView img;
    private SimpleDraweeView thumbnail;
    private SimpleDraweeView gifImg;
    private String imgAddress = "http://img3.imgtn.bdimg.com/it/u=2093281992,1989175113&fm=11&gp=0.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawee_controller_test);
        img = (SimpleDraweeView) findViewById(R.id.drawee_test);
        thumbnail = (SimpleDraweeView) findViewById(R.id.thumbnail);
        gifImg = (SimpleDraweeView) findViewById(R.id.gif_test);
        ControllerListener listener = new ControllerListener() {
            @Override
            public void onSubmit(String id, Object callerContext) {

            }

            @Override
            public void onFinalImageSet(String id, Object imageInfo, Animatable animatable) {

            }

            @Override
            public void onIntermediateImageSet(String id, Object imageInfo) {

            }

            @Override
            public void onIntermediateImageFailed(String id, Throwable throwable) {

            }

            @Override
            public void onFailure(String id, Throwable throwable) {

            }

            @Override
            public void onRelease(String id) {

            }
        };
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(imgAddress)
                .setControllerListener(listener)
                .build();
        img.setController(controller);

        //先加载低分辨率图片，在加载高分辨率图片
        String lowResUri = "http://img4.imgtn.bdimg.com/it/u=885232197,1834744423&fm=21&gp=0.jpg";
        String highResUri = "http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1212/06/c1/16396010_1354784049718.jpg";
        DraweeController ctl = Fresco.newDraweeControllerBuilder()
                .setLowResImageRequest(ImageRequest.fromUri(lowResUri))
                .setImageRequest(ImageRequest.fromUri(highResUri))
                .setOldController(img.getController())
                .build();
        img.setController(ctl);

        //缩略图显示
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(imgAddress))
                .setLocalThumbnailPreviewsEnabled(true)
                .build();
        DraweeController thumbnailController = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .build();
        thumbnail.setController(thumbnailController);

        //gif显示
        //要添加这个库 compile 'com.facebook.fresco:animated-gif:0.12.0'
        String gifAddress = "http://images.missyuan.com/attachments/day_110808/20110808_9fb3173c11a2f20005ee71TDj0m1C1nm.gif";
        DraweeController gifController = Fresco.newDraweeControllerBuilder().setUri(gifAddress).setAutoPlayAnimations(true).build();
        gifImg.setController(gifController);


    }
}
