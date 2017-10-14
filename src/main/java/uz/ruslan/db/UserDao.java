package uz.ruslan.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.ruslan.orm.UserDomain;

/**
 * Created by User on 11.10.2017.
 */
@Repository
public interface UserDao extends CrudRepository<UserDomain, Long> {

    //dao - Data Access Object
}
