package com.example.nitinpandit.aicte_activity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.nitinpandit.aicte_activity.R;

public class MemberCursorAdapter extends CursorAdapter {

    public MemberCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {

        return LayoutInflater.from(context).inflate(R.layout.member_display_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView member_name = (TextView) view.findViewById(R.id.memberDisplayName);
        //TextView member_date = (TextView) view.findViewById(R.id.memberDisplayDate);
        // Extract properties from cursor
        int nameColumnIndex = cursor.getColumnIndex(DatabaseHandler.MEMBER_NAME);
        int dateColumnIndex = cursor.getColumnIndex(DatabaseHandler.MEMBER_DATE);
        String memberName = cursor.getString(nameColumnIndex);
        String memberDate = cursor.getString(dateColumnIndex);

        member_name.setText(memberName);
        //member_date.setText("Date: "+memberDate);





    }
}
