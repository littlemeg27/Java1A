//Created by Brenna Pavlinchak on 2/15/15

package com.example.ravenmargret.java1project3;

public class Dogs
{
    private  String breed; //All the private variables
    private  String type;
    private  String hairType;
    private  String color;
    private  String temperament;
    private  String age;

    public Dogs(String mBreed, String mType, String mHairType, String mColor, String mTemperament, String mAge)
    {
        breed = mBreed;
        type = mType;
        hairType = mHairType;
        color = mColor;
        temperament = mTemperament;
        age = mAge;
    }


    public String getBreed() {return breed;}
    public String getType() {return type;}
    public String getHairType() {return hairType;}
    public String getColor() {return color;}
    public String getTemperament() {return temperament;}
    public String getAge() {return age;}

    @Override
    public String toString()
    {
        return "Breed: " + breed + "\n" + "Type: " + type + "\n" + "Hair Type: " + hairType +
               "\n" + "Color: " + color + "\n" + "Temperament: " + temperament + "\n" + "Age: " + age;
    }
}
