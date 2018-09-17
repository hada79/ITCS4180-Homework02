package com.jasonhada.homework02;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String[] indicators = {"Strongly Disagree", "Disagree", "Neutral", "Agree", "Strongly Agree"};
    static String EVAL_KEY = "EVAL";
    public static int REQ_CODE = 100;

    int structureStatus, deadlinesStatus, alignedStatus, avatarImageId;
    String study;
    EditText nickname;
    ImageView selectAvatar;
    Intent profileSelect;
    RadioGroup studioRadio;
    SeekBar structure_sb, deadlines_sb, aligned_sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize class members and set default values
        init();

        //Click on an avatar starts select avatar intent
        selectAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SelectAvatarActivity.class);
                startActivityForResult(profileSelect, REQ_CODE);
            }
        });

        //Radio group which sends whichever radio button is clicked to the display class
        RadioGroup rg = findViewById(R.id.study_rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.grad_rb) {
                    study = "Graduate Student";
                } else if(checkedId == R.id.undergrad_rb) {
                    study = "Undergrad Student";
                }
            }
        });

        structure_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                structureStatus = seekBar.getProgress();
                TextView structureIndicator = (TextView)findViewById(R.id.structureIndicator_tv);
                structureIndicator.setText(indicators[structureStatus]);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        deadlines_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                deadlinesStatus = seekBar.getProgress();
                TextView deadlinesIndicator = (TextView)findViewById(R.id.deadlinesIndicator_tv);
                deadlinesIndicator.setText(indicators[deadlinesStatus]);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        aligned_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                alignedStatus = seekBar.getProgress();
                TextView alignedIndicator = (TextView)findViewById(R.id.alignedIndicator_tv);
                alignedIndicator.setText(indicators[alignedStatus]);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Submit Data
        findViewById(R.id.submit_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validate nickname
                String nick = nickname.getText().toString();

                if(nick.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Nickname cannot be empty.", Toast.LENGTH_SHORT).show();
                    return;
                } else if(avatarImageId == 0) {
                    Toast.makeText(getApplicationContext(), "You must choose an avatar before continuing.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent i = new Intent(MainActivity.this, DisplayActivity.class);
                Evaluation eval = new Evaluation(nick, study, avatarImageId, structureStatus, deadlinesStatus, alignedStatus);
                i.putExtra(EVAL_KEY, eval);
                startActivity(i);
            }
        });
    }

    private void init() {

        selectAvatar = findViewById(R.id.selectAvatar_iv);
        nickname = findViewById(R.id.nickname_et);
        profileSelect = new Intent(MainActivity.this, SelectAvatarActivity.class);
        structure_sb = (SeekBar) findViewById(R.id.structure_sb);
        deadlines_sb = (SeekBar) findViewById(R.id.deadlines_sb);
        aligned_sb = (SeekBar) findViewById(R.id.aligned_sb);

        // Set seekbar initial values
        structureStatus = structure_sb.getProgress();
        TextView structureIndicator = (TextView)findViewById(R.id.structureIndicator_tv);
        structureIndicator.setText(indicators[structureStatus]);

        deadlinesStatus = deadlines_sb.getProgress();
        TextView deadlinesIndicator = (TextView)findViewById(R.id.deadlinesIndicator_tv);
        deadlinesIndicator.setText(indicators[deadlinesStatus]);

        alignedStatus = aligned_sb.getProgress();
        TextView alignedIndicator = (TextView)findViewById(R.id.alignedIndicator_tv);
        alignedIndicator.setText(indicators[alignedStatus]);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQ_CODE) {
            if(resultCode == RESULT_OK) {
                avatarImageId = data.getExtras().getInt((SelectAvatarActivity.IMAGE_KEY));
                selectAvatar.setImageResource(avatarImageId);
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(getApplicationContext(), "Unable to get image.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
