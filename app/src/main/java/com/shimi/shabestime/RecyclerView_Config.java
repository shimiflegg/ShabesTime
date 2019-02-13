package com.shimi.shabestime;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static android.support.v7.widget.RecyclerView.*;

public class RecyclerView_Config {


    private Context mContext;

    private ShabbathAdapter mShabbathAdapter;
    public void setConfig(RecyclerView recyclerView,Context context ,List<Shabbath> shabbaths,List<String> Keys){
        mContext=context;
        mShabbathAdapter= new ShabbathAdapter(shabbaths,Keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mShabbathAdapter);





    }
    class ShabbathItemView extends ViewHolder {

        private TextView mName;
        private TextView mEntryTime;
        private TextView mExitTime;
        private TextView mDate;


        private String key;

        public ShabbathItemView(ViewGroup parant) {

            super(LayoutInflater.from(mContext).
                    inflate(R.layout.shabbath_list_item, parant, false));

            mName = (TextView) itemView.findViewById(R.id.name_txtView);
            mEntryTime = (TextView) itemView.findViewById(R.id.enter_timetxtView);
            mExitTime = (TextView) itemView.findViewById(R.id.exit_time_txtView);
            mDate = (TextView) itemView.findViewById(R.id.date_txtView);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent intent =new Intent(mContext,ShabbathDetailsActivity.class);
                    intent.putExtra("key",key);
                    intent.putExtra("Date",mDate.getText().toString());
                    intent.putExtra("Entry_time",mEntryTime.getText().toString());
                    intent.putExtra("Exit_time",mExitTime.getText().toString());
                    intent.putExtra("name",mName.getText().toString());

                    mContext.startActivity(intent);
                }
            });
        }
        public void bind(Shabbath shabbath, String Key) {
            mName.setText(shabbath.getName());
            mEntryTime.setText(shabbath.getEntry_time());
            mExitTime.setText(shabbath.getExit_time());
            mDate.setText(shabbath.getDate());
            this.key = Key;


        }
    }
        class ShabbathAdapter extends RecyclerView.Adapter<ShabbathItemView>{

            private List<Shabbath> mShabbathlist;
            private List<String> mKeys;

            public ShabbathAdapter(List<Shabbath> mShabbathlist, List<String> mKeys) {
                this.mShabbathlist = mShabbathlist;
                this.mKeys = mKeys;
            }

            @NonNull
            @Override
            public ShabbathItemView onCreateViewHolder(@NonNull ViewGroup parant, int viewType) {
                return new ShabbathItemView(parant);

            }

            @Override
            public void onBindViewHolder(@NonNull ShabbathItemView holdet, int position) {
                holdet.bind(mShabbathlist.get(position),mKeys.get(position));
            }

            @Override
            public int getItemCount() {
                return mShabbathlist.size();
            }
        }


    }

