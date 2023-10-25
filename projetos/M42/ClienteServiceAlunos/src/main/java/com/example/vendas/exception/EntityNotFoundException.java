package com.example.vendas.exception;

import com.example.vendas.domain.Cliente;

public class EntityNotFoundException extends RuntimeException {
    private Class<Cliente> entityName;
    private String fieldName;
    private String fieldValue;

    public EntityNotFoundException(Class<Cliente> class1, String fieldName, String fieldValue) {
        super(String.format("%s not found with %s: %s", class1, fieldName, fieldValue));
        this.entityName = class1;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public Class<Cliente> getEntityName() {
        return entityName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }
}

