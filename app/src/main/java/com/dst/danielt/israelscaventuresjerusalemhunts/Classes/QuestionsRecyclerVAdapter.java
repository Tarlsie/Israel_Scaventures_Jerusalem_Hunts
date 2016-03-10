package com.dst.danielt.israelscaventuresjerusalemhunts.Classes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dst.danielt.israelscaventuresjerusalemhunts.R;

/**
 * Created by danielT on 07/03/2016.
 */
public class QuestionsRecyclerVAdapter extends RecyclerView.Adapter<QuestionsRecyclerVAdapter.QuestionsViewHolder> {
    String[] qus;

    public QuestionsRecyclerVAdapter( String[] qus){
        this.qus = qus;

    }
    @Override
    public QuestionsRecyclerVAdapter.QuestionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardv_questions,parent,false);
        QuestionsViewHolder quHolder = new QuestionsViewHolder(v);
        return quHolder;
    }

    @Override
    public void onBindViewHolder(QuestionsRecyclerVAdapter.QuestionsViewHolder holder, int position) {
            holder.quTitle.setText("Question "+(position+1));
        holder.quQuestion.setText(qus[position]);
    }

    @Override
    public int getItemCount() {
        return qus.length;
    }

    public class QuestionsViewHolder extends RecyclerView.ViewHolder {

        TextView quTitle, quQuestion;

        public QuestionsViewHolder(View itemView) {
            super(itemView);

            quTitle = (TextView) itemView.findViewById(R.id.TxtVQuestionsCrdVTitle);
            quQuestion = (TextView) itemView.findViewById(R.id.TxtVQuestionsCrdVQuestion);


        }

    }

}
