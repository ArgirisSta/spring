package com.dataverse.project.utilities.converters;

import com.dataverse.project.domains.User;
import com.dataverse.project.forms.RegistrationForm;
import org.springframework.stereotype.Component;

@Component
public class RegisterFormToUserConverter {

    public User convert(RegistrationForm registrationForm) {
        User user = User.builder().setFirstName(registrationForm.getFirstName()).setLastName(registrationForm.getLastName())
                .setEmail(registrationForm.getEmail()).setPhoneNumber(registrationForm.getPhoneNumber())
                .setCompanyName(registrationForm.getCompanyName()).setPassword(registrationForm.getPassword()).build();

        return user;
    }
}
