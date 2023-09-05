package com.Kamil.Bean;

public class Student {
    private String userName;

    public String getUserName() {
        return userName;
    }


    @Override
    public String toString() {
        return "Student{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    private String userPassword;

}
