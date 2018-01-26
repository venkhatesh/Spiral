package com.example.venkat.spiral;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import static android.provider.Contacts.SettingsColumns.KEY;
import static android.util.JsonToken.NAME;

public class MainActivity extends AppCompatActivity {

    CardView cv_slots;
    DatabaseReference mdatabase;
    int id;
//    HashMap<String,String> Slots1=new HashMap<String, String>();
//    HashMap<String,String> Slots2= new HashMap<String, String>();
//    HashMap<String,String> Slots3 = new HashMap<String, String>();
//    HashMap<String,String> Slots4 = new HashMap<String, String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mdatabase= FirebaseDatabase.getInstance().getReference();
    }

    public void Buclick(View view) {
        cv_slots = (CardView)view;
        switch (cv_slots.getId()){

            case R.id.button1:
                mdatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot childDataSnapshot : dataSnapshot.child("Slots").child("1").getChildren()) {
                            Log.v("mainactivity",""+ childDataSnapshot.getKey()); //displays the key for the node
                            Log.v("main",""+ childDataSnapshot.getValue());
                            // Log.v(TAG,""+ childDataSnapshot.child(--ENTER THE KEY NAME eg. firstname or email etc.--).getValue());   //gives the value for given keyname
 //                           Slots1.put(childDataSnapshot.getKey(), String.valueOf(childDataSnapshot.getValue()));
                           // Log.v("main","" +  Slots1.get(childDataSnapshot.getKey()));
                        }

//                        Intent i = new Intent(this,Slot_Recycler.class);
//                        i.putExtra("Hashlist",Slots1);
//                        startActivity(i);
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            case R.id.button2:
                id=2;
                Intent it = new Intent(this,Slots_Recycler.class);
                it.putExtra("intID", id);
                startActivity(it);

            case R.id.button3:

            case R.id.button4:

        }

    }
}
