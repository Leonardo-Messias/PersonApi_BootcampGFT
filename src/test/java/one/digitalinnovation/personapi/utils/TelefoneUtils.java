package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.dto.request.TelefoneDTO;
import one.digitalinnovation.personapi.entity.Telefone;
import one.digitalinnovation.personapi.enums.NumeroType;

public class TelefoneUtils {
    private static final String NUMERO_TELEFONE = "1199999-9999";
    private static final NumeroType TIPO_TELEFONE = NumeroType.PESSOAL;
    private static final long TELEFONE_ID = 1L;

    public static TelefoneDTO createFakeDTO() {
        return TelefoneDTO.builder()
                .numero(NUMERO_TELEFONE)
                .type(TIPO_TELEFONE)
                .build();
    }

    public static Telefone createFakeEntity() {
        return Telefone.builder()
                .id(TELEFONE_ID)
                .numero(NUMERO_TELEFONE)
                .type(TIPO_TELEFONE)
                .build();
    }
}
