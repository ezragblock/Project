package com.example.shalom.myapplication.SharedPreference;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.shalom.myapplication.model.entities.User;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by yedid on 12/22/2016.
 */

public class MyPreference
{
    public static final String MY_PREFS_NAME = "YedidyaFiles";//because i'm awesome
    static int counter = 0;//this count how much user i saved
    static Context temp;
    static SharedPreferences pref = temp.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
    static SharedPreferences.Editor editor = pref.edit();


    public static void addUser(User u)
    {
        editor.putString("username" + counter,u.getUsername());
        editor.putString("password" + counter,u.getPassword());
        editor.commit();
        counter++;
    }

    public static int isUserOnPhone(User u)//will return the index of the user (if such user doesn't exist return 0)
    {
        for(int i = 0; i < counter;i++)//going over all the users and checking for a match
        {
            if(pref.getString("username" + i,"no such name") == u.getUsername()&&pref.getString("password" + i,"password not match") == u.getPassword())
                return i;
        }
        return 0;
    }

    public static void deleteUser(User u)
    {
        int i = isUserOnPhone(u);
        if(i != 0)
        {
            editor.remove("username" + i);
            editor.remove("password" + i);
            editor.commit();
        }
    }

}