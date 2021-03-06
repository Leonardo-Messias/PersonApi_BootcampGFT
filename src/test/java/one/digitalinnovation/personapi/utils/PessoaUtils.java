package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.dto.request.PessoaDTO;
import one.digitalinnovation.personapi.entity.Pessoas;

import java.time.LocalDate;
import java.util.Collections;

public class PessoaUtils {
    private static final String PRIMEIRO_NOME = "Leonardo";
    private static final String ULTIMO_NOME = "Messias";
    private static final String CPF_NUMERO = "369.333.878-79";
    private static final long PESSOA_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2000, 10, 6);

    public static PessoaDTO createFakeDTO() {
        return PessoaDTO.builder()
                .primeiroNome(PRIMEIRO_NOME)
                .ultimoNome(ULTIMO_NOME)
                .cpf(CPF_NUMERO)
                .enderecos(Collections.singletonList(EnderecoUtils.createFakeDTO()))
                .dataNasc("2000-10-06")
                .telefones(Collections.singletonList(TelefoneUtils.createFakeDTO()))
                .build();
    }

    public static Pessoas createFakeEntity() {
        return Pessoas.builder()
                .id(PESSOA_ID)
                .primeiroNome(PRIMEIRO_NOME)
                .ultimoNome(ULTIMO_NOME)
                .cpf(CPF_NUMERO)
                .enderecos(Collections.singletonList(EnderecoUtils.createFakeEntity()))
                .dataNasc(BIRTH_DATE)
                .telefones(Collections.singletonList(TelefoneUtils.createFakeEntity()))
                .build();
    }
}
