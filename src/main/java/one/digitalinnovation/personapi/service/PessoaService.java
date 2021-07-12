package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Pessoas;
import one.digitalinnovation.personapi.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PessoaService {
    private PessoaRepository pessoaRepository;
@Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public MessageResponseDTO createPerson(Pessoas pessoas){
        Pessoas savedPessoas = pessoaRepository.save(pessoas);
        return MessageResponseDTO
                .builder()
                .message("Pessoa criada com ID"+savedPessoas.getId())
                .build();
    }
}
