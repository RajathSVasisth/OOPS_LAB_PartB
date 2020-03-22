package com.example.nitinpandit.aicte_activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayMember extends AppCompatActivity {
    private DatabaseHandler mydb;

    int Value;
    EditText display_name;
    EditText display_gender;
    EditText display_age;
    EditText display_phone;
    EditText display_occupation;
    TextView display_date;

    CheckBox display_aadhar;
    CheckBox display_driving;
    CheckBox display_birth;
    CheckBox display_marriage;
    CheckBox display_ayushman;
    CheckBox display_bank;

    Button EditButton;
    Button DeleteButton;
    Button DoneButton;

    int id_To_Update = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_display_item);
        EditButton = (Button) findViewById(R.id.member_edit);
        DeleteButton = (Button) findViewById(R.id.member_delete);
        DoneButton = (Button) findViewById(R.id.editDone);

        DoneButton.setVisibility(View.GONE);

        //DoneButton.setVisibility(View.GONE);
        setContentView(R.layout.member_display_item);
        display_name = (EditText) findViewById(R.id.display_member_name);
        display_date = (TextView) findViewById(R.id.display_member_date);
        display_gender = (EditText) findViewById(R.id.display_member_gender_text);
        display_age = (EditText) findViewById(R.id.display_member_age);
        display_phone = (EditText) findViewById(R.id.display_member_phone);
        display_occupation = (EditText) findViewById(R.id.display_member_occupation);
        display_aadhar = (CheckBox) findViewById(R.id.display_member_aadhar);
        display_driving = (CheckBox) findViewById(R.id.display_member_driving);
        display_birth = (CheckBox) findViewById(R.id.display_member_birth);
        display_marriage = (CheckBox) findViewById(R.id.display_member_marriage);
        display_ayushman = (CheckBox) findViewById(R.id.display_member_ayushman);
        display_bank = (CheckBox) findViewById(R.id.display_member_bank);
        mydb = new DatabaseHandler(this, DatabaseHandler.DATABASE_NAME, null, DatabaseHandler.DATABASE_VERSION);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            Value = extras.getInt("id");


            if (Value > 0) {
                //means this is the view part not the add contact part.
                try {
                    Cursor rs = mydb.getData((Value));
                    id_To_Update = Value;
                    rs.moveToFirst();

                    String name = rs.getString(rs.getColumnIndex(DatabaseHandler.MEMBER_NAME));

                    String phone = rs.getString(rs.getColumnIndex(DatabaseHandler.MEMBER_PHONE_NUMBER));
                    String gender = rs.getString(rs.getColumnIndex(DatabaseHandler.MEMBER_GENDER));
                    String age = rs.getString(rs.getColumnIndex(DatabaseHandler.MEMBER_AGE));
                    String occupation = rs.getString(rs.getColumnIndex(DatabaseHandler.MEMBER_OCCUPATION));
                    String aadhar = rs.getString(rs.getColumnIndex(DatabaseHandler.MEMBER_AADHAR));
                    String driving = rs.getString(rs.getColumnIndex(DatabaseHandler.MEMBER_DRIVING));
                    String birth = rs.getString(rs.getColumnIndex(DatabaseHandler.MEMBER_BIRTH));
                    String marriage = rs.getString(rs.getColumnIndex(DatabaseHandler.MEMBER_MARRIAGE));
                    String ayushman = rs.getString(rs.getColumnIndex(DatabaseHandler.MEMBER_AYUSHMAN));
                    String bank = rs.getString(rs.getColumnIndex(DatabaseHandler.MEMBER_BANK));
                    String date = rs.getString(rs.getColumnIndex(DatabaseHandler.MEMBER_DATE));
                    Log.d("Date",date);

                    if (!rs.isClosed()) {
                        rs.close();
                    }

                    display_name.setText((CharSequence) name);
                    display_name.setFocusable(false);
                    display_name.setClickable(false);
                    display_name.setEnabled(false);

                    display_date.setText((CharSequence) date);
                    display_date.setFocusable(false);
                    display_date.setClickable(false);
                    display_date.setEnabled(false);

                    display_phone.setText((CharSequence) phone);
                    display_phone.setFocusable(false);
                    display_phone.setClickable(false);
                    display_phone.setEnabled(false);

                    display_gender.setText((CharSequence) gender);
                    display_gender.setFocusable(false);
                    display_gender.setClickable(false);
                    display_gender.setEnabled(false);

                    display_age.setText((CharSequence) age);
                    display_age.setFocusable(false);
                    display_age.setClickable(false);
                    display_age.setEnabled(false);

                    display_occupation.setText((CharSequence) occupation);
                    display_occupation.setFocusable(false);
                    display_occupation.setClickable(false);
                    display_occupation.setEnabled(false);

                    display_aadhar.setChecked(Boolean.valueOf(aadhar));
                    display_aadhar.setFocusable(false);
                    display_aadhar.setClickable(false);
                    display_aadhar.setEnabled(false);

                    display_driving.setChecked(Boolean.valueOf(driving));
                    display_driving.setFocusable(false);
                    display_driving.setClickable(false);
                    display_driving.setEnabled(false);

                    display_birth.setChecked(Boolean.valueOf(birth));
                    display_birth.setFocusable(false);
                    display_birth.setClickable(false);
                    display_birth.setEnabled(false);

                    display_marriage.setChecked(Boolean.valueOf(marriage));
                    display_marriage.setFocusable(false);
                    display_marriage.setClickable(false);
                    display_marriage.setEnabled(false);

                    display_ayushman.setChecked(Boolean.valueOf(ayushman));
                    display_ayushman.setFocusable(false);
                    display_ayushman.setClickable(false);
                    display_ayushman.setEnabled(false);

                    display_bank.setChecked(Boolean.valueOf(bank));
                    display_bank.setFocusable(false);
                    display_bank.setClickable(false);
                    display_bank.setEnabled(false);

                } catch (Exception e) {
                    Log.d("error", e.toString());
                }


            }
        }
    }

    public void edit(View view) {
        Bundle extras = getIntent().getExtras();

        EditButton = (Button) findViewById(R.id.member_edit);
        DeleteButton = (Button) findViewById(R.id.member_delete);
        DoneButton = (Button) findViewById(R.id.editDone);

        EditButton.setVisibility(View.GONE);
        DeleteButton.setVisibility(View.GONE);

        DoneButton.setVisibility(View.VISIBLE);

        if (extras != null) {
            Value = extras.getInt("id");
        Log.d("ID",Integer.toString(Value));
            if (Value > 0) {
                try {
                    int v = Value;

                    display_name.setFocusable(true);
                    display_name.setClickable(true);
                    display_name.setFocusableInTouchMode(true);
                    display_name.setEnabled(true);

                    display_gender.setFocusable(true);
                    display_gender.setClickable(true);
                    display_gender.setFocusableInTouchMode(true);
                    display_gender.setEnabled(true);

                    display_age.setFocusable(true);
                    display_age.setFocusableInTouchMode(true);
                    display_age.setClickable(true);
                    display_age.setEnabled(true);

                    display_occupation.setFocusable(true);
                    display_occupation.setFocusableInTouchMode(true);
                    display_occupation.setClickable(true);
                    display_occupation.setEnabled(true);

                    display_phone.setFocusable(true);
                    display_phone.setFocusableInTouchMode(true);
                    display_phone.setClickable(true);
                    display_phone.setEnabled(true);

                    display_aadhar.setFocusable(true);
                    display_aadhar.setFocusableInTouchMode(true);
                    display_aadhar.setClickable(true);
                    display_aadhar.setEnabled(true);

                    display_driving.setFocusable(true);
                    display_driving.setFocusableInTouchMode(true);
                    display_driving.setClickable(true);
                    display_driving.setEnabled(true);

                    display_birth.setFocusable(true);
                    display_birth.setFocusableInTouchMode(true);
                    display_birth.setClickable(true);
                    display_birth.setEnabled(true);

                    display_aadhar.setFocusable(true);
                    display_aadhar.setFocusableInTouchMode(true);
                    display_aadhar.setClickable(true);
                    display_aadhar.setEnabled(true);

                    display_marriage.setFocusable(true);
                    display_marriage.setFocusableInTouchMode(true);
                    display_marriage.setClickable(true);
                    display_marriage.setEnabled(true);

                    display_ayushman.setFocusable(true);
                    display_ayushman.setFocusableInTouchMode(true);
                    display_ayushman.setClickable(true);
                    display_ayushman.setEnabled(true);

                    display_bank.setFocusable(true);
                    display_bank.setFocusableInTouchMode(true);
                    display_bank.setClickable(true);
                    display_bank.setEnabled(true);




                    DoneButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Member_info_entity member;
                            member = new Member_info_entity(display_name.getText().toString(),
                                    display_date.getText().toString(),
                                    display_gender.getText().toString()
                                    , Integer.parseInt(display_age.getText().toString())
                                    , display_occupation.getText().toString()
                                    , display_phone.getText().toString(),Boolean.toString(display_aadhar.isChecked())
                                    , Boolean.toString(display_driving.isChecked()), Boolean.toString(display_birth.isChecked())
                                    , Boolean.toString(display_marriage.isChecked()), Boolean.toString(display_ayushman.isChecked())
                                    ,Boolean.toString(display_bank.isChecked()));
                            if(mydb.updateMember(Value, member)) {
                                Toast.makeText(getApplicationContext(), "Updated Successfully",
                                        Toast.LENGTH_SHORT).show();
                                Log.d("SUccessful update", "true");
                                Intent intent = new Intent(DisplayMember.this,Home.class);
                                startActivity(intent);
                                finish();
                            }
                            else {

                                Log.d("Unsuccessful update", "false");
                            }

                        }

                    });


                } catch (Exception e) {
                    Log.d("error", e.toString());
                }


            }
        }

    }

    public void delete(View view)
    {
        Bundle extras = getIntent().getExtras();

        EditButton = (Button) findViewById(R.id.member_edit);
        DeleteButton = (Button) findViewById(R.id.member_delete);
        DoneButton = (Button) findViewById(R.id.editDone);

        if (extras != null) {
            Value = extras.getInt("id");

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
        .setMessage(R.string.deleteMember)
        .setTitle(R.string.member_delete)
         .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialogInterface, int id) {
                        int r= mydb.deleteMember(Value);
                        Log.d("ALERT",Integer.toString(r));
                        Toast.makeText(getApplicationContext(), "Deleted Successfully",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DisplayMember.this,Home.class);
                        startActivity(intent);
                        finish();

                    }
                })
         .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog

                    }
                });

            AlertDialog d = builder.create();

            d.show();


        }
    }
}