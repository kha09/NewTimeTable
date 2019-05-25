package com.example.timetable2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();
        initToolbar();
        setupListView();
    }
    private void setupUIViews(){
        toolbar = findViewById(R.id.ToolbarMain);
        listView = findViewById(R.id.listMain);
    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Timetable App");
    }

    private void setupListView(){
        String[] title = getResources().getStringArray(R.array.Main);
        String[] description = getResources().getStringArray(R.array.Description);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, title, description);
        listView.setAdapter(simpleAdapter);
    }

    public class SimpleAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title,description;
        private String[] titlearray;
        private String[] descriptionArray;
        private ImageView imageView;

        public SimpleAdapter(Context context, String[] title, String[] description){
            mContext = context;
            titlearray = title;
            descriptionArray = description;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return titlearray.length;
        }

        @Override
        public Object getItem(int position) {
            return titlearray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.main_activity_single_item,null);
            }
            title = convertView.findViewById(R.id.tvMain);
            description = convertView.findViewById(R.id.tvDescription);
            imageView = convertView.findViewById(R.id.ivMain);

            title.setText(titlearray[position]);
            description.setText(descriptionArray[position]);

            if (titlearray[position].equalsIgnoreCase("Timetable")){
                imageView.setImageResource(R.drawable.timetable);
            }else if (titlearray[position].equalsIgnoreCase("Subjects")){
                imageView.setImageResource(R.drawable.book);
            }else if (titlearray[position].equalsIgnoreCase("Faculty")){
                imageView.setImageResource(R.drawable.contact);
            }else {
                imageView.setImageResource(R.drawable.settings);
            }
            return convertView;
        }
    }
}
