package med.voll.api.Medico;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedicoRepository extends JpaRepository<Medico,Long> {

    Page<Medico> findAllByActivoTrue(Pageable paginacion);
}
