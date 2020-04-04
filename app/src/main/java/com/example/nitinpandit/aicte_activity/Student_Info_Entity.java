package com.example.nitinpandit.aicte_activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Student_Info_Entity {
    String studentName;
    String studentUSN;
    String studentDate;
    int MemberID;
    int StudentCount;

    public Student_Info_Entity(String studentName,String studentUSN,String studentDate,
                               int MemberID,int StudentCount)
    {
        this.studentName = studentName;
        this.studentUSN = studentUSN;
        this.studentDate = studentDate;
        this.MemberID = MemberID;
        this.StudentCount = StudentCount;
    }

    public Student_Info_Entity()
    {
        this.studentName = null;
        this.studentUSN = null;
        this.studentDate = null;
        this.MemberID = 0;
        this.StudentCount = 0;
    }


}
