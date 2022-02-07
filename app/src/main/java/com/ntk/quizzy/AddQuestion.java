package com.ntk.quizzy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddQuestion extends AppCompatActivity {

    ImageView image;
    Context context;
    Button btn;

    static final int REQUEST_IMAGE_GET = 1;

    private EditText addQTitle ,addQop1 ,addQop2 ,addQop3 ,addQop4,addRight;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);

        context = this;

        btn = findViewById(R.id.btn);

        image = (ImageView) findViewById(R.id.pickedImage);
        addQTitle = findViewById(R.id.addQTitle);
        addQop1 = findViewById(R.id.addQop1);
        addQop2 = findViewById(R.id.addQop2);
        addQop3 = findViewById(R.id.addQop3);
        addQop4 = findViewById(R.id.addQop4);
        addRight = findViewById(R.id.addRight);
        save = findViewById(R.id.addQsave);

        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        /*
                        Intent galleryIntent = new Intent();
                        galleryIntent.setType("image/*");
                        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(Intent.createChooser(galleryIntent, "Select Picture"), 200);
                        */
                        image.setImageResource(R.drawable.face);

                    }
                        /*
                        public void onActivityResult(int requestCode, int resultCode, Intent data) {
                            onActivityResult(requestCode, resultCode, data);

                            if (resultCode == RESULT_OK) {
                                if (requestCode == 200) {
                                    // Get the uri
                                    Uri selectedImageUri = data.getData();
                                    if (null != selectedImageUri) {
                                        // update your imageview
                                        image.setImageURI(selectedImageUri);
                                    }
                                }
                            }
                        }
                        */

                }
        );

        save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        SaveQ(); //This function will save our Ques
                    }
                }
        );



    }


    public void SaveQ () {
    if
    (
            //image.getDrawable().toString() != null && !image.getDrawable().toString().isEmpty() &&
            addQTitle.getText().toString() != null && !addQTitle.getText().toString().isEmpty() &&
            addQop1.getText().toString() != null && !addQop1.getText().toString().isEmpty() &&
            addQop2.getText().toString() != null && !addQop2.getText().toString().isEmpty() &&
            addQop3.getText().toString() != null && !addQop3.getText().toString().isEmpty() &&
            addQop4.getText().toString() != null && !addQop4.getText().toString().isEmpty()
    ){

    ////This is The first Question in our database
    AnswerStructure NQOne = new AnswerStructure(addQop1.getText().toString(), false);
    AnswerStructure NQTwo = new AnswerStructure(addQop2.getText().toString(), false);
    AnswerStructure NQThree = new AnswerStructure(addQop3.getText().toString(), false);
    AnswerStructure NQFour = new AnswerStructure(addQop4.getText().toString(), false);
    if(addRight.getText().toString().equals("1")){
        NQOne.setItRight(true);
    }else if(addRight.getText().toString().equals("2")){
        NQTwo.setItRight(true);
    }else if(addRight.getText().toString().equals("3")){
        NQThree.setItRight(true);
    }else if(addRight.getText().toString().equals("4")){
        NQFour.setItRight(true);
    }else {
        Toast.makeText(getApplicationContext(),"Please insert right answer between 1 and 4", Toast.LENGTH_SHORT).show();
        return;
    }
    QuestionStructure NQ = new QuestionStructure(Database.get().ListofQues.size() ,addQTitle.getText().toString(),NQOne,NQTwo ,NQThree,NQFour ,R.drawable.face);
    Database.get().ListofQues.add(NQ);
    Toast.makeText(getApplicationContext(),"OK", Toast.LENGTH_SHORT).show();
    }else
    {
        Toast.makeText(getApplicationContext(),"Please fill all fields", Toast.LENGTH_SHORT).show();
    }
  }

}