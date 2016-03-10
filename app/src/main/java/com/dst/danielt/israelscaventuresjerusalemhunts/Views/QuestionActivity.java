package com.dst.danielt.israelscaventuresjerusalemhunts.Views;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dst.danielt.israelscaventuresjerusalemhunts.Classes.QuestionsRecyclerVAdapter;
import com.dst.danielt.israelscaventuresjerusalemhunts.R;

public class QuestionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        RecyclerView recVQuestions = (RecyclerView)findViewById(R.id.RecycVQuestions);
        recVQuestions.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);

        recVQuestions.setLayoutManager(llm);
        String[] questions = this.getResources().getStringArray(R.array.QuestionsCardo);

        QuestionsRecyclerVAdapter quAdapter = new QuestionsRecyclerVAdapter(questions );

        recVQuestions.setAdapter(quAdapter);


    }

}
