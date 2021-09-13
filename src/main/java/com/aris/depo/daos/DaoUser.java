package com.aris.depo.daos;

import com.aris.depo.entites.User;
import com.aris.depo.exceptions.NotFoundException;
import com.aris.depo.model.Response;
import com.aris.depo.repository.RepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class DaoUser {

    @Autowired
    private RepoUser repoUser;

    public Response selectUsers(){
        List<User> users = repoUser.findAll();
        if(users !=null && !users.isEmpty()){
            return new Response().setResponse(users);
        }
        throw new NotFoundException();
    }

    public Response insertUser(User user){
        if(repoUser.findByUsername(user.getUsername()).isPresent()){
            throw new NotFoundException();
        }
        return new Response().setResponse(repoUser.save(user.setDeleted(false).setCreateDate(LocalDateTime.now())));
    }

    public Response updateUser(User user){
        Optional<User> oldUser = repoUser.findById(user.getId());
        if(oldUser.isPresent()){
            return new Response().setResponse(repoUser.save(oldUser.get().setUsername(user.getUsername())
                    .setPassword(user.getPassword()).setFirstName(user.getFirstName())
                    .setSurname(user.getSurname()).setEmail(user.getEmail())));
        }
        throw new NotFoundException();
    }

    public Response selectById(long id){
        Optional<User> user = repoUser.findById(id);
        if(user.isPresent()){
            return new Response().setResponse(user);
        }
        throw new NotFoundException();
    }

    public Response deleteUser(long id){
        Optional<User> user = repoUser.findById(id);
        if(user.isPresent()){
            repoUser.save(user.get().setDeleted(true));
            new Response().setResponse(user);
        }
        throw new NotFoundException();
    }


}
