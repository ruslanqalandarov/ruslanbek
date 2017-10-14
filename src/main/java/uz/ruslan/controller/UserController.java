package uz.ruslan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.ruslan.dto.UserTO;
import uz.ruslan.services.UserService;

/**
 * Created by User on 11.10.2017.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //GET, POST, PUT, DELETE, PATCH
    @RequestMapping(
            value = "/user-item",
            method = RequestMethod.GET
    )
    public UserTO getUserById2(@RequestParam Long id) {
            return userService.getUser(id);
    }
}
