/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ams_utilities;

/**
 *
 * @author Nandun
 */
public class Validate {

    public boolean validateName(String x) {

        return x.matches("[A-Z][a-zA-Z\\s]*$");

    }

    public boolean passwordValidation(String password) {

        boolean valid = true;
        if (password.length() > 15 || password.length() < 8) {
            valid = false;
        }

        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars)) {
            valid = false;
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!password.matches(lowerCaseChars)) {
            valid = false;
        }
        String numbers = "(.*[0-9].*)";
        if (!password.matches(numbers)) {
            valid = false;
        }
        String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
        if (!password.matches(specialChars)) {
            valid = false;
        }

        return valid;
    }
}
