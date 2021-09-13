package com.aris.depo.apis;

import com.aris.depo.daos.DaoShippingProduct;
import com.aris.depo.entites.ShippingProduct;
import com.aris.depo.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipping")
public class ApiShippingProduct {

    @Autowired
    private DaoShippingProduct daoShippingProduct;

    @GetMapping("/shippingProducts")
    public Response selected(){
        return daoShippingProduct.selectShippingProduct();
    }

    @PostMapping("/insert")
    public Response insert(@RequestBody ShippingProduct shippingProduct){
        return daoShippingProduct.insertShippingProduct(shippingProduct);
    }

    @PutMapping("/update")
    public Response update(@RequestBody ShippingProduct shippingProduct){
        return daoShippingProduct.updateShippingProduct(shippingProduct);
    }

    @GetMapping("/selectId")
    public Response selectId(@RequestParam long id){
        return daoShippingProduct.selectById(id);
    }

    @DeleteMapping("/delete/{id}")
    public Response delete(@PathVariable long id){
        return daoShippingProduct.deleteShippingProduct(id);
    }

    @GetMapping("/getAll")
    public Response getAll(){
        return daoShippingProduct.selectViewShipping();
    }
}
