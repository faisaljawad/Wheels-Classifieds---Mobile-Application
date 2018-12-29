package com.example.faisaljawad.wheelsclassifieds;

public class user_info_class {
    public user_info_class()  // Default Constructor
    {

    }

    public user_info_class(String user_name, String user_email, String user_password)  // Parameterized Constructor
    {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    String user_name;

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    String user_email;

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    String user_password;
}
