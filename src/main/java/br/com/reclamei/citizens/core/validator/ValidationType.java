package br.com.reclamei.citizens.core.validator;

import lombok.Getter;

@Getter
public enum ValidationType {

    DUPLICATION("Duplication");

    private final String type;

    ValidationType(String type) {
        this.type = type;
    }
}
