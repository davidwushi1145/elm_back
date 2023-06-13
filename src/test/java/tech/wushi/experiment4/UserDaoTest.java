package tech.wushi.experiment4;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.wushi.experiment4.Dao.IUserDao;
import tech.wushi.experiment4.Entity.User;

/**
 * @author Davidlee
 * @version 1.0
 * Create by 2022/10/20 17:18
 */
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private IUserDao uDao;
    @Test
    public void insertUser(){
        User u = new User();
        u.setName("roo2t");
        u.setPassword("123456");
        uDao.save(u);
    }
    @Test
    public void findUserById(){
        User u= uDao.findUserById(3L);
        System.out.println(u.getName());
    }
    @Test
    public void updateUserNameById(){
        int i = uDao.UpdateUserNameAndPasswordById("www","123456",1L);
        System.out.println(i);
    }
    @Test
    public void deleteUserById(){
        int i = uDao.deleteUserById(4L);
        System.out.println(i);
    }
    @Test
    public void findUserByNameAndPassword(){
        User u = uDao.findUserByNameAndPassword("admin","123456789");
        System.out.println(u.getName());
    }
}
