package org.project.exceptions;

import java.util.ArrayList;
import java.util.List;

//Classe que representa a mensagem de erro para tratamento de exceções
public class ErrorMessage {

    private int code;

    private String status;

    private String message;

    private List<ErrorDetail> details = new ArrayList<>();

    public ErrorMessage(){}

    public ErrorMessage(int code, String status, String message) {

        this.code = code;
        this.status = status;
        this.message = message;
    }
    // Getters and setters


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ErrorDetail> getDetails() {
        return details;
    }

    @Override
    public String toString(){
        String aux = "";
        for (ErrorDetail detail : details) {
            aux += detail.toString() + ",\n";
        }

        return "{\n" +
                "   code: " + code + ",\n" +
                "   status: " + status + ",\n" +
                "   message: " + message + ",\n" +
                "   details: [\n" + aux + "]\n" +
                "}";
    }
}
