package co.com.linktic.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ProductoRequest {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Double precio;
}
