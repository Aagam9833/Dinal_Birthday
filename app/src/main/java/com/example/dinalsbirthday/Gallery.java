package com.example.dinalsbirthday;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;
import java.util.ArrayList;

public class Gallery extends AppCompatActivity {

    final String URL = "https://firebasestorage.googleapis.com/v0/b/dinal-s-birthday.appspot.com/o/Photograph%20-%20Ed%20Sheeran.mp3?alt=media&token=133bcbcc-af7b-4753-afb5-d84c8acb85b3";
    private DatabaseReference databaseReference;
    private StorageReference storageReference;
    private RecyclerView recyclerView;
    MediaPlayer mediaPlayer = new MediaPlayer();
    private RecyclerAdapter recyclerAdapter;
    private ArrayList<images> imagesArrayList;
    private final Context context = Gallery.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        mediaPlayer.setAudioAttributes(
                new AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
        );
        try {
            mediaPlayer.setDataSource(URL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mediaPlayer.prepare(); // might take long! (for buffering, etc)
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.start();

        databaseReference = FirebaseDatabase.getInstance().getReference();
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        storageReference = FirebaseStorage.getInstance().getReference();
        imagesArrayList = new ArrayList<>();
        init();


        Query query = databaseReference.child("Images");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    images images = new images();
                    images.setImageURL(snapshot.child("url").getValue().toString());
                    imagesArrayList.add(images);
                }
                recyclerAdapter = new RecyclerAdapter(context,imagesArrayList);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void init(){
        clearAll();
    }

    private void clearAll(){
        if(imagesArrayList != null){
            imagesArrayList.clear();
            if(recyclerAdapter != null){
                recyclerAdapter.notifyDataSetChanged();
            }
        }
        imagesArrayList = new ArrayList<>();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mediaPlayer.release();
    }
}