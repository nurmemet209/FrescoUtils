package com.example.nurmemet.frescoexample;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by nurmemet on 9/5/2016.
 */
public class DraweeHierarchyTest extends Activity {
    SimpleDraweeView test;
    private String imgAddress = "http://img3.imgtn.bdimg.com/it/u=2093281992,1989175113&fm=11&gp=0.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hierchery_test);
        test = (SimpleDraweeView) findViewById(R.id.hiechery_test);
        test.setImageURI(imgAddress);
        GenericDraweeHierarchy hierarchy = test.getHierarchy();
        RoundingParams roundingParams = new RoundingParams();
        // 设置边框颜色和宽度
        roundingParams.setBorder(Color.RED, 10.0f);
        // 设置圆角半径
        roundingParams.setCornersRadius(20.0f);
        hierarchy.setRoundingParams(roundingParams);
        roundingParams.setRoundAsCircle(true);

        //drawee支持如下属性,并且以下属性都可以用GenericDraweeHierarchy代码控制
        //fresco:fadeDuration="300" // 淡入淡出的持续时间
        // fresco:actualImageScaleType="focusCrop"  // 实际图像的缩放类型
        //fresco:placeholderImage="@color/wait_color"  //占位图
        // fresco:placeholderImageScaleType="fitCenter" //占位图的缩放类型
        // fresco:failureImage="@drawable/error" //下载失败显示的图片
        //fresco:failureImageScaleType="centerInside" //失败图的缩放类型
        // fresco:retryImage="@drawable/retrying"
        //图片加载失败时显示，提示用户点击重新加载，重复加载4次还是没有加载出来的时候才会显示failureImage的图片
        //fresco:retryImageScaleType="centerCrop" //重新加载的图片缩放类型
        // fresco:progressBarImage="@drawable/progress_bar" //进度条图片
        // fresco:progressBarImageScaleType="centerInside"
        // fresco:progressBarAutoRotateInterval="1000"
        //进度图自动旋转间隔时间(单位：毫秒ms)
        // fresco:backgroundImage="@color/blue"
        //背景图片，这里的背景图片首先被绘制
        //fresco:overlayImage="@drawable/watermark"
        // 设置叠加图，在xml中只能设置一张叠加图片，如果需要多张图片的话，需要在java代码中设置哦
        // fresco:pressedStateOverlayImage="@color/red"
        // 设置点击状态下的叠加图
        // fresco:roundAsCircle="false" //设置为圆形图
        // fresco:roundedCornerRadius="1dp" // 圆角半径
        //  fresco:roundTopLeft="true" // 左上角是否为圆角
        // fresco:roundTopRight="false"
        // fresco:roundBottomLeft="false"
        // fresco:roundBottomRight="true"
        //fresco:roundWithOverlayColor="@color/corner_color"
        // fresco:roundingBorderWidth="2dp" //边框的宽度
        // fresco:roundingBorderColor="@color/border_color" //边框颜色

    }
}
