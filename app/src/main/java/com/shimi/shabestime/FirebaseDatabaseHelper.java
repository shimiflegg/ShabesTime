package com.shimi.shabestime;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {

    private FirebaseDatabase mDatabase;
    private DatabaseReference myRefShabbaths;
    private List<Shabbath> shabbaths=new ArrayList<>();
public interface DataStatus{
    void DataIsLoded(List<Shabbath> shabbaths,List<String> Keys );
    void DataIsInserted();
    void DataIsUpdate();
    void DataIsDeleted();



}
    public FirebaseDatabaseHelper() {
        mDatabase=FirebaseDatabase.getInstance();
        myRefShabbaths=mDatabase.getReference("Shabbaths");
    }
public void readShabbaths(final DataStatus dataStatus){
    myRefShabbaths.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            shabbaths.clear();
            List<String > Keys=new ArrayList<>();
            for(DataSnapshot keyNode: dataSnapshot.getChildren()){
              Keys.add( keyNode.getKey()) ;
              Shabbath shabbath=keyNode.getValue(Shabbath.class);
                shabbaths.add(shabbath);
            }
              dataStatus.DataIsLoded(shabbaths,Keys);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
}
}
