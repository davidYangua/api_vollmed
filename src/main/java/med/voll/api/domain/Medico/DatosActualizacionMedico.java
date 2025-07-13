package med.voll.api.domain.Medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.Direccion.DatosDireccion;

public record DatosActualizacionMedico(
        @NotNull Long id,
        String nombre,
        String telefono,
        DatosDireccion direccion
) {
}
