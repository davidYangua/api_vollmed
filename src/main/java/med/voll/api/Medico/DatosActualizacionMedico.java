package med.voll.api.Medico;

import jakarta.validation.constraints.NotBlank;
import med.voll.api.Direccion.DatosDireccion;
import med.voll.api.Direccion.Direccion;

public record DatosActualizacionMedico(
        @NotBlank Long id,
        String nombre,
        String telefono,
        DatosDireccion direccion
) {
}
