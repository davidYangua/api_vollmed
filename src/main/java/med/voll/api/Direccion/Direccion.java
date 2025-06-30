package med.voll.api.Direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class Direccion {

    private String calle;
    private String numero;
    private String complemento;
    private String barrio;
    private String codigo_postal;
    private String ciudad;
    private String provincia;

    public Direccion(DatosDireccion datosDireccion) {
        this.calle = datosDireccion.calle();
        this.numero = datosDireccion.numero();
        this.complemento = datosDireccion.complemento();
        this.barrio = datosDireccion.barrio();
        this.codigo_postal = datosDireccion.codigo_postal();
        this.ciudad = datosDireccion.ciudad();
        this.provincia = datosDireccion.provincia();
    }

    public void actualizarDireccion(DatosDireccion direccion) {
        if(direccion.calle()!=null){
            this.calle = direccion.calle();
        }
        if(direccion.numero()!=null){
            this.numero = direccion.numero();
        }if(direccion.complemento()!=null){
            this.complemento = direccion.complemento();
        }if(direccion.barrio()!=null){
            this.barrio = direccion.barrio();
        }if(direccion.codigo_postal()!=null){
            this.codigo_postal = direccion.codigo_postal();
        }if(direccion.ciudad()!=null){
            this.ciudad = direccion.ciudad();
        }if(direccion.provincia()!=null){
            this.provincia = direccion.provincia();
        }
    }
}
