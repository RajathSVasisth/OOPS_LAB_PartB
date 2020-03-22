package com.example.nitinpandit.aicte_activity;


import java.util.Calendar;

public class Member_info_entity {
    int id=0;

    public int uid;
    public String name;
    public String date;
    public String gender;
    public int age;
    public String phone_number;
    public String occupation;
    public String aadhar;
    public String driving;
    public String birth;
    public String marriage;
    public String ayushman;
    public String bank;

    public Member_info_entity(String name, String date,String gender, int age, String occupation
            , String phone_number,String aadhar,String driving,String birth,String marriage
            , String ayushman,String bank)
    {
        this.name = name;
        this.date=date;
        this.gender = gender;
        this.age = age;
        this.phone_number = phone_number;
        this.occupation = occupation;
        this.aadhar = aadhar;
        this.driving = driving;
        this.birth = birth;
        this.marriage = marriage;
        this.ayushman = ayushman;
        this.bank = bank;
    }

    public Member_info_entity()
    {
        this.name = null;
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);

        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        this.date = Integer.toString(day)+"/"+Integer.toString(month)+"/"+Integer.toString(year);
        this.gender = null;
        this.age = 0;
        this.phone_number = null;
        this.occupation = null;
        this.aadhar = null;
        this.driving = null;
        this.birth = null;
        this.marriage = null;
        this.ayushman = null;
        this.bank = null;
    }

    public int getID()
    {
        return this.uid;
    }

    public String getName()
    {
        return this.name;
    }

    public String getGender()
    {
        return this.gender;
    }

    public String getPhone_number()
    {
        return this.phone_number;
    }

    public String getOccupation()
    {
        return this.occupation;
    }

    public String getAge()
    {
        return Integer.toString(this.age);
    }



}
