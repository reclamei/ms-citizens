package br.com.reclamei.citizens.core.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ValidationType {

    DUPLICATION("Duplication");

    private final String type;
}
