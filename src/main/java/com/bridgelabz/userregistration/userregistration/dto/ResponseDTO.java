package com.bridgelabz.userregistration.userregistration.dto;

import lombok.Data;
import org.hibernate.query.criteria.internal.predicate.PredicateImplementor;

@Data
public class ResponseDTO {
    private String message;
    private Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
