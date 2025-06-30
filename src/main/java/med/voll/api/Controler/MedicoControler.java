package med.voll.api.Controler;

import jakarta.validation.Valid;
import med.voll.api.Medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoControler {

    @Autowired
    private MedicoRepository repository;

    @Transactional
    @PostMapping("")
    public void registrar(@RequestBody @Valid DatosRegistroMedico datos) {
        repository.save(new Medico(datos));
    }

    @GetMapping
    public Page<DatosListaMedico> listar(@PageableDefault(size = 10, sort = {"nombre"}) Pageable paginacion) {
        return repository.findAllByActivoTrue(paginacion).map(DatosListaMedico::new);
    }

    @Transactional
    @PutMapping
    public void actualizar(@RequestBody @Valid DatosActualizacionMedico datos) {
        var medico = repository.getReferenceById(datos.id());
        medico.actualizarInformaciones(datos);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        //repository.deleteById(id); //delete físico

        // operación lógica
        var medico = repository.getReferenceById(id);
        medico.eliminar();
    }
}
