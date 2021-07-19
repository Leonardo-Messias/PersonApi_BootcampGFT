package one.digitalinnovation.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EndType {
    RESIDENCIAL("residencial"),
    COMERCIAL("comercial");
    private final String descricao;
}
