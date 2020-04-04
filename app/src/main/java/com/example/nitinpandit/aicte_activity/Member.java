package com.example.nitinpandit.aicte_activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Room;


public class Member extends AppCompatActivity {

    Students s= new Students();
    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";
    static final int REQUEST_IMAGE_CAPTURE = 1;

    DatabaseHandler db;
    StudentDatabaseHandler studentDb;
    public EditText name;
    TextView date;
    EditText studentName;
    EditText studentUSN;
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


    ImageView memberPhoto;
    Button takePhoto;
    Button reset_button;
    Button submit_button;

    public String student_name;
    public String student_USN;
    public String member_name;
    public String member_date;
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
         studentDb = new StudentDatabaseHandler(getApplicationContext(),null,null,1);
        name = findViewById(R.id.member_name);
        date = findViewById(R.id.member_date);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);

        studentName = findViewById(R.id.student_name);
        studentUSN = findViewById(R.id.student_usn);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        date.setText(Integer.toString(day)+"/"+Integer.toString(month)+"/"+Integer.toString(year));
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
        studentName.setText("");
        studentUSN.setText("");
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



         student_name = studentName.getText().toString();
         student_USN = studentUSN.getText().toString();
         member_name = name.getText().toString();
         member_date=date.getText().toString();
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



        Member_info_entity m = new Member_info_entity(member_name,member_date,member_gender,member_age,
                member_occupation, member_phone,member_aadhar,member_driving,member_birth,member_marriage,
                member_ayushman,member_bank,student_name,student_USN,1);

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

    /*public void takePhotoFunction(View view)
    {
        takePhoto = (Button) findViewById(R.id.member_take_photo);
        memberPhoto = (ImageView) findViewById(R.id.member_photo);
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        takePhoto = (Button) findViewById(R.id.member_take_photo);
        memberPhoto = (ImageView) findViewById(R.id.member_photo);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            memberPhoto.setImageBitmap(imageBitmap);

        }
    }*/
}




