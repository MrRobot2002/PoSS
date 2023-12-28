package com.vu.localhost.poss.api;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-25T04:32:42.344389+02:00[Europe/Vilnius]")
public class ApiException extends Exception {
    public ApiException(int code, String msg) {
        super(msg);
    }
}
