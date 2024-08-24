package com.example.BillingSystem.Authentication;


import com.example.BillingSystem.Dto.UserDto;

import java.util.Objects;

public class LoginAutenticator {
    String request_username, fetchedusername;
    String requestpassword, fetchedpassword;

    public LoginAutenticator(UserDto udto, String username, String pwd){
        this.request_username= udto.username();
        this.requestpassword= udto.password();
        this.fetchedusername=username;
        this.fetchedpassword=pwd;
    }

    public String isempty(){
        if(request_username.trim().isEmpty()){
            return "username is empty";
        }   else if(requestpassword.trim().isEmpty()){
            return "password is empty";
        }else if (passwordlength()) {
            return "password must be 8 charachter";
        } else if (verifier()) {
            return "incorrect username || password";
        }

        return "200";//not empty
    }
    public boolean passwordlength(){
        if(requestpassword.length() <=8){
            return true;
        }
        return false;
    }
    public boolean verifier(){
        if(Objects.equals(request_username, fetchedusername) && Objects.equals(requestpassword, fetchedpassword)){
            return false;
        }else{
            return true;
        }
    }
}
