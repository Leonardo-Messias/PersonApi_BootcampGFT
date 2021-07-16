package one.digitalinnovation.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.enums.NumeroType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDTO {
    private Long id;
    @Enumerated(EnumType.STRING)
    private NumeroType type;
    @NotEmpty
    @Size(min = 13, max = 14)
    private String numero;
}
