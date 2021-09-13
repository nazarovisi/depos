package com.aris.depo.apis;

import com.aris.depo.daos.DaoBase;
import com.aris.depo.entites.Base;
import com.aris.depo.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/base")
public class ApiBase {

    @Autowired
    private DaoBase daoBase;

    @GetMapping("/bases")
    public Response selected(){
        return daoBase.selectBases();
    }

    @PostMapping("/insert")
    public Response insert(@RequestBody Base base){
        return daoBase.insertBase(base);
    }

    @PutMapping("/update")
    public Response update(@RequestBody Base base){
        return daoBase.updateBase(base);
    }

    @GetMapping("/selectId")
    public Response selectId(long id){
        return daoBase.selectById(id);
    }

    @DeleteMapping("/delete/{id}")
    public Response delete(@PathVariable long id){
        return daoBase.deleteBase(id);
    }

    @GetMapping("findAll")
    public Response selectViewBase(){
        return daoBase.selectViewBase();
    }
}
