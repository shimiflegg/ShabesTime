import android.net.Uri;
import android.support.annotation.NonNull;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class model {

    static model instance = new model();

    private model() {
    }

    public void addNewMessage(String sabbath, String img) {
        MySabbath s = new MySabbath(FirebaseAuth.getInstance().getCurrentUser().getDisplayName(),sabbath, img);

        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference().child("MyMessages");
        mRef.child(mRef.push().getKey()).setValue(s);
    }

    public FirebaseRecyclerOptions<MySabbath> getAllMessages() {

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference().child("MySabbath");

        FirebaseRecyclerOptions<MySabbath> options = new FirebaseRecyclerOptions.Builder<MySabbath>()
                .setQuery(mRef, MySabbath.class)
                .build();

        return options;
    }

    public void upload(Uri file, String name, final String msg){
        StorageReference storageRef = FirebaseStorage.getInstance().getReference().child("images");

        StorageReference ref = storageRef.child("users/" + FirebaseAuth.getInstance().getCurrentUser().getUid()).child(name);

        ref.putFile(file)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Uri downloadUrl = taskSnapshot.getUploadSessionUri();
                        model.instance.addNewMessage(msg, downloadUrl.toString());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                    }
                });
    }


}
