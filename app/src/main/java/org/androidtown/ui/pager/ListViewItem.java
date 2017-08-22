package org.androidtown.ui.pager;

import android.graphics.drawable.Drawable;

/**
 * Created by Dopy on 2016-11-06.
 */

public class ListViewItem {
    private Drawable icon;
    private String name;
    private String number;

    public void setIcon(Drawable icon1){
        icon=icon1;
    }
    public void setName(String n){
        name=n;
    }
    public void setNumber(String n){
        number=n;
    }

    public Drawable getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
