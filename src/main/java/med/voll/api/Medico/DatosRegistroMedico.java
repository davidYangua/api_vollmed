package med.voll.api.Medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.Direccion.DatosDireccion;

public record DatosRegistroMedico(
        @NotBlank String nombre,
        @Email String email,
        @NotBlank String telefono,
        @NotBlank(message = "El documento es obligatorio")
        @Pattern(regexp = "\\d{6}", message = "El documento debe tener 6 dígitos numéricos")
        String documento,
        @NotNull Especialidad especialidad,
        @NotNull @Valid DatosDireccion direccion
) {
}
