package com.ibratinnovations.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView optionA,optionB,optionC,optionD;
    private TextView questionnumber,question,score;
    private TextView chechkout1,checkout2;
    int currentIndex;
    int mscore=0;
    int qn=1;
    ProgressBar progressBar;
    AppCompatButton next;

    int CurrentQuestion,CurrentOptionA,CurrentOptionB,CurrentOptionC,CurrentOptionD;

    private questions[] questionBank= new questions[]
            {
                    new questions(R.string.question_1,R.string.question1_A,R.string.question1_B,R.string.question1_C,R.string.question1_D,R.string.answer_1),
                    new questions(R.string.question_2,R.string.question_2A,R.string.question_2B,R.string.question_2C,R.string.question_2D,R.string.answer_2),
                    new questions(R.string.question_3,R.string.question_3A,R.string.question_3B,R.string.question_3C,R.string.question_3D,R.string.answer_3),
                    new questions(R.string.question_4,R.string.question_4A,R.string.question_4B,R.string.question_4C,R.string.question_4D,R.string.answer_4),
                    new questions(R.string.question_5,R.string.question_5A,R.string.question_5B,R.string.question_5C,R.string.question_5D,R.string.answer_5),
                    };

    final int PROGRESS_BAR = (int) Math.ceil(100/questionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        optionA=findViewById(R.id.optionA);
        optionB=findViewById(R.id.optionB);
        optionC=findViewById(R.id.optionC);
        optionD=findViewById(R.id.optionD);

        question = findViewById(R.id.question);
        questionnumber=findViewById(R.id.QuestionNumber);
        next=findViewById(R.id.next);

        chechkout1=findViewById(R.id.selectoption);
        checkout2=findViewById(R.id.CorrectAnswer);
        progressBar=findViewById(R.id.progress_bar);

        CurrentQuestion=questionBank[currentIndex].getQuestionid();
        question.setText(CurrentQuestion);
        CurrentOptionA=questionBank[currentIndex].getOptionA();
        optionA.setText(CurrentOptionA);
        CurrentOptionB=questionBank[currentIndex].getOptionB();
        optionB.setText(CurrentOptionB);
        CurrentOptionC=questionBank[currentIndex].getOptionC();
        optionC.setText(CurrentOptionC);
        CurrentOptionD=questionBank[currentIndex].getOptionD();
        optionD.setText(CurrentOptionD);

        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionA.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
                optionA.setBackgroundResource(R.color.black);
                checkAnswer(CurrentOptionA);
            }
        });

        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionB.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
                optionB.setBackgroundResource(R.color.black);
                checkAnswer(CurrentOptionB);
            }
        });
        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionC.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
                optionC.setBackgroundResource(R.color.black);
                checkAnswer(CurrentOptionC);
            }
        });
        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionD.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
                optionD.setBackgroundResource(R.color.black);
                checkAnswer(CurrentOptionD);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateQuestion();
            }
        });
    }
    private void checkAnswer(int userSelection) {

        int correctanswer = questionBank[currentIndex].getAnswerid();

        chechkout1.setText(userSelection);
        checkout2.setText(correctanswer);

        String m = chechkout1.getText().toString().trim();
        String n = checkout2.getText().toString().trim();

        if (m.equals(n)) {
            mscore = mscore + 1;
        } else {
        }
    }
    @SuppressLint("SetTextI18n")
    private void updateQuestion() {

        currentIndex=(currentIndex+1)%questionBank.length;

        if(currentIndex==0)
        {

            AlertDialog.Builder alert=new AlertDialog.Builder(this);
            alert.setTitle("Quiz Over");
            alert.setCancelable(false);
            alert.setMessage("Your Score " + mscore +" points");
            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            alert.setNegativeButton("Return", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mscore=0;
                    qn=1;
                    progressBar.setProgress(0);
                    questionnumber.setText(qn + "/" + questionBank.length +"Question");
                }
            });

            alert.show();

        }



        CurrentQuestion=questionBank[currentIndex].getQuestionid();
        question.setText(CurrentQuestion);
        CurrentOptionA=questionBank[currentIndex].getOptionA();
        optionA.setText(CurrentOptionA);
        optionA.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
        optionA.setBackgroundResource(R.color.teal_200);
        CurrentOptionB=questionBank[currentIndex].getOptionB();
        optionB.setText(CurrentOptionB);
        optionB.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
        optionB.setBackgroundResource(R.color.teal_200);
        CurrentOptionC=questionBank[currentIndex].getOptionC();
        optionC.setText(CurrentOptionC);
        optionC.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
        optionC.setBackgroundResource(R.color.teal_200);
        CurrentOptionD=questionBank[currentIndex].getOptionD();
        optionD.setText(CurrentOptionD);
        optionD.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
        optionD.setBackgroundResource(R.color.teal_200);

        qn=qn+1;

        if(qn<=questionBank.length)

        {
            questionnumber.setText(qn + "/" + questionBank.length +"Question");
        }
        progressBar.incrementProgressBy(PROGRESS_BAR);


    }
}