package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.dto.request.PessoaDTO;
import one.digitalinnovation.personapi.entity.Pessoas;
import one.digitalinnovation.personapi.repositories.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.personapi.utils.PessoaUtils.createFakeDTO;
import static one.digitalinnovation.personapi.utils.PessoaUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {
    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage(){
        PessoaDTO pessoaDto = createFakeDTO();
        Pessoas expectedPersonSave = createFakeEntity();

        when(pessoaRepository.save(any(Pessoas.class))).thenReturn(expectedPersonSave);

        MessageResponseDTO expectedSuccesMessage = createdExpectedMessageResponse(expectedPersonSave.getId());
        MessageResponseDTO succesMesage = pessoaService.createPerson(pessoaDto);

        assertEquals(expectedSuccesMessage, succesMesage);
    }

    private MessageResponseDTO createdExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Pessoa criada com ID" + id)
                .build();
    }
}
