package com.hostel.model;

public class Menu {
    private int menuId;
    private String dayOfWeek;
    private String mealType;
    private String itemName;

    // constructors
    public Menu() {}

    public Menu(int menuId, String dayOfWeek, String mealType, String itemName) {
        this.menuId = menuId;
        this.dayOfWeek = dayOfWeek;
        this.mealType = mealType;
        this.itemName = itemName;
    }

    public Menu(String dayOfWeek, String mealType, String itemName) {
        this.dayOfWeek = dayOfWeek;
        this.mealType = mealType;
        this.itemName = itemName;
    }

    // getters and setters
    public int getMenuId() { 
        return menuId; 
    }

    public void setMenuId(int menuId) { 
        this.menuId = menuId; 
    }

    public String getDayOfWeek() { 
        return dayOfWeek; 
    }

    public void setDayOfWeek(String dayOfWeek) { 
        this.dayOfWeek = dayOfWeek; 
    }

    public String getMealType() { 
        return mealType; 
    }

    public void setMealType(String mealType) { 
        this.mealType = mealType; 
    }

    public String getItemName() { 
        return itemName; 
    }

    public void setItemName(String itemName) { 
        this.itemName = itemName; 
    }
}