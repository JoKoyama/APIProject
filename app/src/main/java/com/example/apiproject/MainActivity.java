package com.example.apiproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
        {

    private ApiAdapter apiAdapter;
    private List<Organizer> list;
    public static final String EXTRA_ANIME = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiGetter.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiGetter apiGetter = retrofit.create(ApiGetter.class);

        Call<WrapperOrganizer> callWrapperOrganizer = apiGetter.getSeason("winter",2020);
        callWrapperOrganizer.enqueue(new Callback<WrapperOrganizer>() {
            @Override
            public void onResponse(Call<WrapperOrganizer> call, Response<WrapperOrganizer> response) {
                List<Organizer> test = response.body().getAnime();
                if(test != null) {
                    Toast.makeText(MainActivity.this, list.toString(),
                            Toast.LENGTH_SHORT).show();
                    list = test;
                } else
                {
                    Toast.makeText(MainActivity.this, "I'm null help", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<WrapperOrganizer> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        ListView listView = findViewById(R.id.ListView_main_list);
        apiAdapter = new ApiAdapter(list);
        listView.setAdapter(apiAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent targetIntent = new Intent(MainActivity.this,ApiDetail.class);
                targetIntent.putExtra(EXTRA_ANIME,list.get(i));
                startActivity(targetIntent);
                fileList();
            }
        });

        Log.d("LOOK AT ME", "onCreate: ");
        Toast.makeText(MainActivity.this,"help me",Toast.LENGTH_SHORT).show();




    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
   private class ApiAdapter extends ArrayAdapter<Organizer> {
        private List<Organizer> listList;
        public ApiAdapter(List<Organizer> list){
            super(MainActivity.this,-1,list );
            listList = list;
        }

       @Override
       public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = getLayoutInflater();

           if(convertView == null){
               convertView = inflater.inflate(R.layout.listview,parent,false);
           }
           TextView textViewTitle = findViewById(R.id.textView_listview_title);
           TextView textViewEpnum = findViewById(R.id.textView_listview_epnum);
           TextView textViewGenre = findViewById(R.id.textView_listview_genre);
           ImageView imageViewTitle = findViewById(R.id.imageView_listview_titlecard);
           Picasso.get().load(listList.get(position).getImage_url()).into(imageViewTitle);
           textViewEpnum.setText(listList.get(position).getEpisodes());
           textViewTitle.setText(listList.get(position).getTitle());
           textViewGenre.setText(listList.get(position).getGenre());
           return convertView;
        }
   }


}
