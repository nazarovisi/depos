package com.aris.depo.apis;

import com.aris.depo.daos.DaoUser;
import com.aris.depo.entites.User;
import com.aris.depo.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class ApiUser {

    @Autowired
    private DaoUser daoUser;

    @GetMapping("/users")
    public Response selected(){
        return daoUser.selectUsers();
    }

    @PostMapping("/insert")
    public Response insert(@RequestBody User user){
        return daoUser.insertUser(user);
    }

    @PutMapping("/update")
    public Response update(@RequestBody User user){
        return daoUser.updateUser(user);
    }

    @GetMapping("/selectId")
    public Response selectById(@RequestParam long id){
        return daoUser.selectById(id);
    }

    @DeleteMapping("/delete/{id}")
    public Response delete(@PathVariable long id){
        return daoUser.deleteUser(id);
    }


}
