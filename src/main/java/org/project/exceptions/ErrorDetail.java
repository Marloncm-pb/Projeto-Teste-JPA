package org.project.exceptions;

//Classe que representa o detalhe do erro para tratamento de exceções
public class ErrorDetail {
    private String field;
    private String message;

    public ErrorDetail(String field, String message) {
        this.field = field;
        this.message = message;
    }


    // Getters and setters
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{\n   " + "field: " + field + ",\n"  + "   message: " + message + "\n}";
    }
}
