package one.digitalinnovation.personapi.repositories;

import one.digitalinnovation.personapi.entity.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoas, Long> {
}
