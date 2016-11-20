package com.example.nurmemet.frescoexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by nurmemet on 9/3/2016.
 */
public class MainPageAct extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page_act);
    }

    public void onImageSourceTest(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void onDraweeController(View view) {
        Intent intent = new Intent(this, DraweeControllerTest.class);
        startActivity(intent);
    }

    public void onPiplineController(View view) {
        Intent intent = new Intent(this, ImagePiplineController.class);
        startActivity(intent);
    }

    public void onHiercheryController(View view) {
        Intent intent = new Intent(this, DraweeHierarchyTest.class);
        startActivity(intent);
    }

    public void onDownload(View view){
        Intent intent = new Intent(this, DownLoadAct.class);
        startActivity(intent);
    }


    public void getChachedAddr(View view){
        Intent intent = new Intent(this, CacheAddrAct.class);
        startActivity(intent);
    }
}
