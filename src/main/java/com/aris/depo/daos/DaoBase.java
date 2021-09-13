package com.aris.depo.daos;

import com.aris.depo.entites.Base;
import com.aris.depo.entites.views.ViewBase;
import com.aris.depo.exceptions.NotFoundException;
import com.aris.depo.model.Response;
import com.aris.depo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class DaoBase {

    @Autowired
    private RepoBase repoBase;

    @Autowired
    private RepoShippingProduct repoShippingProduct;

    @Autowired
    private RepoViewBase repoViewBase;



    public Response selectBases(){
        List<Base> bases = repoBase.findAll();
        if(bases !=null && !bases.isEmpty()){
            return new Response().setResponse(bases);
        }
        throw new NotFoundException();
    }

    public Response insertBase(Base base){
        base = repoBase.save(base.setDeleted(false).setCreateDate(LocalDateTime.now())
                .setShippingProduct(repoShippingProduct.findById(base.getShippingProduct().getId()).orElse(null)));
        return new Response().setResponse(base);
    }

    public Response updateBase(Base base){
        Optional<Base> oldBase = repoBase.findById(base.getId());
        if(oldBase.isPresent()){
            return new Response().setResponse(oldBase.get().setName(base.getName()));
        }
        throw new NotFoundException();
    }

    public Response selectById(long id){
        Optional<Base> base = repoBase.findById(id);
        if(base.isPresent()){
            return new Response().setResponse(base);
        }
        throw new NotFoundException();
    }

    public Response deleteBase(long id){
        Optional<Base> base = repoBase.findById(id);
        if(base.isPresent()){
            repoBase.save(base.get().setDeleted(true));
        }
        throw new NotFoundException();
    }

    public Response selectViewBase(){
        List<ViewBase> bases = repoViewBase.findAll();
        if(!bases.isEmpty()){
            return new Response().setResponse(bases);
        }
        throw new NotFoundException();
    }
}
