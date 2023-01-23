package com.aditya.shoplens;

public class MenuData {

    String menuItemTitle;
    int menuItemImage;

    public MenuData(){}

    public MenuData(String menuItemTitle, int menuItemImage){
        this.menuItemTitle = menuItemTitle;
        this.menuItemImage = menuItemImage;
    }


    public String getMenuItemTitle() {
        return menuItemTitle;
    }

    public int getMenuItemImage() {
        return menuItemImage;
    }
}
