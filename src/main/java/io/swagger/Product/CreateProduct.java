package io.swagger.Product;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

/**
 * Product
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")

public class CreateProduct {
    @JsonProperty("productId")
    private Long productId = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("quantity")
    private Long quantity = null;

    @JsonProperty("amount")
    private Long amount = null;

    @JsonProperty("currence")
    private Long currency = null;

    @JsonProperty("tenant")
    private Long tenant = null;

    public CreateProduct productId(Long productId) {
        this.productId = productId;
        return this;
    }

    @Schema(description = "")

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public CreateProduct name(String name) {
        this.name = name;
        return this;
    }

    @Schema(description = "")
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

    @Schema(description = "")

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public CreateProduct amount(Long amount) {
        this.amount = amount;
        return this;
    }

    public CreateProduct currency(Long currency) {
        this.currency = currency;
        return this;
    }

    public CreateProduct tenant(Long tenant) {
        this.tenant = tenant;
        return this;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setCurrency(Long currency) {
        this.currency = currency;
    }

    public Long getCurrency() {
        return currency;
    }

    public void setTenant(Long tenant) {
        this.tenant = tenant;
    }

    public Long getTenant() {
        return tenant;
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
        return Objects.equals(this.productId, product.productId) &&
                Objects.equals(this.name, product.name) &&
                Objects.equals(this.quantity, product.quantity) &&
                Objects.equals(this.amount, product.amount) &&
                Objects.equals(this.currency, product.currency) &&
                Objects.equals(this.tenant, product.tenant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, quantity, amount, currency, tenant);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Product {\n");

        sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("    tenant: ").append(toIndentedString(tenant)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
