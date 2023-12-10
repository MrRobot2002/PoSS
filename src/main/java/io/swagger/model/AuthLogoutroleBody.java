package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AuthLogoutroleBody
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-10T17:29:46.806586+02:00[Europe/Vilnius]")


public class AuthLogoutroleBody   {
  @JsonProperty("roleToken")
  private String roleToken = null;

  public AuthLogoutroleBody roleToken(String roleToken) {
    this.roleToken = roleToken;
    return this;
  }

  /**
   * Get roleToken
   * @return roleToken
   **/
  @Schema(description = "")
  
    public String getRoleToken() {
    return roleToken;
  }

  public void setRoleToken(String roleToken) {
    this.roleToken = roleToken;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthLogoutroleBody authLogoutroleBody = (AuthLogoutroleBody) o;
    return Objects.equals(this.roleToken, authLogoutroleBody.roleToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roleToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthLogoutroleBody {\n");
    
    sb.append("    roleToken: ").append(toIndentedString(roleToken)).append("\n");
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
