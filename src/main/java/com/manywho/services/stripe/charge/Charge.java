package com.manywho.services.stripe.charge;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

@Type.Element(name = Charge.NAME)
public class Charge implements Type {
    public final static String NAME = "Charge";

    public Charge(String id, Number amount, String currency, Boolean paid) {
        this.amount = amount;
        this.currency = currency;
        this.paid = paid;
        this.id = id;
    }

    @Type.Identifier
    @Type.Property(name = "ID", contentType = ContentType.String)
    private String id;

    @Type.Property(name = "Amount", contentType = ContentType.Number)
    private Number amount;

    @Type.Property(name = "Currency", contentType = ContentType.String)
    private String currency;

    @Type.Property(name = "Paid", contentType = ContentType.Boolean)
    private Boolean paid;

    public Number getAmount() {
        return amount;
    }

    public void setAmount(Number amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getPaid() {
        return paid;
    }

    public String getId() {
        return id;
    }
}
