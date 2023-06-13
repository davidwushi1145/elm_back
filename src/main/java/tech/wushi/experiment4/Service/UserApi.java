package tech.wushi.experiment4.Service;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.wushi.experiment4.Dao.IUserDao;
import tech.wushi.experiment4.Entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author Davidlee
 * @version 1.0
 * Create by 2022/10/21 14:51
 */
@Api(tags = "用户信息管理")
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"*","null"})
public class UserApi {
    @Autowired
    private IUserDao userDao;

    @PostMapping(value = "/login")
    @ApiOperation(value = "用户登录")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "失败")
    })
    public ResponseEntity<User> login(@RequestBody User user) {
        User authenticatedUser = userDao.findUserByNameAndPassword(user.getName(), user.getPassword());

        if (authenticatedUser != null) {
            // 登录成功，返回HTTP状态码200和用户对象
            return ResponseEntity.ok(authenticatedUser);
        } else {
            // 登录失败，返回HTTP状态码400
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping(value = "/register")
    @ApiOperation(value = "用户注册")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "失败")
    })
    public boolean register(@RequestBody User user) {
        try {
            userDao.save(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "用户修改")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "失败")
    })
    public boolean update(@RequestBody User user) {
        try {
            userDao.UpdateUserNameAndPasswordById(user.getName(),user.getPassword(),user.getId());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @DeleteMapping(value = "/delete")
    @ApiOperation(value = "用户删除")
    @ApiImplicitParam(name = "id", value = "用户序号", required = true, dataType = "Long")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "失败")
    })
    public boolean delete(@RequestParam Long id) {
        try {
            userDao.deleteUserById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    @GetMapping(value = "/get")
    @ApiOperation(value = "用户查询")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "失败")
    })
    public List<User> get() {
        return userDao.findAll();
    }
}
