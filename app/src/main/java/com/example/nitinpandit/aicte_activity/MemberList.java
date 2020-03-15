package com.example.nitinpandit.aicte_activity;

import android.content.Intent;
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
import android.widget.AdapterView;
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
        memberList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
                // TODO Auto-generated method stub
                int id_To_Search = arg2 + 1;

                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", id_To_Search);

                Intent intent = new Intent(MemberList.this,DisplayMember.class);

                intent.putExtras(dataBundle);
                startActivity(intent);
            }
        });
        };

}


