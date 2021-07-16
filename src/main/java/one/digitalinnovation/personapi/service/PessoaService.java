package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.dto.request.PessoaDTO;
import one.digitalinnovation.personapi.entity.Pessoas;
import one.digitalinnovation.personapi.exception.PessoaNotFoundException;
import one.digitalinnovation.personapi.mapper.PessoaMapper;
import one.digitalinnovation.personapi.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    private PessoaRepository pessoaRepository;

    private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public MessageResponseDTO createPerson(PessoaDTO pessoaDTO) {
        Pessoas pessoaToSave = pessoaMapper.toMoldel(pessoaDTO);
        Pessoas savedPessoas = pessoaRepository.save(pessoaToSave);
        return MessageResponseDTO
                .builder()
                .message("Pessoa criada com ID" + savedPessoas.getId())
                .build();
    }


    public List<PessoaDTO> listAll() {
        List<Pessoas> allPeople = pessoaRepository.findAll();
        return allPeople.stream()
                .map(pessoaMapper::toDto).
                        collect(Collectors.toList());
    }

    public PessoaDTO findById(Long id) throws PessoaNotFoundException {
        Pessoas pessoas = pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));

        return pessoaMapper.toDto(pessoas);
    }
}
