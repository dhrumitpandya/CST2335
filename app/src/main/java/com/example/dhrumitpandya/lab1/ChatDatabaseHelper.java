package com.example.dhrumitpandya.lab1;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by User on 10/18/2016.
 */
public class ChatDatabaseHelper extends SQLiteOpenHelper{

    protected static  final String ACTIVITY_NAME = "ChatDatabaseHelper";
    public static String DATABASE_NAME = "Chats.db";
    public static Integer VERSION_NUM  =2;
    public static String TABLE_NAME = "ChatTable";
    public final static String KEY_ID = "ID";
    public final static String KEY_MESSAGE = "MESSAGE";

    public ChatDatabaseHelper(Context ctx) {
        super(ctx, DATABASE_NAME , null, VERSION_NUM);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_MESSAGE + " TEXT" + ");");

        Log.i("ChatDatabaseHelper", "Calling onCreate");
    }
    public void onUpgrade(SQLiteDatabase db , int oldVersion , int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
        Log.i(ACTIVITY_NAME,"Calling onUpgrade: Older Version: "+oldVersion + " New Version : " + newVersion);


    }


    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

        Log.i("ChatDatabaseHelper", "Calling onDowngrade, oldVersion=" + oldVersion + " newVersion=" + newVersion);
    }

}