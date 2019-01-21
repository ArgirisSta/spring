package com.dataverse.project.services;

import com.dataverse.project.domains.User;
import com.dataverse.project.exceptions.EmailAlreadyExistsException;
import com.dataverse.project.forms.RegistrationForm;
import com.dataverse.project.forms.UpdateForm;
import com.dataverse.project.repositories.UserRepository;
import com.dataverse.project.security.SecurityConfig;
import com.dataverse.project.utilities.converters.RegisterFormToUserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RegisterFormToUserConverter registerFormToUserConverter;

    @Override
    public void registerUser(RegistrationForm registrationForm) {
        User user = registerFormToUserConverter.convert(registrationForm);
        String userPassword = user.getPassword();
        user.setPassword(new SecurityConfig().passwordEncoder().encode(userPassword));
        userRepository.save(user);
    }

    @Override
    public void existsUserByEmail(String email) throws EmailAlreadyExistsException {
        if(userRepository.existsUserByEmail(email)) {
            throw new EmailAlreadyExistsException();
        }

    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public void updateUser(UpdateForm updateForm) {
        User user = findUserByEmail(updateForm.getEmail());

        user.setFirstName(updateForm.getFirstName());
        user.setLastName(updateForm.getLastName());

        user.setEmail(updateForm.getEmail());
        user.setPhoneNumber(updateForm.getPhoneNumber());
        user.setCompanyName(updateForm.getCompanyName());

        if(updateForm.getPassword() != null)
        {
            user.setPassword(new SecurityConfig().passwordEncoder().encode(updateForm.getPassword()));
        }

        userRepository.save(user);
    }
}
