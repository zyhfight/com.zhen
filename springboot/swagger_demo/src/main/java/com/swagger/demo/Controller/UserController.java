package com.swagger.demo.Controller;

import com.swagger.demo.domain.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 该类的功能描述
 * @author: zyh
 * @date: 2018-9-21
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private ConcurrentHashMap<Long,User> users = new ConcurrentHashMap<>();

    @ApiOperation(value = "获取user列表", notes = "")
    @GetMapping("")
    public List<User> getUserList() {
        List<User> userList = new ArrayList<>(users.values());
        return userList;
    }

    @ApiOperation(value = "创建user", notes = "根据User对象创建user")
    @ApiImplicitParam(name = "user", value = "user详细实体user", required = true, dataType = "User")
    @PostMapping("")
    public String postUser(@RequestBody User user){
        users.put(user.getId(), user);
        return "success";
    }

    @ApiOperation(value = "获取user详细信息", notes = "根据user的id来获取详细信息")
    @ApiImplicitParam(name = "id", value = "user ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return users.get(id);
    }

    @ApiOperation(value = "更新user详细信息", notes = "根据user的id指定要更新的对象，并根据传过来的user信息2更新user详细信息")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "id", value = "user ID", required = true, dataType = "Long", paramType = "path"),
                    @ApiImplicitParam(name = "user", value = "user详细实体user", required = true, dataType = "User")
            }
    )
    @PutMapping("/{id}")
    public String putUser(@PathVariable Long id, @RequestBody User user){
        User user1 = users.get(id);
        user1.setName(user.getName());
        user1.setAge(user.getAge());
        users.put(id, user1);
        return "success";
    }

    @ApiOperation(value = "删除user", notes = "根据user的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "user ID", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable Long id){
        users.remove(id);
        return "success";
    }




}
