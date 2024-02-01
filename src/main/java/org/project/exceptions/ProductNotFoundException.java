package org.project.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ProductNotFoundException extends RuntimeException{

    private int code;

    private String status;



    public ProductNotFoundException(String s) {
        super(s);
        code = 404;
        status = "Bad Request";
    }
}
