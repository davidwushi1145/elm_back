package tech.wushi.experiment4.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tech.wushi.experiment4.Entity.User;

import javax.transaction.Transactional;

public interface IUserDao extends JpaRepository<User,Long> {
//    User findUserByIdAndPassword(Long id,String password);
    User findUserById(Long id);
    User findUserByNameAndPassword(String name,String password);
    @Transactional
    @Modifying
    int deleteUserById(Long id);
    @Transactional
    @Modifying
    @Query("update User s set s.name=?1,s.password=?2 where s.id=?3")
    int UpdateUserNameAndPasswordById(String name,String password,Long id);
}
