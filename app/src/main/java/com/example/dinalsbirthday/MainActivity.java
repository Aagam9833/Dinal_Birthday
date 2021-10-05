package com.example.dinalsbirthday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText unlockText = findViewById(R.id.unlock_password);
        Button unlock = findViewById(R.id.unlock);
        Button power = findViewById(R.id.power_button);
        Button unlocking = findViewById(R.id.unlock_phone);
        LinearLayout mainLayout = findViewById(R.id.main_layout);
        LinearLayout innerLayout = findViewById(R.id.inner_layout);

        power.setOnClickListener(view -> {
            mainLayout.setBackground(getDrawable(R.drawable.wallpaper));
            unlocking.setVisibility(View.VISIBLE);
            innerLayout.setBackground(getDrawable(R.drawable.wallpaper));
            power.setVisibility(View.GONE);
        });

        unlocking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                innerLayout.setVisibility(View.VISIBLE);
                innerLayout.setBackground(getDrawable(R.drawable.wallpaper_blur));
            }
        });

        unlock.setOnClickListener(view -> {
            String text = unlockText.getText().toString().trim().toLowerCase();
            if(text.equals("shah parivaar")){
                startActivity(new Intent(MainActivity.this,HomeScreen.class));
            }else{
                Toast.makeText(MainActivity.this, "Its sed that you don't remember!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}