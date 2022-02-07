package com.ntk.quizzy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AllQuestions extends AppCompatActivity {

    ArrayList<QuestionStructure> DatalistOfQues = Database.get().getListofQues();
    private ListView listOfQues;
    private Button az;
    private Boolean isItZtoA = true;
    private QuestionsAdapter QuestionsAdapter = new QuestionsAdapter();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_questions);
        listOfQues = findViewById(R.id.listOfQues); //Binding
        listOfQues.setFastScrollEnabled(true); // Enable FastScrollEnabled
        az = findViewById(R.id.az); //Binding
        az.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        sorter(); //This function will open our AboutPage
                    }
                }
        );

        ///////////////////////////////////////////////////////////
        sorter();
        listOfQues.setAdapter(QuestionsAdapter);


    }

    public void sorter(){
      if(isItZtoA) {
          /////////////////////////////////////////////////////////////////////////// Sorted A To Z By Def
          Comparator<QuestionStructure> x = new Comparator<QuestionStructure>() {
              @Override
              public int compare(QuestionStructure Q, QuestionStructure QQ) {
                  return Q.getQus().compareTo(QQ.getQus());
              }
          };
          Collections.sort(DatalistOfQues, x);
          isItZtoA = false;
          ///////////////////////////////////////////////////////////////////////////

      }else {
          /////////////////////////////////////////////////////////////////////////// Sorted Z To A By Def
          Comparator<QuestionStructure> x = new Comparator<QuestionStructure>() {
              @Override
              public int compare(QuestionStructure Q, QuestionStructure QQ) {
                  return QQ.getQus().compareTo(Q.getQus()); // Switch between Q and QQ :-)
              }
          };
          Collections.sort(DatalistOfQues, x);
          isItZtoA = true;
          ///////////////////////////////////////////////////////////////////////////
      }
       QuestionsAdapter.notifyDataSetChanged();
    }

    class QuestionsAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return DatalistOfQues.size() ;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view   = getLayoutInflater().inflate(R.layout.activity_singleitem,null);
            TextView questitlecontent = view.findViewById(R.id.questitlecontent);
            TextView quesdes = view.findViewById(R.id.quesdes);
            ImageView quesimg = view.findViewById(R.id.quesimg);
            quesimg.setImageResource(DatalistOfQues.get(i).getQuesImage());
            questitlecontent.setText(DatalistOfQues.get(i).getQus());

            //Here we need to get just the correct
            if (DatalistOfQues.get(i).getOptionOne().getItRight()){
                quesdes.setText(DatalistOfQues.get(i).getOptionOne().getAnswer());
            }else if (DatalistOfQues.get(i).getOptionTwo().getItRight()){
                quesdes.setText(DatalistOfQues.get(i).getOptionTwo().getAnswer());
            }else if (DatalistOfQues.get(i).getOptionThree().getItRight()){
                quesdes.setText(DatalistOfQues.get(i).getOptionThree().getAnswer());
            }else if (DatalistOfQues.get(i).getOptionFour().getItRight()){
                quesdes.setText(DatalistOfQues.get(i).getOptionFour().getAnswer());
            }else{
                quesdes.setText("There is no right answer :-)");
            }

            return view;
        }
    }

}