package com.jasonhada.homework02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        TextView nicknameSet = findViewById(R.id.displayNickname_et);
        TextView programSet = findViewById(R.id.displayProgram_tv);
        ImageView avatarImage = findViewById(R.id.displayAvatar_iv);
        RatingBar courseRate = findViewById(R.id.displayAlignment_rb);
        RatingBar assignmentRate = findViewById(R.id.displayDeadlines_rb);
        RatingBar structureRate = findViewById(R.id.displayStructure_rb);

        String nickname = getIntent().getExtras().getString(MainActivity.NICKNAME_KEY);
        String radioKey = getIntent().getExtras().getString(MainActivity.RADIO_KEY);
        nicknameSet.setText(nickname);
        programSet.setText(radioKey);

        Bundle displayImage = getIntent().getExtras();
        int pic = displayImage.getInt(SelectAvatarActivity.IMAGE_KEY);
        avatarImage.setImageResource(pic);

        int course = getIntent().getExtras().getInt(MainActivity.COURSE_KEY);
        int assignment = getIntent().getExtras().getInt(MainActivity.ASSIGNMENT_KEY);
        int structure = getIntent().getExtras().getInt(MainActivity.STRUCTURE_KEY);
        courseRate.setRating(course);
        assignmentRate.setRating(assignment);
        structureRate.setRating(structure);
    }
}
