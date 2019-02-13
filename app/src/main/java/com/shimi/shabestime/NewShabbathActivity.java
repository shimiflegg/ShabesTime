package com.shimi.shabestime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class NewShabbathActivity extends AppCompatActivity {
    private EditText mDate_editTxt;
    private EditText mEntryTime_editTxt;
    private EditText  mExitTime_editTxt;
    private Spinner mShabbathName_spineer;
    private Button mAdd_btn;
    private Button mBach_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_shabbath);
        mDate_editTxt=(EditText)findViewById(R.id.date_edit_txt);
        mEntryTime_editTxt=(EditText)findViewById(R.id.entrytime_edit_txt);
        mExitTime_editTxt=(EditText)findViewById(R.id.exit_time_edit_txt);
        mShabbathName_spineer=(Spinner)findViewById(R.id.shabbath_name_spineer);
        mAdd_btn=(Button)findViewById(R.id.update_btn);
        mBach_btn=(Button)findViewById(R.id.back_btn);


        mAdd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Shabbath shabbath=new Shabbath();
                shabbath.setDate(mDate_editTxt.getText().toString());
                shabbath.setEntry_time(mEntryTime_editTxt.getText().toString());
                shabbath.setExit_time(mExitTime_editTxt.getText().toString());
                shabbath.setName(mShabbathName_spineer.getSelectedItem().toString());
                new FirebaseDatabaseHelper().addShabbath(shabbath, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoded(List<Shabbath> shabbaths, List<String> Keys) {

                    }

                    @Override
                    public void DataIsInserted() {
                        Toast.makeText(NewShabbathActivity.this,"פרשת" + " נוספה בהצלחה " ,Toast
                        .LENGTH_LONG).show();
                    }

                    @Override
                    public void DataIsUpdate() {

                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });

            }
        });
         mBach_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 finish();return;
             }
         });
    }
}
