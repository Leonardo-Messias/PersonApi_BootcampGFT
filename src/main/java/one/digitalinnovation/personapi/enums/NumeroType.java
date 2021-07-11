package one.digitalinnovation.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NumeroType {
    CASA("casa"),
    PESSOAL("pessoal"),
    COMERCIAL("comercial");

private final String descricao;
}

