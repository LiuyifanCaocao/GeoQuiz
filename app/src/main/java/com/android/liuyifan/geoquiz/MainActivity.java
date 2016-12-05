package com.android.liuyifan.geoquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    private Button mButton_yes;
    private View mBundle_no;
    private TextView mTextView_question;
    private Button mButton_next;
    private Question[] mQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton_yes = (Button) findViewById(R.id.yes);
        mBundle_no = findViewById(R.id.no);
        mButton_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                util.show_toast(MainActivity.this,R.string.yes);
            }
        });
        mBundle_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                util.show_toast(MainActivity.this,R.string.no);
            }
        });
        mQuestion = new Question[]{
                new Question(R.string.haaaaaaaaaaaaaa,true),
                new Question(R.string.haaaaaaaaaaaaaa2,true),
                new Question(R.string.haaaaaaaaaaaaaa3,true),
                new Question(R.string.haaaaaaaaaaaaaa4,true),
        };

    }
}
