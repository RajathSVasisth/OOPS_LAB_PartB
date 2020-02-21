package com.example.nitinpandit.aicte_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class Member extends AppCompatActivity {



    //Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member);

        final EditText name = findViewById(R.id.member_name);
        final RadioButton male =  findViewById(R.id.gender_male);
        final RadioButton female =  findViewById(R.id.gender_female);
        final RadioButton others =  findViewById(R.id.gender_others);
        final EditText age =  findViewById(R.id.member_age);
        final EditText phone =  findViewById(R.id.member_phone);
        final EditText occupation =  findViewById(R.id.member_occupation);

        final CheckBox aadhar =  findViewById(R.id.member_aadhar);
        final CheckBox driving =  findViewById(R.id.member_driving);
        final CheckBox birth =  findViewById(R.id.member_birth);
        final CheckBox marriage =  findViewById(R.id.member_marriage);
        final CheckBox ayushman =  findViewById(R.id.member_ayushman);
        final CheckBox bank =  findViewById(R.id.member_bank);

        Button reset = findViewById(R.id.member_reset);

        //Reset button's function
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        });
    }

    /*public void reset(View view)
    {
            button = (Button) findViewById(R.id.member_reset);

                member_name.setText("");
                member_age.setText("");
                male.setChecked(false);
                female.setChecked(false);
                others.setChecked(false);
                member_phone.setText("");
                member_occupation.setText("");

                aadhar.setChecked(false);
                driving.setChecked(false);
                birth.setChecked(false);
                marriage.setChecked(false);
                ayushman.setChecked(false);
                bank.setChecked(false);
            }*/

    }




