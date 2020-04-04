package com.example.nitinpandit.aicte_activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

public class StudentDatabaseHandler extends SQLiteOpenHelper {

    SQLiteDatabase db;

    public static final String CONTENT_AUTHORITY = "com.example.nitinpandit.aicte_activity";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "students.db";
    public static final String TABLE_STUDENTS = "StudentsList";
    public static final String STUDENT_NAME = "Student";
    public static final String STUDENT_ID = "ID";
    public static final String STUDENT_USN = "USN";
    public static final String MEMBER_ID = "MemberID";
    public static final String STUDENT_COUNT = "Members";
    public static final String DATE = "Date";


    public StudentDatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = this.getWritableDatabase();
        //3rd argument to be passed is CursorFactory instance
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_MEMBER_TABLE = "CREATE TABLE " + TABLE_STUDENTS + "("
                + STUDENT_ID + " INTEGER PRIMARY KEY,"
                + STUDENT_USN + " TEXT," + STUDENT_NAME + " TEXT,"
                + DATE+" TEXT,"
                + MEMBER_ID + " INTEGER,"
                + STUDENT_COUNT+" INTEGER);";
        db.execSQL(CREATE_MEMBER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);

        // Create tables again
        onCreate(db);
    }

    long addStudent(Student_Info_Entity s) {



        ContentValues values = new ContentValues();


        values.put(STUDENT_NAME,s.studentName);
        values.put(STUDENT_USN,s.studentUSN);
        values.put(DATE,s.studentDate);
        values.put(MEMBER_ID,s.MemberID);
        values.put(STUDENT_COUNT,s.StudentCount);



        //SQLiteDatabase db = this.getWritableDatabase();
        // Inserting Row
        try
        {
            long i = db.insert(TABLE_STUDENTS, null, values);
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

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_STUDENTS+" where "+STUDENT_ID +"="+id+"", null );
        return res;
    }

    public boolean updateStudent (Integer id, Student_Info_Entity s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put(MEMBER_ID,id++);
        values.put(STUDENT_NAME,s.studentName);
        values.put(STUDENT_USN,s.studentUSN);
        values.put(DATE,s.studentDate);
        values.put(MEMBER_ID,s.MemberID);
        values.put(STUDENT_COUNT,s.StudentCount);

        long res = db.update(TABLE_STUDENTS, values, STUDENT_ID+" =?", new String[] {Integer.toString(id)});

        if(res!=-1)
            return true;
        else
            return false;
    }

    public Integer deleteMember (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_STUDENTS,
                STUDENT_ID+" = ? ",
                new String[] { Integer.toString(id) });
    }


}
