package com.aroua.productuser.cqrs.projections;

import com.aroua.productuser.cqrs.queries.GetProductByIdQuery;
import com.aroua.productuser.entities.Product;
import com.aroua.productuser.repositories.ProductRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductProjection {

    @Autowired
    private ProductRepository productRepository;

    @QueryHandler
    public Product handle(GetProductByIdQuery query) {
        return productRepository.findById(query.getId()).orElse(null);
    }
}