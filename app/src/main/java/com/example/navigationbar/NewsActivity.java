package com.example.navigationbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NewsActivity extends AppCompatActivity {
    private DrawerLayout myDrawer;

    TextView title,description;
    ImageView mainImage;

    String news, mean;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);


        myDrawer = (DrawerLayout) findViewById(R.id.myDrawer);
        title = findViewById(R.id.title);
        description = findViewById(R.id.desription);
        mainImage = findViewById(R.id.mainImage);

        getData();
        setData();

    }

    public void ClickMenu(View view) {
        MainActivity.openDrawer(myDrawer);
    }

    public void ClickLogo(View view) {
        MainActivity.closeDrawer(myDrawer);

    }

    public void ClickHome(View view) {
        MainActivity.redirectActivity(this, MainActivity.class);
    }

    public void ClickNews(View view) {
        recreate();
    }

    public void ClickProfile(View view) {
        MainActivity.redirectActivity(this, ProfileActivity.class);
    }

    public void ClickLogout(View view) {
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(myDrawer);
    }

    private void getData(){

        if (getIntent().hasExtra("myImage") && getIntent().hasExtra("news") && getIntent().hasExtra("mean")){
            news = getIntent().getStringExtra("news");
            mean = getIntent().getStringExtra("mean");
            myImage = getIntent().getIntExtra("myImage",1);
        }else{
            Toast.makeText(this,"No data available",Toast.LENGTH_SHORT).show();
        }
    }
    private void setData(){
        title.setText(news);
        description.setText(mean);
        mainImage.setImageResource(myImage);

    }

}
