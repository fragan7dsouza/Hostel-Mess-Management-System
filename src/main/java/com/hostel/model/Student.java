package com.hostel.model;

// this class is the model (pojo) for a student
public class Student {
    private int rollNo;
    private String name;
    private String email;
    private int age;
    private boolean messStatus; // true if enrolled in mess, false otherwise

    // constructors
    public Student() {}

    public Student(int rollNo, String name, String email, int age, boolean messStatus) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.age = age;
        this.messStatus = messStatus;
    }

    // getters and setters
    public int getRollNo() { 
        return rollNo; 
    }

    public void setRollNo(int rollNo) { 
        this.rollNo = rollNo; 
    }

    public String getName() { 
        return name; 
    }

    public void setName(String name) { 
        this.name = name; 
    }

    public String getEmail() { 
        return email; 
    }

    public void setEmail(String email) { 
        this.email = email; 
    }

    public int getAge() { 
        return age; 
    }

    public void setAge(int age) { 
        this.age = age; 
    }

    public boolean isMessStatus() { 
        return messStatus; 
    }

    public void setMessStatus(boolean messStatus) { 
        this.messStatus = messStatus; 
    }
}