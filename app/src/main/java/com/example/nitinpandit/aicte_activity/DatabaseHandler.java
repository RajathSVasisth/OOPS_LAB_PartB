package com.example.nitinpandit.aicte_activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHandler extends SQLiteOpenHelper {


    SQLiteDatabase db;

    public static final String CONTENT_AUTHORITY = "com.example.nitinpandit.aicte_activity";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "members.db";
    public static final String TABLE_MEMBERS = "MembersList";
    public static final String MEMBER_ID = "id";
    public static final String MEMBER_NAME = "Name";
    public static final String MEMBER_GENDER = "Gender";
    public static final String MEMBER_AGE = "Age";
    public static final String MEMBER_PHONE_NUMBER = "Phone_Number";
    public static final String MEMBER_OCCUPATION = "Occupation";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = this.getWritableDatabase();
        //3rd argument to be passed is CursorFactory instance
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //SQLiteDatabase mydatabase = SQLiteDatabase
        //db.openOrCreateDatabase("members.db",null,null);
        String CREATE_MEMBER_TABLE = "CREATE TABLE " + TABLE_MEMBERS + "("
                + MEMBER_ID + " INTEGER PRIMARY KEY ," + MEMBER_NAME + " TEXT,"
                + MEMBER_GENDER + " TEXT,"+ MEMBER_AGE + " INTEGER,"
                + MEMBER_PHONE_NUMBER + " TEXT," + MEMBER_OCCUPATION + " TEXT);";
        db.execSQL(CREATE_MEMBER_TABLE);

        //System.out.println("Created database");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int old, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEMBERS);

        // Create tables again
        onCreate(db);
    }

    long addMember(Member_info_entity member) {



        ContentValues values = new ContentValues();
        //values.put(MEMBER_ID,id++);

        values.put(MEMBER_OCCUPATION, member.occupation);
        values.put(MEMBER_PHONE_NUMBER, member.phone_number);
        values.put(MEMBER_AGE, member.age);
        values.put(MEMBER_GENDER, member.gender); // Contact Phone
        values.put(MEMBER_NAME, member.name); // Member Name

        //SQLiteDatabase db = this.getWritableDatabase();
        // Inserting Row
        try
        {
            long i = db.insert(TABLE_MEMBERS, null, values);
            db.close();
            return i;
        }
        catch (Exception e)
        {
           Log.d("ERROR:", e.toString());
        }
         // Closing database connection

        //2nd argument is String containing nullColumnHack
        return -1;
    }

    public ArrayList<String> getAllMembers() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select "+MEMBER_NAME+" from "+TABLE_MEMBERS, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(MEMBER_NAME)));
            res.moveToNext();
        }
        return array_list;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_MEMBERS+" where "+MEMBER_ID +"="+id+"", null );
        return res;
    }

    public boolean updateMember (Integer id, Member_info_entity member) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put(MEMBER_ID,id++);

        values.put(MEMBER_OCCUPATION, member.occupation);
        values.put(MEMBER_PHONE_NUMBER, member.phone_number);
        values.put(MEMBER_AGE, member.age);
        values.put(MEMBER_GENDER, member.gender); // Contact Phone
        values.put(MEMBER_NAME, member.name); // Member Name
        long res = db.update(TABLE_MEMBERS, values, MEMBER_ID+" =?", new String[] {Integer.toString(id)});
        if(res!=-1)
        return true;
        else
            return false;
    }

    public Integer deleteMember (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_MEMBERS,
                MEMBER_ID+" = ? ",
                new String[] { Integer.toString(id) });
    }
}
