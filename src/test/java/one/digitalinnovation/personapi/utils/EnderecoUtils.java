package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.dto.request.EndDTO;
import one.digitalinnovation.personapi.dto.request.TelefoneDTO;
import one.digitalinnovation.personapi.entity.Endereco;
import one.digitalinnovation.personapi.entity.Telefone;
import one.digitalinnovation.personapi.enums.EndType;
import one.digitalinnovation.personapi.enums.NumeroType;

public class EnderecoUtils {
    private static final String ENDERECO_PESSOA = "1199999-9999";
    private static final EndType TIPO_ENDERECO = EndType.RESIDENCIAL;
    private static final long ENDERECO_ID = 1L;

    public static EndDTO createFakeDTO() {
        return EndDTO.builder()
                .endereco(ENDERECO_PESSOA)
                .type(TIPO_ENDERECO)
                .build();
    }

    public static Endereco createFakeEntity() {
        return Endereco.builder()
                .id(ENDERECO_ID)
                .endereco(ENDERECO_PESSOA)
                .type(TIPO_ENDERECO)
                .build();
    }
}
