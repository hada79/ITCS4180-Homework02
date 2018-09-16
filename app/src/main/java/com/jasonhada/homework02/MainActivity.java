package com.jasonhada.homework02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    RadioGroup studioRadio;
    int pic, courseProgress = 0, assignmentProgress = 0, structureProgress = 0;
    static String NICKNAME_KEY = "NICKNAME", RADIO_KEY = "RADIO", COURSE_KEY = "COURSE",
            ASSIGNMENT_KEY = "ASSIGNMENT", STRUCTURE_KEY = "STRUCTURE";
    ImageView selectAvatar = findViewById(R.id.selectAvatar_iv);
    EditText nickname = findViewById(R.id.nickname_et);
    SeekBar seekCourse = findViewById(R.id.structure_sb);
    SeekBar seekAssignment = findViewById(R.id.deadlines_sb);
    SeekBar seekStructure = findViewById(R.id.aligned_sb);
    Intent profileSelect = new Intent(MainActivity.this, SelectAvatarActivity.class);
    Intent display = new Intent(MainActivity.this, SelectAvatarActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Click on an avatar starts select avatar intent
        selectAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(profileSelect);
            }
        });

        //Get the intent and image from the select avatar class
        //which then sets the avatar image on the main class
        selectAvatar = findViewById(R.id.displayAvatar_iv);
        Bundle mainBundle = getIntent().getExtras();
        pic = mainBundle.getInt(SelectAvatarActivity.IMAGE_KEY);
        selectAvatar.setImageResource(pic);

        //Radio group which sends whichever radio button is clicked to the display class
        findViewById(R.id.study_rg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton gradRb = findViewById(R.id.grad_rb);
                RadioButton underRb = findViewById(R.id.undergrad_rb);
                int id = studioRadio.getCheckedRadioButtonId();

                if(id == R.id.grad_rb){
                    display.putExtra(RADIO_KEY, gradRb.getText().toString());
                }else{
                    display.putExtra(RADIO_KEY, underRb.getText().toString());
                }
            }
        });

        //Sends seek bar info to the display class
        seekCourse.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                courseProgress = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                display.putExtra(COURSE_KEY, courseProgress);
            }
        });

        //Sends seek bar info to the display class
        seekAssignment.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                assignmentProgress = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                display.putExtra(ASSIGNMENT_KEY, assignmentProgress);
            }
        });

        //Sends seek bar info to the display class
        seekStructure.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                structureProgress = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                display.putExtra(STRUCTURE_KEY, structureProgress);
            }
        });

        findViewById(R.id.submit_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Edit Text sends data to display
                display.putExtra(NICKNAME_KEY, nickname.getText().toString());

                //Sends the avatar image to the display class
                Bundle displayBundle = new Bundle();
                displayBundle.putInt(SelectAvatarActivity.IMAGE_KEY, pic);
                display.putExtras(displayBundle);


                //Once you click submit it starts the display intent
                startActivity(display);
            }
        });
    }
}
