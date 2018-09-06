package com.papakci.software.dokunogren.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.papakci.software.dokunogren.Application.SplashScreen;
import com.papakci.software.dokunogren.Pojo.Category;
import com.papakci.software.dokunogren.Application.GamePage;

/**
 * Created by EREN on 23/12/2017.
 */

public class SQLite_Database extends SQLiteOpenHelper{

    public static final String DB_NAME    = "ozelegitim.db";
    public static final String DB_TABLE_NAME = "category_table";
    public static final String COLUMN_1 = "id";
    public static final String COLUMN_2 = "picture_n";
    public static final String COLUMN_3 = "text_n";
    public static final String COLUMN_4 = "sound_n";

    public static final int    DB_VERSION = 1;


    public SQLite_Database(GamePage c) {

        super(c, DB_NAME,null, DB_VERSION);

    }

    public SQLite_Database(SplashScreen s) {
        super(s, DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + DB_TABLE_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT,picture_n TEXT , text_n TEXT, sound_n TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE_NAME);
        onCreate(db);
    }
    // Adding new Category
    public boolean addCategory(Category category){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_2,category.getPicture_n());
        cv.put(COLUMN_3,category.getText_n());
        cv.put(COLUMN_4,category.getSound_n());

        // Inserting Row
        long result = db.insert(DB_TABLE_NAME,null,cv);
        if(result == -1){

            return false;

        }
        else
            return true;

    }

    public Category getCatItem(int levelNo){

        SQLiteDatabase db = this.getReadableDatabase();
        String userLevelNo = Integer.toString(levelNo);

        Cursor cursor = db.query(DB_TABLE_NAME, new String[]{COLUMN_2,COLUMN_3,COLUMN_4,COLUMN_1},COLUMN_1 + "=?",new String[]{userLevelNo},null,null,null,null);
        if (cursor !=null){

            cursor.moveToFirst();
        }
        Category tempCategory = new Category(cursor.getString(0),cursor.getString(1),cursor.getString(2));
        db.close();
        cursor.close();
        return tempCategory;

    }

    public Cursor getAllCategory(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res  = db.rawQuery("select * from "+DB_TABLE_NAME,null);
        return res;
    }
    // Getting Category Count
    public long getCategoryCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        int cnt  = (int) DatabaseUtils.queryNumEntries(db, DB_TABLE_NAME);
        db.close();
        return cnt;
    }

}
   /* public boolean insertData(String PICTURE_N,String TEXT_N,String SOUND_N){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_2,PICTURE_N);
        contentValues.put(COLUMN_3,TEXT_N);
        contentValues.put(COLUMN_4,SOUND_N);

        long result = db.insert(DB_TABLE_NAME,null,contentValues);
        if(result == -1){

            return false;

        }
        else
            return true;
    }
   */