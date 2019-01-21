package com.dataverse.project.forms;

import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegistrationForm {

    @NotEmpty(message = " First name cannot be empty!")
    @Size(min = 3, max = 30, message = " Invalid first name! Please input {min} - {max} characters.")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty!")
    @Size(min = 3, max = 30, message = "Invalid last name! Please input {min} - {max} characters.")
    private String lastName;

    @NotEmpty(message = "Email cannot be empty!")
    @Email()
    private String email;

    @Pattern(regexp = "(^$)|(^\\d{10}$)", message = "Invalid phone number. Please input {max} digits")
    private String phoneNumber;

    @Size(max = 30, message = " Invalid company name! Please input up to {max} characters.")
    private String companyName;

    @Pattern(regexp = "^(?=.*[0-9])((?=.*[a-z])|(?=.*[A-Z]))(?=.*[!@#$%^&+=_])(?=\\S+$).{8,50}$"
            , message = "Password should contain at least 1 lower or " +
            "upper case character, 1 number and 1 special character. 8 - 50 characters") // Lower case or Upper case, number and special character.
    private String password;

    @Pattern(regexp = "^(?=.*[0-9])((?=.*[a-z])|(?=.*[A-Z]))(?=.*[!@#$%^&+=])(?=\\S+$).{8,30}$",
    message = "Passwords must match")
    private String confirmPassword;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
