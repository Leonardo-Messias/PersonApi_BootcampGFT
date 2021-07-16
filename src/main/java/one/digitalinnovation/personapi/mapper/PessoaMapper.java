package one.digitalinnovation.personapi.mapper;

import one.digitalinnovation.personapi.dto.request.PessoaDTO;
import one.digitalinnovation.personapi.entity.Pessoas;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    @Mapping(target = "dataNasc", source = "dataNasc", dateFormat = "yyyy-MM-dd")
    Pessoas toMoldel(PessoaDTO pessoaDTO);
    PessoaDTO toDto (Pessoas pessoas);
}
