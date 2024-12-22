package com.aroua.productuser.cqrs.queries;

import com.aroua.productuser.entities.Product;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/products/queries")
public class ProductQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping("/{id}")
    public CompletableFuture<Product> getProductById(@PathVariable Long id) {
        // Exécuter la requête pour obtenir le produit
        return queryGateway.query(new GetProductByIdQuery(id), Product.class);
    }
}
