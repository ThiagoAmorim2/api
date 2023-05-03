package com.pessoas.api.utils;

import org.springframework.stereotype.Component;

@Component
public class QueryUtils {

    public String valorContemNoParametro(String value) {
        return new StringBuilder()
                .append('%')
                .append(value)
                .append('%')
                .toString();
    }

    public String parametroEstaNoComeco(String value) {
        return new StringBuilder()
                .append(value)
                .append('%')
                .toString();
    }

    public String parametroEstaNoFim(String value) {
        return new StringBuilder()
                .append('%')
                .append(value)
                .toString();
    }
}
