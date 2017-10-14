package uz.ruslan.services;

import uz.ruslan.dto.UserTO;

/**
 * Created by User on 11.10.2017.
 */
public interface UserService {
    void saveUser(UserTO userTO);

    UserTO getUser(Long id);
}
