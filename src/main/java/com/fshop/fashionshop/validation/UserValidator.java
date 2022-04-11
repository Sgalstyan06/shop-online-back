package com.fshop.fashionshop.validation;

import com.fshop.fashionshop.model.User;
import com.fshop.fashionshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Component
public final class UserValidator {
    private static UserService userService;

    @Autowired
    private UserService userServiceT;

    @PostConstruct
    public void init() {

        UserValidator.userService = userServiceT;
    }


    public static boolean checkUserAuthorized(String user_id) {
        return !(user_id == null || userService.getById(user_id) == null);
    }

    public static boolean checkUserSignUp(User user) {
        if (user.getEmail() == null || user.getEmail().length() == 0 ||
                user.getName() == null || user.getName().length() == 0 ||
                user.getPicture() == null || user.getPicture().length() == 0 ||
                user.getId() == null || user.getId().length() == 0) {
            return false;
        }
        return true;
    }
}
