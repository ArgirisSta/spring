package com.dataverse.project.services;


import com.dataverse.project.domains.User;
import com.dataverse.project.exceptions.EmailAlreadyExistsException;
import com.dataverse.project.forms.RegistrationForm;
import com.dataverse.project.forms.UpdateForm;

public interface UserService {

    void registerUser(RegistrationForm registrationForm);

    void existsUserByEmail(String email) throws EmailAlreadyExistsException;

    User findUserByEmail(String email);

    void updateUser(UpdateForm updateForm);
}
