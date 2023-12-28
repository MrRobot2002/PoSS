package com.vu.localhost.poss.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

/**
 * WorkerCodeResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")


public class WorkerCodeResponse   {
  @JsonProperty("code")
  private String code = null;

  @JsonProperty("role")
  private String role = null;

  public WorkerCodeResponse code(String code) {
    this.code = code;
    return this;
  }

  /**
   * The unique access code for the worker or manager.
   * @return code
   **/
  @Schema(required = true, description = "The unique access code for the worker or manager.")
      @NotNull

    public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public WorkerCodeResponse role(String role) {
    this.role = role;
    return this;
  }

  /**
   * The role associated with the code.
   * @return role
   **/
  @Schema(required = true, description = "The role associated with the code.")
      @NotNull

    public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkerCodeResponse workerCodeResponse = (WorkerCodeResponse) o;
    return Objects.equals(this.code, workerCodeResponse.code) &&
        Objects.equals(this.role, workerCodeResponse.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkerCodeResponse {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
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
