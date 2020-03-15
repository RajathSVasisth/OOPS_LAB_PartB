package com.example.nitinpandit.aicte_activity;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MemberList extends AppCompatActivity {

    MemberCursorAdapter mCursorAdapter;
    DatabaseHandler mydb;
    ListView memberList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_list);

        mydb = new DatabaseHandler(this,DatabaseHandler.DATABASE_NAME,null,DatabaseHandler.DATABASE_VERSION);
        ArrayList array_list = mydb.getAllMembers();
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, array_list);

        memberList = (ListView) findViewById(R.id.member_list_view);
        memberList.setAdapter(arrayAdapter);
        };

}


