package com.example.nitinpandit.aicte_activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.List;

import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Room;


public class Member extends AppCompatActivity {


    DatabaseHandler db;
    public EditText name;
    public RadioButton male;
    public RadioButton female;
    public RadioButton others;
    public EditText age;
    public EditText phone;
    public EditText occupation;

    CheckBox aadhar;
    CheckBox driving;
    CheckBox birth;
    CheckBox marriage;
    CheckBox ayushman;
    CheckBox bank;

    Button reset_button;
    Button submit_button;

    public String member_name;
    public int member_age;
    public String member_gender;
    public String member_phone ;
    public String member_occupation;
    public String member_aadhar;
    public String member_driving;
    public String member_birth;
    public String member_marriage;
    public String member_ayushman;
    public String member_bank;

    //Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member);
         db = new DatabaseHandler(getApplicationContext(),null,null,1);
        name = findViewById(R.id.member_name);
        male =  findViewById(R.id.gender_male);
        female =  findViewById(R.id.gender_female);
        others =  findViewById(R.id.gender_others);
        age =  findViewById(R.id.member_age);
        phone =  findViewById(R.id.member_phone);
        occupation =  findViewById(R.id.member_occupation);

        aadhar =  findViewById(R.id.member_aadhar);
        driving =  findViewById(R.id.member_driving);
        birth =  findViewById(R.id.member_birth);
        marriage =  findViewById(R.id.member_marriage);
        ayushman =  findViewById(R.id.member_ayushman);
        bank =  findViewById(R.id.member_bank);


    }

    public void reset(View view)
    {
        reset_button = findViewById(R.id.member_reset);
        name.setText("");
        age.setText("");
        male.setChecked(false);
        female.setChecked(false);
        others.setChecked(false);
        phone.setText("");
        occupation.setText("");

        aadhar.setChecked(false);
        driving.setChecked(false);
        birth.setChecked(false);
        marriage.setChecked(false);
        ayushman.setChecked(false);
        bank.setChecked(false);
    }

    public void submit(View view)
    {

        String gender;
        if(male.isChecked())
            gender = "male";
        else if(female.isChecked())
            gender = "female";
        else
            gender = "others";

         member_name = name.getText().toString();
         member_age =  Integer.parseInt(age.getText().toString());
         member_gender = gender;
         member_phone = phone.getText().toString();
         member_occupation = occupation.getText().toString();
         member_aadhar = Boolean.toString(aadhar.isChecked());
         member_driving = Boolean.toString(driving.isChecked());
         member_birth = Boolean.toString(birth.isChecked());
         member_marriage = Boolean.toString(marriage.isChecked());
         member_ayushman = Boolean.toString(ayushman.isChecked());
         member_bank = Boolean.toString(bank.isChecked());

        submit_button = findViewById(R.id.member_submit);



        Member_info_entity m = new Member_info_entity(member_name,member_gender,member_age,
                member_occupation, member_phone,member_aadhar,member_driving,member_birth,member_marriage,
                member_ayushman,member_bank);
        Log.d("Insert: ", "Inserting ..");
        long i = db.addMember(m);
        if(i!=-1)
            Toast.makeText(getApplicationContext(), "Inserted Successfully",
                    Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(), "Insertion Unsuccessful",
                    Toast.LENGTH_SHORT).show();

        //Reading
        /*List<Member_info_entity> members = db.getAllMembers();

        for (Member_info_entity mn : members) {
            String log = "Id: " + mn.getID() + " ,Name: " + mn.getName() + " ,Phone: " +
                    mn.getPhone_number();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }*/
        finish();
    }
}




