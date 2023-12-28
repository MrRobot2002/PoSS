package com.vu.localhost.poss.product;

import java.util.Objects;

import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.vu.localhost.poss.common.Price;
import org.springframework.validation.annotation.Validated;

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")

public class CreateProduct {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("quantity")
    private Long quantity = null;

    @JsonProperty("price")
    private Price price = null;

    @JsonProperty("tenantId")
    private Long tenantId = null;

    public CreateProduct name(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreateProduct quantity(Long quantity) {
        this.quantity = quantity;
        return this;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public CreateProduct price(Price price) {
        this.price = price;
        return this;
    }

    @Valid
    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public CreateProduct tenantId(Long tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateProduct product = (CreateProduct) o;
        return Objects.equals(this.name, product.name) &&
                Objects.equals(this.quantity, product.quantity) &&
                Objects.equals(this.price, product.price) &&
                Objects.equals(this.tenantId, product.tenantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity, tenantId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class product {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
        sb.append("    price: ").append(toIndentedString(price)).append("\n");
        sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}