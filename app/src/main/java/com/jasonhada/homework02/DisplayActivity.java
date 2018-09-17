package com.jasonhada.homework02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    Evaluation eval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        if(getIntent() != null && getIntent().getExtras() != null) {
            eval = (Evaluation) getIntent().getExtras().getSerializable(MainActivity.EVAL_KEY);

            ImageView avatar = findViewById(R.id.displayAvatar_iv);
            avatar.setImageResource(eval.avatarImageId);

            TextView nickname = findViewById(R.id.displayNickname_et);
            nickname.setText(eval.nickname);

            TextView program = findViewById(R.id.displayProgram_tv);
            program.setText(eval.study);

            RatingBar structureRb = findViewById(R.id.displayStructure_rb);
            structureRb.setRating(eval.structured+1);

            RatingBar deadlinesRb = findViewById(R.id.displayDeadlines_rb);
            deadlinesRb.setRating(eval.deadlines+1);

            RatingBar alignmentRb = findViewById(R.id.displayAlignment_rb);
            alignmentRb.setRating(eval.aligned+1);
        }


    }
}
