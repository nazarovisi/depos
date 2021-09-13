package com.aris.depo.daos;

import com.aris.depo.entites.Product;
import com.aris.depo.entites.ShippingProduct;
import com.aris.depo.entites.views.ViewShippingProduct;
import com.aris.depo.exceptions.NotFoundException;
import com.aris.depo.model.Response;
import com.aris.depo.repository.RepoProduct;
import com.aris.depo.repository.RepoShippingProduct;
import com.aris.depo.repository.RepoUser;
import com.aris.depo.repository.RepoViewShippingProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class DaoShippingProduct {

    @Autowired
    private RepoShippingProduct repoShippingProduct;

    @Autowired
    private RepoUser repoUser;

    @Autowired
    private RepoProduct repoProduct;

    @Autowired
    private RepoViewShippingProduct repoViewShippingProduct;


    public Response selectShippingProduct(){
        List<ShippingProduct> items = repoShippingProduct.findAll();
        if(items != null && !items.isEmpty()){
            return new Response().setResponse(items);
        }
        throw new NotFoundException();
    }

    public Response insertShippingProduct(ShippingProduct shippingProduct){
        repoShippingProduct.save(shippingProduct.setDeleted(false).setCreateDate(LocalDateTime.now())
                .setShippingNumber(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE)
                .setUser(repoUser.findById(shippingProduct.getUser().getId()).orElse(null))
                .setProduct(repoProduct.findById(shippingProduct.getProduct().getId()).orElse(null)));
        return new Response().setResponse(shippingProduct);
    }

    public Response updateShippingProduct(ShippingProduct shippingProduct){
        Optional<ShippingProduct> oldShippingProduct = repoShippingProduct.findById(shippingProduct.getId());
        if(oldShippingProduct.isPresent()){
            return new Response().setResponse(oldShippingProduct.get().setShippingNumber(shippingProduct.getShippingNumber()));
        }
        throw new NotFoundException();
    }

    public Response selectById(long id){
        Optional<ShippingProduct> shippingProduct = repoShippingProduct.findById(id);
        if(shippingProduct.isPresent()){
            return new Response().setResponse(shippingProduct);
        }
        throw new NotFoundException();
    }

    public Response deleteShippingProduct(long id){
        Optional<ShippingProduct> shippingProduct = repoShippingProduct.findById(id);
        if(shippingProduct.isPresent()){
            repoShippingProduct.save(shippingProduct.get().setDeleted(true));
            return new Response().setResponse(shippingProduct);
        }
        throw new NotFoundException();
    }


    public Response selectViewShipping(){
        List<ViewShippingProduct> viewShippingProducts = repoViewShippingProduct.findAll();
        if(!viewShippingProducts.isEmpty()){
            return new Response().setResponse(viewShippingProducts);
        }
        throw new NotFoundException();
    }
}
