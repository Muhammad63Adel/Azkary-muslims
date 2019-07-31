package com.example.muhammad.azkary;

import android.media.Image;

/**
 * Created by muhammad on 8/6/2018.
 */

public class sheikh {

    private  String name;
    private  String nationality;
    private  int pic;

   public sheikh(String iname, String inationality, int imageId){

       name = iname;
       nationality = inationality;
       pic = imageId;
   }

    public String getname(){return name;}

    public String getnationality(){return nationality;}

    public int getpic(){return pic;}
}
