package com.example.dinalsbirthday;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class HomeScreen extends AppCompatActivity {

    final Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/dinal-s-birthday.appspot.com/o/04%20Happy%20Birthday%20-%20Ishq%20Forever%20(Nakash%20Aziz)%20190Kbps.mp3?alt=media&token=95a70cfb-5404-4ecb-be57-9a58b2f9a92e");
    MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        try {
            mediaPlayer.setDataSource(this, uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.prepare(); //don't use prepareAsync for mp3 playback
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageView aarogya = findViewById(R.id.aarogya);
        aarogya.setOnClickListener(view -> {
            Toast.makeText(this, "Tough year because of this right?", Toast.LENGTH_SHORT).show();
        });

        ImageView amazon = findViewById(R.id.amazon);
        amazon.setOnClickListener(view -> {
            Toast.makeText(this, "Mein gift bolta hu, tu apne liye hi order karle xD", Toast.LENGTH_SHORT).show();
        });

        ImageView bday = findViewById(R.id.bdayIcon);
        bday.setOnClickListener(view -> {
            Toast.makeText(this, "Its already open!! \nRecursion mein daalegi?", Toast.LENGTH_SHORT).show();
        });

        ImageView bms = findViewById(R.id.bms);
        bms.setOnClickListener(view -> Toast.makeText(this, "Latest Movie, Cheese caramel popcorn? \nLETS GOOO!!", Toast.LENGTH_SHORT).show());

        ImageView calculator = findViewById(R.id.calculator);
        calculator.setOnClickListener(view -> {
            Toast.makeText(this, "2021 - 1991", Toast.LENGTH_SHORT).show();
        });

        ImageView calendar = findViewById(R.id.calendar);
        calendar.setOnClickListener(view -> {
            Toast.makeText(this, "Khudka birthday nahi pata kya?", Toast.LENGTH_SHORT).show();
        });

        ImageView camera = findViewById(R.id.camera);
        camera.setOnClickListener(view -> {
            Toast.makeText(this, "Shakal pese khadde hata, \nbadme hi camera open hoga!!", Toast.LENGTH_SHORT).show();
        });

        ImageView clock = findViewById(R.id.clock);
        clock.setOnClickListener(view -> {
            Toast.makeText(this, "Tera time acha hi chal raha hai! \n Move on!!", Toast.LENGTH_SHORT).show();
        });

        ImageView dominos = findViewById(R.id.pizza);
        dominos.setOnClickListener(view -> {
            Toast.makeText(this, "After you come, this is mandatory once", Toast.LENGTH_SHORT).show();
        });

        ImageView gallery = findViewById(R.id.gallery);
        gallery.setOnClickListener(view -> {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.pause();
            }
            startActivity(new Intent(this,Gallery.class));
        });

        ImageView inshorts = findViewById(R.id.inshorts);
        inshorts.setOnClickListener(view -> {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.pause();
            }
            startActivity(new Intent(this, Inshorts.class));
        });

        ImageView makemytrip = findViewById(R.id.makemytrip);
        makemytrip.setOnClickListener(view -> {
            Toast.makeText(this, "Coming home? Really? YAAAYYY!!", Toast.LENGTH_SHORT).show();
        });

        ImageView maps = findViewById(R.id.maps);
        maps.setOnClickListener(view -> {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.pause();
            }
            startActivity(new Intent(this, Maps.class));
        });

        ImageView message = findViewById(R.id.message);
        message.setOnClickListener(view -> {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.pause();
            }
            startActivity(new Intent(this,Quiz.class));
        });

        ImageView netflix = findViewById(R.id.netflix);
        netflix.setOnClickListener(view -> {
            Toast.makeText(this, "Movie Night! Tonights selection!\n Harry Potter? Batman? Marvel Marathon?", Toast.LENGTH_SHORT).show();
        });

        ImageView phone = findViewById(R.id.phone);
        phone.setOnClickListener(view -> {
            Toast.makeText(this, "Tuje time hi kaha hai call karneko. \nSo its useless to open this app", Toast.LENGTH_SHORT).show();
        });

        ImageView spotify = findViewById(R.id.spotify);
        spotify.setOnClickListener(view -> {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.pause();
            }else{
                mediaPlayer.start();
            }
        });

        ImageView whatsapp = findViewById(R.id.whatsapp);
        whatsapp.setOnClickListener(view -> {
            Toast.makeText(this, "Everybody is wishing. Nothing else", Toast.LENGTH_SHORT).show();
        });

        ImageView youtube = findViewById(R.id.youtube);
        youtube.setOnClickListener(view -> {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.pause();
            }
            startActivity(new Intent(this,Youtube.class));
        });

        ImageView zomato = findViewById(R.id.zomato);
        zomato.setOnClickListener(view -> {
            Toast.makeText(this, "Jaadi thay gayi che! Haji ketlu thusis", Toast.LENGTH_SHORT).show();
        });

    }
    @Override
    public void onBackPressed() {
        try {
            if(mediaPlayer.isPlaying() && mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
        }catch (Exception e){
            Log.d("TAGGED", String.valueOf(e));
        }

        super.onBackPressed();
    }

}