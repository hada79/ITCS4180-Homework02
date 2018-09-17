package com.jasonhada.homework02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SelectAvatarActivity extends AppCompatActivity {
    public static String IMAGE_KEY = "IMAGE KEY";

    void returnImageId(int id) {
        Intent i = new Intent();
        i.putExtra(IMAGE_KEY, id);
        setResult(RESULT_OK, i);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_avatar_);

        ImageView av1 = findViewById(R.id.avatar1_iv);
        ImageView av2 = findViewById(R.id.avatar2_iv);
        ImageView av3 = findViewById(R.id.avatar3_iv);
        ImageView av4 = findViewById(R.id.avatar4_iv);
        ImageView av5 = findViewById(R.id.avatar5_iv);
        ImageView av6 = findViewById(R.id.avatar6_iv);

        av1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnImageId(R.drawable.avatar_f_1);
            }
        });

        av2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnImageId(R.drawable.avatar_m_3);
            }
        });

        av3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnImageId(R.drawable.avatar_f_2);
            }
        });

        av4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnImageId(R.drawable.avatar_m_2);
            }
        });

        av5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnImageId(R.drawable.avatar_f_3);
            }
        });

        av6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnImageId(R.drawable.avatar_m_1);
            }
        });
    }
}
