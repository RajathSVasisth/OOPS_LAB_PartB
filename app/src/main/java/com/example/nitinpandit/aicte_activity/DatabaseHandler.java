package com.example.nitinpandit.aicte_activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHandler extends SQLiteOpenHelper{

    public int id=1;
    SQLiteDatabase db;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "members.db";
    private static final String TABLE_MEMBERS = "MembersList";
    private static final String MEMBER_ID = "id";
    private static final String MEMBER_NAME = "Name";
    private static final String MEMBER_GENDER = "Gender";
    private static final String MEMBER_AGE = "Age";
    private static final String MEMBER_PHONE_NUMBER = "Phone_Number";
    private static final String MEMBER_OCCUPATION = "Occupation";

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

    public List<Member_info_entity> getAllMembers() {
        List<Member_info_entity> memberList = new ArrayList<Member_info_entity>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MEMBERS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Member_info_entity member_info_entity = new Member_info_entity();
                member_info_entity.name = cursor.getString(0);
                member_info_entity.gender = (cursor.getString(1));
                member_info_entity.age = Integer.parseInt(cursor.getString(2));
                // Adding contact to list
                memberList.add(member_info_entity);
            } while (cursor.moveToNext());
        }

        // return contact list
        return memberList;
    }
}
