package hu.me.iit.jaladojava.presentation;

import hu.me.iit.jaladojava.service.User;
import hu.me.iit.jaladojava.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

class UserControllerTest {
    @Test
    void testRegister() {
        //GIVEN
        UserService userService = Mockito.mock(UserService.class);

        NameValidator nameValidator = Mockito.mock(NameValidator.class);
        when(nameValidator.isValid(anyString())).thenReturn(true);

        List<NameValidator> nameValidatorList = new ArrayList();
        nameValidatorList.add(nameValidator);

        UserController userController = new UserController(userService, nameValidatorList);

        String username = "igenígyvan";

        //WHEN
        boolean result = userController.register(username);

        //THEN
        assertTrue(result);
        verify(userService, times(1)).save(ArgumentMatchers.any(User.class));
    }

    @Test
    void testRegisterNoValidator() {
        //GIVEN
        UserService userService = Mockito.mock(UserService.class);

        List<NameValidator> nameValidatorList = new ArrayList();

        UserController userController = new UserController(userService, nameValidatorList);

        String username = "igenígyvan";

        //WHEN
        boolean result = userController.register(username);

        //THEN
        assertTrue(result);
        verify(userService, times(1)).save(ArgumentMatchers.any(User.class));
    }

    @Test
    void testRegisterValidatorDeny() {
        //GIVEN
        UserService userService = Mockito.mock(UserService.class);

        NameValidator nameValidator = Mockito.mock(NameValidator.class);
        when(nameValidator.isValid(anyString())).thenReturn(false);

        List<NameValidator> nameValidatorList = new ArrayList();
        nameValidatorList.add(nameValidator);

        UserController userController = new UserController(userService, nameValidatorList);

        String username = "igenígyvan";

        //WHEN
        boolean result = userController.register(username);

        //THEN
        assertFalse(result);
        verify(userService, times(0)).save(ArgumentMatchers.any(User.class));
    }

    @Test
    void testRegisterValidatorMisc() {
        //GIVEN
        UserService userService = Mockito.mock(UserService.class);

        NameValidator nameValidator = Mockito.mock(NameValidator.class);
        when(nameValidator.isValid(anyString())).thenReturn(true);

        NameValidator nameValidatorDeny = Mockito.mock(NameValidator.class);
        when(nameValidatorDeny.isValid(anyString())).thenReturn(false);

        List<NameValidator> nameValidatorList = new ArrayList();
        nameValidatorList.add(nameValidator);
        nameValidatorList.add(nameValidatorDeny);

        UserController userController = new UserController(userService, nameValidatorList);

        String username = "igenígyvan";

        //WHEN
        boolean result = userController.register(username);

        //THEN
        assertFalse(result);
        verify(userService, times(0)).save(ArgumentMatchers.any(User.class));
    }
}