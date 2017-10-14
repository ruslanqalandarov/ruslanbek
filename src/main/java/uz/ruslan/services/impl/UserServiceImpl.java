package uz.ruslan.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.ruslan.db.UserDao;
import uz.ruslan.dto.UserTO;
import uz.ruslan.orm.UserDomain;
import uz.ruslan.services.UserService;

/**
 * Created by User on 11.10.2017.
 */
@Service
public class   UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void saveUser(UserTO userTO) {
        if (userTO != null) {
            UserDomain userDomain = null;

            if (userTO.getId() != null) {
                userDomain = userDao.findOne(userTO.getId());
            }
            if (userDomain == null) {
                userDomain = new UserDomain();
            }
            userDomain.setEmail(userTO.getEmail());
            userDomain.setFirstName(userTO.getFirstName());
            userDomain.setLastName(userTO.getLastName());
            userDomain.setBirthDate(userTO.getBirthDate());
            userDao.save(userDomain);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public UserTO getUser(Long id) {
                UserDomain userDomain = userDao.findOne(id);

        if (userDomain != null) {
            UserTO userTO = new UserTO();
            userTO.setId(userDomain.getId());
            userTO.setFirstName(userDomain.getFirstName());
            userTO.setLastName(userDomain.getLastName());
            userTO.setBirthDate(userDomain.getBirthDate());
            userTO.setEmail(userDomain.getEmail());

            return userTO;
        }
        return null;
    }
}