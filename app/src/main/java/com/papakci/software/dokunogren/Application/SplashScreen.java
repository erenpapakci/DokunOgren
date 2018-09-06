package com.papakci.software.dokunogren.Application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.papakci.software.dokunogren.Database.SQLite_Database;
import com.papakci.software.dokunogren.Pojo.Category;
import com.papakci.software.dokunogren.R;

import java.lang.Thread;

public class SplashScreen extends AppCompatActivity {

    SQLite_Database db;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        getSupportActionBar().hide(); // menuaction hidden

        db = new SQLite_Database(this);


        if (db.getCategoryCount() == 0) {
            addData();
        }
        else {
        }
        StartApp();
    }

    private void doSleep(int seconds){  // resim aralarindaki beklemeler için özel fonk.
        try{
            Thread.sleep(1000*seconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void StartApp(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                doSleep(1);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        intent = new Intent(SplashScreen.this, HomePage.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
                    }
                });
            }
        }).start();
    }
    public void addData() {
        /*---------------------------TURKISH EMOTIONS-----------------------------------------*/
        db.addCategory(new Category("happy", "MUTLU", "mutlu"));
        db.addCategory(new Category("angry", "KIZGIN", "kizgin"));
        db.addCategory(new Category("crying", "ÜZGÜN", "uzgun"));
        db.addCategory(new Category("goofy", "ŞIMARIK", "simarik"));
        db.addCategory(new Category("scared", "KORKMUŞ", "korkmus"));
        db.addCategory(new Category("shocked", "ŞAŞIRMIŞ", "sasirmis"));
         /*---------------------------TURKISH ANIMALS----------------------------------------*/
        db.addCategory(new Category("cat", "KEDİ", "kedi"));
        db.addCategory(new Category("dog", "KÖPEK", "kopek"));
        db.addCategory(new Category("chicken", "TAVUK", "tavuk"));
        db.addCategory(new Category("bird", "KUŞ", "kus"));
        db.addCategory(new Category("cow", "İNEK", "inek"));
        db.addCategory(new Category("fish", "BALIK", "balik"));
        db.addCategory(new Category("horse", "AT", "at"));
        db.addCategory(new Category("monkey", "MAYMUN", "maymun"));
        /*---------------------------TURKISH COLORS-----------------------------------------*/
        db.addCategory(new Category("blue", "MAVİ", "mavi"));
        db.addCategory(new Category("red", "KIRMIZI", "kirmizi"));
        db.addCategory(new Category("pink", "PEMBE", "pembe"));
        db.addCategory(new Category("orange", "TURUNCU", "turuncu"));
        db.addCategory(new Category("yellow", "SARI", "sari"));
        db.addCategory(new Category("green", "YEŞİL", "yesil"));
        db.addCategory(new Category("white", "BEYAZ", "beyaz"));
        db.addCategory(new Category("black", "SİYAH", "siyah"));
        /*---------------------------TURKISH NUMBERS----------------------------------------*/
        db.addCategory(new Category("zero", "SIFIR", "sifir"));
        db.addCategory(new Category("one", "BİR", "bir"));
        db.addCategory(new Category("two", "İKİ", "iki"));
        db.addCategory(new Category("three", "ÜÇ", "uc"));
        db.addCategory(new Category("four", "DÖRT", "dort"));
        db.addCategory(new Category("five", "BEŞ", "bes"));
        db.addCategory(new Category("six", "ALTI", "alti"));
        db.addCategory(new Category("seven", "YEDİ", "yedi"));
        db.addCategory(new Category("eight", "SEKİZ", "sekiz"));
        db.addCategory(new Category("nine", "DOKUZ", "dokuz"));
        /*---------------------------TURKISH END----------------------------------------*/

        /*---------------------------ENGLISH EMOTIONS----------------------------------------*/
        db.addCategory(new Category("happy", "HAPPY", "happy"));
        db.addCategory(new Category("angry", "ANGRY", "angry"));
        db.addCategory(new Category("crying", "SAD", "sad"));
        db.addCategory(new Category("goofy", "GOOFY", "goofy"));
        db.addCategory(new Category("scared", "SCARED", "scared"));
        db.addCategory(new Category("shocked", "SHOCKED", "shocked"));
        /*---------------------------ENGLISH ANIMALS----------------------------------------*/
        db.addCategory(new Category("cat", "CAT", "cat"));
        db.addCategory(new Category("dog", "DOG", "dog"));
        db.addCategory(new Category("chicken", "CHICKEN", "chicken"));
        db.addCategory(new Category("bird", "BIRD", "bird"));
        db.addCategory(new Category("cow", "COW", "cow"));
        db.addCategory(new Category("fish", "FISH", "fish"));
        db.addCategory(new Category("horse", "HORSE", "horse"));
        db.addCategory(new Category("monkey", "MONKEY", "monkey"));
        /*---------------------------ENGLISH COLORS----------------------------------------*/
        db.addCategory(new Category("blue", "BLUE", "blue"));
        db.addCategory(new Category("red", "RED", "red"));
        db.addCategory(new Category("pink", "PINK", "pink"));
        db.addCategory(new Category("orange", "ORANGE", "orange"));
        db.addCategory(new Category("yellow", "YELLOW", "yellow"));
        db.addCategory(new Category("green", "GREEN", "green"));
        db.addCategory(new Category("white", "WHITE", "white"));
        db.addCategory(new Category("black", "BLACK", "black"));
        /*---------------------------ENGLISH NUMBERS----------------------------------------*/
        db.addCategory(new Category("zero", "ZERO", "zero"));
        db.addCategory(new Category("one", "ONE", "one"));
        db.addCategory(new Category("two", "TWO", "two"));
        db.addCategory(new Category("three", "THREE", "three"));
        db.addCategory(new Category("four", "FOUR", "four"));
        db.addCategory(new Category("five", "FIVE", "five"));
        db.addCategory(new Category("six", "SIX", "six"));
        db.addCategory(new Category("seven", "SEVEN", "seven"));
        db.addCategory(new Category("eight", "EIGHT", "eight"));
        db.addCategory(new Category("nine", "NINE", "nine"));
         /*---------------------------ENGLISH END----------------------------------------*/



    }



}
