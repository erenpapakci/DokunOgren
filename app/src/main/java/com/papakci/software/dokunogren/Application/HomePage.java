package com.papakci.software.dokunogren.Application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.papakci.software.dokunogren.R;

public class HomePage extends AppCompatActivity implements View.OnClickListener {
    Button btn_emotions,btn_animals,btn_colors,btn_numbers;
    ImageView ivw_clickhand;
    Intent intent ;
    Animation click_hand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.home_page);
       intent = new Intent(HomePage.this, GamePage.class);

       btn_emotions = (Button) findViewById(R.id.btn_emotions);
       btn_animals = (Button) findViewById(R.id.btn_animals);
       btn_colors = (Button) findViewById(R.id.btn_colors);
       btn_numbers = (Button) findViewById(R.id.btn_numbers);
       ivw_clickhand = (ImageView) findViewById(R.id.ivw_clickhand);


       btn_emotions.setOnClickListener(this);
       btn_animals.setOnClickListener(this);
       btn_colors.setOnClickListener(this);
       btn_numbers.setOnClickListener(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.menu_exit:
                onBackPressed();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {


     if(view.getId() == btn_emotions.getId()){
        intent.putExtra("tikPage", 1);
        }
     else if (view.getId() == btn_animals.getId()){
         intent.putExtra("tikPage", 2);
     }
     else if (view.getId() == btn_colors.getId()){
         intent.putExtra("tikPage", 3);
     }
     else if (view.getId() == btn_numbers.getId()){
         intent.putExtra("tikPage", 4);
     }
        startActivity(intent);


    }
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}
