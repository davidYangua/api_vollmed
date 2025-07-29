package med.voll.api.domain.Medico;

import jakarta.validation.constraints.Future;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico,Long> {

    Page<Medico> findAllByActivoTrue(Pageable paginacion);

    Optional<Medico> findByIdAndActivoTrue(Long id);

    @Query("""
            select m from Medico m 
            where m.activo = TRUE
            and m.especialidad = :especialidad
            and m.id not in(
                select c.medico.id from Consulta c
                where c.fecha = :fecha
            )
            order by rand()
            limit 1
            """)
    Medico elegirMedicoAleatorioDisponibleEnLaFecha(Especialidad especialidad, @Future LocalDateTime fecha);

    @Query("""
           select m.activo from Medico m
           where m.id = :idMedico
            """)
    Boolean findActivoById(Long idMedico);
}