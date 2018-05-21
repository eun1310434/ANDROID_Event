/*=====================================================================
□ Infomation
  ○ Data : 21.05.2018
  ○ Mail : eun1310434@naver.com
  ○ Blog : https://blog.naver.com/eun1310434
  ○ Reference : Do it android app Programming

□ Function
  ○ 0 --> "KEYCODE_UNKNOWN"
1 --> "KEYCODE_MENU"
2 --> "KEYCODE_SOFT_RIGHT"
3 --> "KEYCODE_HOME"
4 --> "KEYCODE_BACK"
5 --> "KEYCODE_CALL"
6 --> "KEYCODE_ENDCALL"
7 --> "KEYCODE_0"
8 --> "KEYCODE_1"
9 --> "KEYCODE_2"
10 --> "KEYCODE_3"
11 --> "KEYCODE_4"
12 --> "KEYCODE_5"
13 --> "KEYCODE_6"
14 --> "KEYCODE_7"
15 --> "KEYCODE_8"
16 --> "KEYCODE_9"
17 --> "KEYCODE_STAR"
18 --> "KEYCODE_POUND"
19 --> "KEYCODE_DPAD_UP"
20 --> "KEYCODE_DPAD_DOWN"
21 --> "KEYCODE_DPAD_LEFT"
22 --> "KEYCODE_DPAD_RIGHT"
23 --> "KEYCODE_DPAD_CENTER"
24 --> "KEYCODE_VOLUME_UP"
25 --> "KEYCODE_VOLUME_DOWN"
26 --> "KEYCODE_POWER"
27 --> "KEYCODE_CAMERA"
28 --> "KEYCODE_CLEAR"
29 --> "KEYCODE_A"
30 --> "KEYCODE_B"
31 --> "KEYCODE_C"
32 --> "KEYCODE_D"
33 --> "KEYCODE_E"
34 --> "KEYCODE_F"
35 --> "KEYCODE_G"
36 --> "KEYCODE_H"
37 --> "KEYCODE_I"
38 --> "KEYCODE_J"
39 --> "KEYCODE_K"
40 --> "KEYCODE_L"
41 --> "KEYCODE_M"
42 --> "KEYCODE_N"
43 --> "KEYCODE_O"
44 --> "KEYCODE_P"
45 --> "KEYCODE_Q"
46 --> "KEYCODE_R"
47 --> "KEYCODE_S"
48 --> "KEYCODE_T"
49 --> "KEYCODE_U"
50 --> "KEYCODE_V"
51 --> "KEYCODE_W"
52 --> "KEYCODE_X"
53 --> "KEYCODE_Y"
54 --> "KEYCODE_Z"
55 --> "KEYCODE_COMMA"
56 --> "KEYCODE_PERIOD"
57 --> "KEYCODE_ALT_LEFT"
58 --> "KEYCODE_ALT_RIGHT"
59 --> "KEYCODE_SHIFT_LEFT"
60 --> "KEYCODE_SHIFT_RIGHT"
61 --> "KEYCODE_TAB"
62 --> "KEYCODE_SPACE"
63 --> "KEYCODE_SYM"
64 --> "KEYCODE_EXPLORER"
65 --> "KEYCODE_ENVELOPE"
66 --> "KEYCODE_ENTER"
67 --> "KEYCODE_DEL"
68 --> "KEYCODE_GRAVE"
69 --> "KEYCODE_MINUS"
70 --> "KEYCODE_EQUALS"
71 --> "KEYCODE_LEFT_BRACKET"
72 --> "KEYCODE_RIGHT_BRACKET"
73 --> "KEYCODE_BACKSLASH"
74 --> "KEYCODE_SEMICOLON"
75 --> "KEYCODE_APOSTROPHE"
76 --> "KEYCODE_SLASH"
77 --> "KEYCODE_AT"
78 --> "KEYCODE_NUM"
79 --> "KEYCODE_HEADSETHOOK"
80 --> "KEYCODE_FOCUS"
81 --> "KEYCODE_PLUS"
82 --> "KEYCODE_MENU"
83 --> "KEYCODE_NOTIFICATION"
84 --> "KEYCODE_SEARCH"
85 --> "TAG_LAST_KEYCODE"

□ Study
  ○
=====================================================================*/
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
        if (keyCode == KeyEvent.KEYCODE_BACK) {
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