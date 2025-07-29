package med.voll.api.Validaciones;

import med.voll.api.domain.Consulta.DatosReservaConsulta;
import med.voll.api.domain.ValidacionException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidacionConsultaConAnticipacion implements ValidadorDeConsultas{

    public void validar(DatosReservaConsulta datos){
        var fechaConsulta = datos.fecha();
        var ahora = LocalDateTime.now();
        var diferenciaEnMinutos = Duration.between(ahora, fechaConsulta).toMinutes();
        if(diferenciaEnMinutos<30){
            throw new ValidacionException("Horario seleccionado con menos de 30 minutos de anticipación");
        }
    }
}
