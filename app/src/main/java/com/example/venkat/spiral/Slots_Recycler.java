package com.example.venkat.spiral;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Slots_Recycler extends AppCompatActivity {
    DatabaseReference mdatabase;
    HashMap<String,String> Slots1=new HashMap<String, String>();
    HashMap<String,String> Slots2= new HashMap<String, String>();
    HashMap<String,String> Slots3 = new HashMap<String, String>();
    HashMap<String,String> Slots4 = new HashMap<String, String>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slots__recycler);
        recyclerView=(RecyclerView) findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mdatabase= FirebaseDatabase.getInstance().getReference();
        Intent mIntent = getIntent();
        int id = mIntent.getIntExtra("intID", 0);
        if(id==2){
            mdatabase.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot childDataSnapshot : dataSnapshot.child("Slots").child("2").getChildren()) {
                        Log.v("mainactivity",""+ childDataSnapshot.getKey()); //displays the key for the node
                        Log.v("main",""+ childDataSnapshot.getValue());
                        // Log.v(TAG,""+ childDataSnapshot.child(--ENTER THE KEY NAME eg. firstname or email etc.--).getValue());   //gives the value for given keyname
                        Slots2.put(childDataSnapshot.getKey(), String.valueOf(childDataSnapshot.getValue()));
                        // Log.v("main","" +  Slots1.get(childDataSnapshot.getKey()));
                    }

//
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            MainAdapter x = new MainAdapter(Slots2);
            recyclerView.setAdapter(x);
        }

    }
}
