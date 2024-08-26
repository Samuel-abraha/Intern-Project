package com.example.BillingSystem.Authentication;

import com.example.BillingSystem.Dto.CustomerDto;
import com.example.BillingSystem.Dto.UserDto;
import com.example.BillingSystem.Entitys.Customer;

import java.util.Objects;

public class SignupAutenticator {
    Customer fetchedcustomer;
    String alreadyexit;

    String fullname;
    String email;
    String phonenumber;
    String address;
    String username;
    String password;
    public SignupAutenticator(CustomerDto customerdto, Customer fetchedcustomer, String alreadyexit){// , LoginAutenticator loginauth){//, CustomerRepository){
        this.fullname= customerdto.fullname();
        this.email=customerdto.email();
        this.phonenumber= customerdto.phonenumber();

        UserDto udto=customerdto.userDto();
        this.username= udto.username();
        this.password= udto.password();
        this.fetchedcustomer=fetchedcustomer;
        this.alreadyexit=alreadyexit; //the variable that contain the exited typr(phone || email) as string
    }

    public String isempty(){
        String state=alreadyexit();
        if(fullname.trim().isEmpty()){
            return "name is empty";
        }   else if(email.trim().isEmpty()){
            return "email is empty";
        }   else if(phonenumber.trim().isEmpty()){
            return "phone num is empty";
        }   else if (address.trim().isEmpty()) {
            return "address is empty";
        }   else if (username.trim().isEmpty()) {
            return "username is empty";
        }   else if (password.trim().isEmpty()) {
            return "password is empty";
        } else if (plength()) {
            return "password must be 8 charachter";
        }else if (!(Objects.equals(state, "200"))){//state!="200") {
            return state;
        }
        return "200";//not empty
    }

    public boolean plength(){
        if(password.length() <=8){
            return true;
        }
        return false;
    }

    public String alreadyexit(){
        if(alreadyexit=="phonenumber"){
            return "phone number already registerd";
        } else if (alreadyexit == "email") {
            return "email already registerd";
        }

        return "200";
    }

}
