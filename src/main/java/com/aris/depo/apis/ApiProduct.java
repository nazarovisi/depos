package com.aris.depo.apis;

import com.aris.depo.daos.DaoProduct;
import com.aris.depo.entites.Product;
import com.aris.depo.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ApiProduct {

    @Autowired
    private DaoProduct daoProduct;

    @GetMapping("/products")
    public Response selected(){
        return daoProduct.selectProducts();
    }

    @PostMapping("/insert")
    public Response insert(@RequestBody Product product){
        return daoProduct.insertProduct(product);
    }

    @PutMapping("/update")
    public Response update(@RequestBody Product product){
        return daoProduct.updateProduct(product);
    }

    @GetMapping("/selectId")
    public Response selectId(@RequestParam long id){
        return daoProduct.selectById(id);
    }

    @DeleteMapping("/delete/{id}")
    public Response delete(@PathVariable long id){
        return daoProduct.deleteProduct(id);
    }
}
