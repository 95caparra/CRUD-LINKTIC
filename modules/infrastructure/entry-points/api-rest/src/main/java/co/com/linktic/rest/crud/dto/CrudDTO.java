package co.com.linktic.rest.crud.dto;

import co.com.linktic.rest.common.ResponseCommand;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CrudDTO extends ResponseCommand {
    @NotNull(message = "El campo nombre es requerido")
    @NotEmpty(message = "El campo  nombre no puede estar vacio")
    private String nombre;

    @NotNull(message = "El campo descripcion es requerido")
    @NotEmpty(message = "El campo  descripcion no puede estar vacio")
    private String descripcion;

    @NotNull(message = "El campo precio es requerido")
    @NotEmpty(message = "El campo  precio no puede estar vacio")
    private Double precio;

}
