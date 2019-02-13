package com.shimi.shabestime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class ShabbathDetailsActivity extends AppCompatActivity {
    private EditText mDate_editTxt;
    private EditText mEntryTime_editTxt;
    private EditText  mExitTime_editTxt;
    private Spinner mShabbathName_spineer;
    private Button mDelete_btn;
    private Button mBach_btn;
    private Button mUpdate_btn;

    private String key;
    private String Date;
    private String Entry_time;
    private String Exit_time;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shabbath_details);

        key=getIntent().getStringExtra("key");
        name=getIntent().getStringExtra("name");
        Entry_time=getIntent().getStringExtra("Entry_time");
        Exit_time=getIntent().getStringExtra("Exit_time");
        Date=getIntent().getStringExtra("Date");



        mDate_editTxt=(EditText)findViewById(R.id.date_edit_txt);
        mDate_editTxt.setText(Date);

        mEntryTime_editTxt=(EditText)findViewById(R.id.entrytime_edit_txt);
        mEntryTime_editTxt.setText(Entry_time);
        mExitTime_editTxt=(EditText)findViewById(R.id.exit_time_edit_txt);
        mExitTime_editTxt.setText(Exit_time);
        mShabbathName_spineer=(Spinner)findViewById(R.id.shabbath_name_spineer);

        mShabbathName_spineer.setSelection(getIndex_SpineerItem(mShabbathName_spineer,name));

        mDelete_btn=(Button)findViewById(R.id.delete_btn);
        mBach_btn=(Button)findViewById(R.id.back_btn);
        mUpdate_btn=(Button)findViewById(R.id.update_btn);



        mUpdate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Shabbath shabbath=new Shabbath();
                shabbath.setEntry_time(mEntryTime_editTxt.getText().toString());
                shabbath.setExit_time(mExitTime_editTxt.getText().toString());
                shabbath.setDate(mDate_editTxt.getText().toString());
                shabbath.setName(mShabbathName_spineer.getSelectedItem().toString());

                new FirebaseDatabaseHelper().updateShabbath(key, shabbath, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoded(List<Shabbath> shabbaths, List<String> Keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdate() {
                        Toast.makeText(ShabbathDetailsActivity.this, "פרשת"+ "עודכנה בהצלחה!!",
                                Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });

        mDelete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FirebaseDatabaseHelper().deleteShabbath(key, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoded(List<Shabbath> shabbaths, List<String> Keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdate() {

                    }

                    @Override
                    public void DataIsDeleted() {
                         Toast.makeText(ShabbathDetailsActivity.this, "פרשת" +
                         "נמחקה בהצלחה" ,Toast.LENGTH_LONG).show();
                         finish();return;
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

    private int getIndex_SpineerItem(Spinner spinner,String item){

        int index=0;
        for (int i=0;i<spinner.getCount();i++)
        {
            if (spinner.getItemAtPosition(i).equals(item)){

                index=i;
                break;
            }
        }
        return index;
    }
}
