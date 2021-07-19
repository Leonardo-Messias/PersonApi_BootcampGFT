package one.digitalinnovation.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.enums.EndType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EndDTO {
    private Long id;

    @Enumerated(EnumType.STRING)
    private EndType type;

    @NotEmpty
    @Size(min = 10, max = 100)
    private String endereco;

}
