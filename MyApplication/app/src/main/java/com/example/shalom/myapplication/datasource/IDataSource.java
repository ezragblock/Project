package com.example.shalom.myapplication.datasource;

import com.example.shalom.myapplication.entities.Activity;
import com.example.shalom.myapplication.entities.Business;
import com.example.shalom.myapplication.entities.User;

/**
 * Created by Shalom on 11/29/2016.
 */

public interface IDataSource
{
    void addUser(User user);
    void addActivity(Activity activity);
    void addBusiness(Business user);
}