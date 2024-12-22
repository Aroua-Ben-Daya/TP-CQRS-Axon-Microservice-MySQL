package com.aroua.productuser.cqrs.queries;


public class GetProductByIdQuery {
    private final Long id;

    public GetProductByIdQuery(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
