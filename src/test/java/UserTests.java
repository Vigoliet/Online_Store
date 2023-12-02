import org.example.User;
import org.example.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class UserTests {

    User user;
    UserService userService;

    @BeforeEach
    public void init(){
        user = new User("Vigoliet", "123");
        userService = new UserService();
    }

    @Test
    public void testRegisterUser(){
        userService.registerUser(user);

        var expected = 1;
        var actual = userService.getUsers().size();

        assertEquals(expected, actual);
    }

    @Test
    public void testLoginUser(){
        userService.registerUser(user);
        userService.login(user);

        var expected = "Vigoliet";
        var actual = userService.CurrentUser();

        assertEquals(expected, actual);
    }

    @Test
    public void testLogoutUser(){
        userService.registerUser(user);
        userService.login(user);
        userService.logout();

        var actual = userService.CurrentUser();

        assertNull(actual);
    }
}
