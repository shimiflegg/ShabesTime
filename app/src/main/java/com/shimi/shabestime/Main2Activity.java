package com.shimi.shabestime;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebViewDatabase;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    /*private static final String TAG = "Shimi";
*//**//*private Button btnViewDatabase;*/


       private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

         mRecyclerView=(RecyclerView) findViewById(R.id.recycleView_shabbath) ;
         new FirebaseDatabaseHelper().readShabbaths(new FirebaseDatabaseHelper.DataStatus() {
             @Override
             public void DataIsLoded(List<Shabbath> shabbaths, List<String> Keys) {
                 new RecyclerView_Config().setConfig(mRecyclerView,Main2Activity.this,
                         shabbaths,Keys);
             }

             @Override
             public void DataIsInserted() {

             }

             @Override
             public void DataIsUpdate() {

             }

             @Override
             public void DataIsDeleted() {

             }
         });


                FirebaseDatabase database = FirebaseDatabase.getInstance();


        // [START basic_write]
 /*ArrayList<Shabbath> shabbaths= new ArrayList<Shabbath>();*/


        // Read from the database
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                Log.d(TAG, "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
    }

    public boolean onCreatOptionManu(Menu menu){

        getMenuInflater().inflate(R.menu.shabbathlist_activity_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId())
        {
            case R.id.new_shabbath:
                startActivity(new Intent(this,NewShabbathActivity.class));
                return true;


        }
        return  super.onOptionsItemSelected(item);
    }
}
