package med.voll.api.Validaciones;

import med.voll.api.domain.Consulta.DatosReservaConsulta;
import med.voll.api.domain.Medico.MedicoRepository;
import med.voll.api.domain.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacionMedicoActivo implements ValidadorDeConsultas{

    @Autowired
    private MedicoRepository repository;

    public void validar(DatosReservaConsulta datos){
        if(datos.idMedico()==null){
            return;
        }
        var medicoEstaActivo = repository.findActivoById(datos.idMedico());
        if(!medicoEstaActivo){
            throw new ValidacionException("Consulta no puede ser reservada con médico excluído");
        }
    }
}
