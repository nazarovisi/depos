package com.aris.depo.daos;

import com.aris.depo.entites.Product;
import com.aris.depo.entites.views.ViewShippingProduct;
import com.aris.depo.exceptions.NotFoundException;
import com.aris.depo.model.Response;
import com.aris.depo.repository.RepoShippingProduct;
import com.aris.depo.repository.RepoProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class DaoProduct {

    @Autowired
    private RepoProduct repoProduct;



    public Response selectProducts(){
        List<Product> products = repoProduct.findAll();
        if(products !=null && !products.isEmpty()){
            return new Response().setResponse(products);
        }
        throw new NotFoundException();
    }


    public Response insertProduct(Product product){
        repoProduct.save(product.setDeleted(false)
                .setCreatDate(LocalDateTime.now()));
        return new Response().setResponse(product);
    }

    public Response updateProduct(Product product){
        Optional<Product> oldProduct = repoProduct.findById(product.getId());
        if(oldProduct.isPresent()){
            return new Response().setResponse(repoProduct.save(oldProduct.get()
                    .setMarka(product.getMarka()).setModel(product.getMarka()).setQuantity(product.getQuantity())));
        }
        throw new NotFoundException();
    }

    public Response selectById(long id){
        Optional<Product> product = repoProduct.findById(id);
        if(product.isPresent()){
            new Response().setResponse(product);
        }
        throw new NotFoundException();
    }

    public Response deleteProduct(long id){
        Optional<Product> product = repoProduct.findById(id);
        if(product.isPresent()){
            repoProduct.save(product.get().setDeleted(false));
        }
        throw new NotFoundException();
    }


}
