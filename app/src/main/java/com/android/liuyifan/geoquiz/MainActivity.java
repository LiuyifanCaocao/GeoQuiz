package com.android.liuyifan.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
    private Button mButton_yes;
    private View mBundle_no;
    private TextView mTextView_question;
    private Button mButton_next;
    private Button mButton_back;
    private Question[] mQuestion;
    private int mCurrentIndex = 0;
    private int question = 0;
    private ProgressBar mProgressBar;
    private CirclePgBar mCirclePgBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        changeBar();


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
        changeQuestion();
        mButton_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestion.length;
                changeQuestion();
            }
        });
        mButton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCurrentIndex < 1)return;
                mCurrentIndex = (mCurrentIndex - 1) % mQuestion.length;
                changeQuestion();
            }
        });
        mCirclePgBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SmsActivity.class));
            }
        });
        mProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SelfActivity.class));
            }
        });
    }
    private void changeQuestion(){
        question = mQuestion[mCurrentIndex].getTextResId();
        mTextView_question.setText(question);
    }
    //进度条
    private void changeBar(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int max = mProgressBar.getMax();
                while(max != mProgressBar.getProgress()){
                    int step = max/10;
                    int current = mProgressBar.getProgress();
                    mProgressBar.setProgress(step + current);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }
    //找组件
    private void initView(){
        mButton_yes = (Button) findViewById(R.id.yes);
        mBundle_no = findViewById(R.id.no);
        mButton_back = (Button) findViewById(R.id.backButton);
        mTextView_question = (TextView) findViewById(R.id.textView);
        mButton_next = (Button) findViewById(R.id.nextButton);
        mProgressBar = (ProgressBar) findViewById(R.id.bar);
        mCirclePgBar = (CirclePgBar) findViewById(R.id.circlePgBar);
    }
}
