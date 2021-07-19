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
        return createMessageResponse(savedPessoas.getId(), "Pessoa criada com ID");
    }

    public List<PessoaDTO> listAll() {
        List<Pessoas> allPeople = pessoaRepository.findAll();
        return allPeople.stream()
                .map(pessoaMapper::toDto).
                        collect(Collectors.toList());
    }

    public PessoaDTO findById(Long id) throws PessoaNotFoundException {
        Pessoas pessoas = verifyExists(id);
        return pessoaMapper.toDto(pessoas);
    }

    public void deleteById(Long id) throws PessoaNotFoundException {
        verifyExists(id);
        pessoaRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PessoaDTO pessoaDTO) throws PessoaNotFoundException {
        verifyExists(id);
        Pessoas pessoaToUpdate = pessoaMapper.toMoldel(pessoaDTO);
        Pessoas updatePessoa = pessoaRepository.save(pessoaToUpdate);
        return createMessageResponse(updatePessoa.getId(), "Pessoa Atualizada com ID");
    }

    private Pessoas verifyExists(Long id)throws PessoaNotFoundException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message+id)
                .build();
    }
    private MessageResponseDTO createMessageResponses(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message+id)
                .build();
    }


}
