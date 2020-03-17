package com.example.nitinpandit.aicte_activity;


public class Member_info_entity {
    int id=0;

    public int uid;
    public String name;
    public String gender;
    public int age;
    public String phone_number;
    public String occupation;
    String cards;

    public Member_info_entity(String name, String gender, int age, String occupation
            , String phone_number)
    {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone_number = phone_number;
        this.occupation = occupation;
    }

    public Member_info_entity()
    {
        this.name = null;
        this.gender = null;
        this.age = 0;
        this.phone_number = null;
        this.occupation = null;
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
