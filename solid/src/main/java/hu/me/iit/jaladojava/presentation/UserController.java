package hu.me.iit.jaladojava.presentation;

import hu.me.iit.jaladojava.service.User;
import hu.me.iit.jaladojava.service.UserService;

import java.util.List;

public class UserController {
    private final UserService userService;
    private final List<NameValidator> nameValidatorList;
    public static final int MIN_NAME_LENGTH = 6;

    public UserController(UserService userService, List<NameValidator> nameValidatorList) {
        this.userService = userService;
        this.nameValidatorList = nameValidatorList;
    }

    public boolean register(String name) {
        if(isValidUsername(name)) {
            userService.save(new User());
            return true;
        } else {
            return false;
        }
    }

    private boolean isValidUsername(String name) {
        for (NameValidator nameValidator: nameValidatorList) {
            if(!nameValidator.isValid(name)) {
                return false;
            };
        }

        return true;
    }
}
