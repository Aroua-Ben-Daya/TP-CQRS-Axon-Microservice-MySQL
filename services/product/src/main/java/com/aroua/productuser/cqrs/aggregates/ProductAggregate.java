package com.aroua.productuser.cqrs.aggregates;

import com.aroua.productuser.cqrs.commands.CreateProductCommand;
import com.aroua.productuser.cqrs.events.ProductCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.axonframework.modelling.command.AggregateLifecycle;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String id;
    private String name;
    private String description;
    private double price;
    private int stock;

    public ProductAggregate() {}

    public ProductAggregate(CreateProductCommand command) {
        // Publier un événement
        apply(new ProductCreatedEvent(
                command.getId(), command.getName(), command.getDescription(),
                command.getPrice(), command.getStock()
        ));
    }

    // Gestion des événements
    public void on(ProductCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.price = event.getPrice();
        this.stock = event.getStock();
    }
}