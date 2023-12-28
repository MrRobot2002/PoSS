package com.vu.localhost.poss.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

/**
 * InlineResponse200
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")


public class InlineResponse200   {
  @JsonProperty("tenantToken")
  private String tenantToken = null;

  public InlineResponse200 tenantToken(String tenantToken) {
    this.tenantToken = tenantToken;
    return this;
  }

  /**
   * Get tenantToken
   * @return tenantToken
   **/
  @Schema(description = "")
  
    public String getTenantToken() {
    return tenantToken;
  }

  public void setTenantToken(String tenantToken) {
    this.tenantToken = tenantToken;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(this.tenantToken, inlineResponse200.tenantToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tenantToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("    tenantToken: ").append(toIndentedString(tenantToken)).append("\n");
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
