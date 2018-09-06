package com.papakci.software.dokunogren.Application;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.*;
import android.widget.ImageView;
import android.widget.TextView;

import com.papakci.software.dokunogren.Database.SQLite_Database;
import com.papakci.software.dokunogren.Pojo.Category;
import com.papakci.software.dokunogren.R;



public class GamePage extends AppCompatActivity  {

    // ---- Tanımlamalar -------- //
    ImageView ivw_img,ivw_clickhand,ivw_back;
    Animation ivw_img_anim,txt_img_anim,ivw_clickhand_anim;
    TextView txt_img;
    MediaPlayer mdp_img;
    SQLite_Database db;
    Category tmpCateg;
    Drawable dr;
    Bitmap bitmap;
    int Category_Secim;
    int resID1, resID2, LevelNo = 1;
    String imgfilename, textfilename, soundfilename;
    Animation anim_text_transition, anim_slide_in_right, clickhand;
    // ---- Tanımlamalar -------- //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_page);
        getSupportActionBar().hide();

        db = new SQLite_Database(this);

        ivw_img = (ImageView) findViewById(R.id.ivw_img);
        txt_img = (TextView) findViewById(R.id.txt_img);
        ivw_clickhand = (ImageView) findViewById(R.id.ivw_clickhand);
        ivw_back = (ImageView) findViewById(R.id.ivw_back);

        ivw_img_anim = AnimationUtils.loadAnimation(this,R.anim.slide_in_right);
        txt_img_anim = AnimationUtils.loadAnimation(this,R.anim.text_transition);

        Bundle extras = getIntent().getExtras();
        Category_Secim = extras.getInt("tikPage");

        ivw_img.setClickable(false);
        if (Category_Secim == 1  ) {
            LevelNo = 1;
        } else if (Category_Secim == 2  ) {
            LevelNo = 7;
        } else if (Category_Secim == 3 )  {
            LevelNo = 15;
        } else if (Category_Secim == 4 )  {
            LevelNo = 23;
        }

        LoadPage();

        ivw_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent backMenu = new Intent(GamePage.this , HomePage.class);
                startActivity(backMenu);


            }
        });

    }
    private void doSleep(int seconds){  // resim aralarindaki beklemeler için özel fonk.
        try{
            Thread.sleep(1000*seconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void LoadPage(){

        ivw_img.setClickable(false); // *

        tmpCateg = db.getCatItem(LevelNo);

        imgfilename = tmpCateg.getPicture_n();
        textfilename = tmpCateg.getText_n();
        soundfilename = tmpCateg.getSound_n();

        resID1 = getResources().getIdentifier(imgfilename, "drawable", getPackageName());
        resID2 = getResources().getIdentifier("raw/" + soundfilename, null, getPackageName());

        dr = getResources().getDrawable(resID1);
        bitmap = ((BitmapDrawable) dr).getBitmap();
        mdp_img = MediaPlayer.create(GamePage.this, resID2);


        ivw_img.startAnimation(ivw_img_anim);
        ivw_img.setImageBitmap(bitmap);



        ivw_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ivw_img.setClickable(false); // **

                ivw_clickhand.clearAnimation();
                ivw_clickhand.setVisibility(View.INVISIBLE);

                txt_img.startAnimation(txt_img_anim);
                txt_img.setText(textfilename);
                mdp_img.start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        doSleep(2);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(Category_Secim == 1 && LevelNo == 6){
                                    LevelNo=1;
                                }
                                else if(Category_Secim == 2 && LevelNo == 14){
                                    LevelNo =7;
                                }
                                else if(Category_Secim == 3 && LevelNo == 22){
                                    LevelNo =15;
                                }
                                else if(Category_Secim == 4 && LevelNo == 32){
                                    LevelNo =23;
                                }
                                else{
                                    LevelNo++;
                                }
                                txt_img.setText("");
                                LoadPage();
                            }
                        });
                    }
                }).start();
            }
        });

    }


}


