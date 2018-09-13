package com.jasonhada.homework02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SelectAvatarActivity extends AppCompatActivity {
    static String IMAGE_KEY = "IMAGE KEY";
    Intent main = new Intent(SelectAvatarActivity.this, MainActivity.class);

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
                Bundle img1Bundle = new Bundle();
                img1Bundle.putInt(IMAGE_KEY, R.drawable.avatar_f_1);
                main.putExtras(img1Bundle);
                startActivity(main);
                finish();
            }
        });

        av2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle img2Bundle = new Bundle();
                img2Bundle.putInt(IMAGE_KEY, R.drawable.avatar_m_1);
                main.putExtras(img2Bundle);
                startActivity(main);
                finish();
            }
        });

        av3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle img3Bundle = new Bundle();
                img3Bundle.putInt(IMAGE_KEY, R.drawable.avatar_f_2);
                main.putExtras(img3Bundle);
                startActivity(main);
                finish();
            }
        });

        av4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle img4Bundle = new Bundle();
                img4Bundle.putInt(IMAGE_KEY, R.drawable.avatar_m_2);
                main.putExtras(img4Bundle);
                startActivity(main);
                finish();
            }
        });

        av5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle img5Bundle = new Bundle();
                img5Bundle.putInt(IMAGE_KEY, R.drawable.avatar_f_3);
                main.putExtras(img5Bundle);
                startActivity(main);
                finish();
            }
        });

        av6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle img6Bundle = new Bundle();
                img6Bundle.putInt(IMAGE_KEY, R.drawable.avatar_m_3);
                main.putExtras(img6Bundle);
                startActivity(main);
                finish();
            }
        });
    }
}
