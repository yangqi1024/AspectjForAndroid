package com.example.gsz.buriedpoint;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public  static  boolean isLogin = false;
    private View mViewById;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewById = findViewById(R.id.tv_click);

        mViewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvClick(v);
            }
        });
        findViewById(R.id.tv_Login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isLogin = true;
            }
        });
    }

    @BuryPoint("122313123")
    @CheckLogin()
    public void tvClick(View view) {
        Log.d("SingleClickAspect", "tvClick:点击了");
    }
}
