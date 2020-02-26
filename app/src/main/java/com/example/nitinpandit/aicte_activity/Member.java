package com.example.nitinpandit.aicte_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.room.Entity;
import androidx.room.Room;


public class Member extends AppCompatActivity {


    EditText name;
    RadioButton male;
    RadioButton female;
    RadioButton others;
    EditText age;
    EditText phone;
    EditText occupation;

    CheckBox aadhar;
    CheckBox driving;
    CheckBox birth;
    CheckBox marriage;
    CheckBox ayushman;
    CheckBox bank;

    Button reset_button;
    //Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member);

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



    }




