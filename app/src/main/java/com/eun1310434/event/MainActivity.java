/**
 * 05.03.2018
 * eun1310434@naver.com
 * https://blog.naver.com/eun1310434
 * 참고) Do it android programming
 */

package com.eun1310434.event;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    GestureDetector detector;
    ScrollView SV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SV = (ScrollView)  findViewById(R.id.sv_log);
        textView = (TextView) findViewById(R.id.textView);//Log를 나타냄

        View view = findViewById(R.id.view);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();

                float curX = motionEvent.getX(); //화면의 X좌표
                float curY = motionEvent.getY(); //화면의 Y좌표

                if (action == MotionEvent.ACTION_DOWN) {
                    logIn("OnTouchListener - DOWN : " + curX + ", " + curY);
                    //누름
                } else if (action == MotionEvent.ACTION_MOVE) {
                    logIn("OnTouchListener - MOVE : " + curX + ", " + curY);
                    //움직임
                } else if (action == MotionEvent.ACTION_UP) {
                    logIn("OnTouchListener - UP : " + curX + ", " + curY);
                    //올림
                }
                return true;
            }
        });

        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                logIn("GestureDetector - onDown() : "+motionEvent.getX()+" , "+motionEvent.getY());
                return true;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {
                logIn("GestureDetector - onShowPress() : "+motionEvent.getX()+" , "+motionEvent.getY());
            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                logIn("GestureDetector - onSingleTapUp() : "+motionEvent.getX()+" , "+motionEvent.getY());
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                logIn("GestureDetector - onScroll() : " + v + ", " + v1);

                return true;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                logIn("GestureDetector - onLongPress() : "+motionEvent.getX()+" , "+motionEvent.getY());
            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                logIn("GestureDetector - onFling() : " + v + ", " + v1);

                return true;
            }
        });

        View view2 = findViewById(R.id.view2);
        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                detector.onTouchEvent(motionEvent);
                return true;
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            Toast.makeText(this, "Pressed BACK Btn", Toast.LENGTH_SHORT).show();
            logIn("onKeyDown() : Pressed BACK Btn");
            return true;
        }
        return false;
    }


    public void logIn(String data) {
        textView.append(data + "\n");//기존의 글자를 로그 찍듯이 추가
    }
}
