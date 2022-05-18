package com.example.servingwebcontent.service;

import com.example.servingwebcontent.domain.GroupBlood;
import com.example.servingwebcontent.domain.Role;
import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public void saveUser(User user, String username, Map<String, String> form) {
        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepo.save(user);
    }

    public void updateProfile(User user, String password, String lastname, String firstname, String patronymic,
                              String birthday, String policy_number, String phone, String email, GroupBlood group_blood) {
        String userLastname = user.getLastname();
        String userFirstname = user.getFirstname();
        String userPatronymic = user.getPatronymic();
        String userBirthday = user.getBirthday();
        String userPolicy_number = user.getPolicy_number();
        String userPhone = user.getPhone();
        String userEmail = user.getEmail();
        GroupBlood userGroupBlood = user.getGroup_blood();

        boolean isLastnameChanged = (lastname != null && !lastname.equals(userLastname)) ||
                (userLastname != null && !userLastname.equals(lastname));

        boolean isFirstnameChanged = (firstname != null && !firstname.equals(userFirstname)) ||
                (userFirstname != null && !userFirstname.equals(firstname));

        boolean isPatronymicChanged = (patronymic != null && !patronymic.equals(userPatronymic)) ||
                (userPatronymic != null && !userPatronymic.equals(patronymic));

        boolean isBirthdayChanged = (birthday != null && !birthday.equals(userBirthday)) ||
                (userBirthday != null && !userBirthday.equals(birthday));

        boolean isPolicy_numberChanged = (policy_number != null && !policy_number.equals(userPolicy_number)) ||
                (userPolicy_number != null && !userPolicy_number.equals(policy_number));

        boolean isPhoneChanged = (phone != null && !phone.equals(userPhone)) ||
                (userPhone != null && !userPhone.equals(phone));

        boolean isEmailChanged = (email != null && !email.equals(userEmail)) ||
                (userEmail != null && !userEmail.equals(email));

        boolean isGroupBloodChanged = (group_blood != null && !group_blood.equals(userGroupBlood)) ||
                (userGroupBlood != null && !userGroupBlood.equals(group_blood));

        if (isLastnameChanged) {
            user.setLastname(lastname);
        }

        if (isFirstnameChanged) {
            user.setFirstname(firstname);
        }

        if (isPatronymicChanged) {
            user.setPatronymic(patronymic);
        }

        if (isBirthdayChanged) {
            user.setBirthday(birthday);
        }

        if (isPolicy_numberChanged) {
            user.setPolicy_number(policy_number);
        }

        if (isPhoneChanged) {
            user.setPhone(phone);
        }

        if (isEmailChanged) {
            user.setEmail(email);
        }

        if (!StringUtils.isEmpty(password)) {
            user.setPassword(password);
        }

        if (isGroupBloodChanged) {
            user.setGroup_blood(group_blood);
        }

        userRepo.save(user);

    }
}