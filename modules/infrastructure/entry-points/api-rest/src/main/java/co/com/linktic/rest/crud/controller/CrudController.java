package co.com.linktic.rest.crud.controller;

import co.com.linktic.model.ProductoRequest;
import co.com.linktic.ports.in.ProductoInPort;
import co.com.linktic.rest.common.HandlerControllerExceptions;
import co.com.linktic.rest.common.UtilsHelper;
import co.com.linktic.rest.crud.dto.CrudDTO;
import co.com.linktic.rest.exceptions.RequestDtoValidationException;
import co.com.linktic.rest.util.ControllerProperties;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(ControllerProperties.TRANSACTIONS)
public class CrudController extends HandlerControllerExceptions {

    private final ProductoInPort productoInPort;

    @PostMapping
    @Operation(summary = "create", description = "create", responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied"),
            @ApiResponse(responseCode = "404", description = "Message not found")
    }
    )
    public CrudDTO create(@RequestBody @Valid CrudDTO crudDTO) throws RequestDtoValidationException {
        validateMandatory(crudDTO);
        ProductoRequest request = ProductoRequest.builder()
                .nombre(crudDTO.getNombre())
                .descripcion(crudDTO.getDescripcion())
                .precio(crudDTO.getPrecio())
                .build();
        var response = productoInPort.create(request);
        return CrudDTO.builder()
                .nombre(response.getNombre())
                .descripcion(response.getDescripcion())
                .precio(response.getPrecio())
                .build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "update", description = "update", responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied"),
            @ApiResponse(responseCode = "404", description = "Message not found")
    }
    )
    public CrudDTO update(@PathVariable Integer id, @RequestBody @Valid CrudDTO crudDTO) throws RequestDtoValidationException {

        validateMandatory(crudDTO);
        ProductoRequest request = ProductoRequest.builder()
                .nombre(crudDTO.getNombre())
                .descripcion(crudDTO.getDescripcion())
                .precio(crudDTO.getPrecio())
                .build();

        var response = productoInPort.update(request, id);
        return CrudDTO.builder()
                .nombre(response.getNombre())
                .descripcion(response.getDescripcion())
                .precio(response.getPrecio())
                .build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "get id", description = "get id", responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied"),
            @ApiResponse(responseCode = "404", description = "Message not found")
    }
    )
    public CrudDTO findById(@PathVariable Integer id) {
        var response = productoInPort.findById(id);
        return CrudDTO.builder()
                .nombre(response.getNombre())
                .descripcion(response.getDescripcion())
                .precio(response.getPrecio())
                .build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete", description = "delete", responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied"),
            @ApiResponse(responseCode = "404", description = "Message not found")
    }
    )
    public void delete(@PathVariable Integer id) {
        productoInPort.delete(id);
    }

    public void validateMandatory(CrudDTO crudDTO) throws RequestDtoValidationException {
        validateNotBlank(crudDTO.getNombre(), "nombre", UtilsHelper.NAME_IS_REQUIRED);
        validateNotBlank(crudDTO.getDescripcion(), "descripcion", UtilsHelper.DESCRIPTION_IS_REQUIRED);
        validateNotBlank(String.valueOf(crudDTO.getPrecio()), "precio", UtilsHelper.PRICE_IS_REQUIRED);
    }

    private void validateNotBlank(String value, String fieldName, String errorMessage) throws RequestDtoValidationException {
        if (value == null || value.isBlank()) {
            log.error("The field " + fieldName + " is required");
            throw new RequestDtoValidationException(errorMessage, "");
        }
    }
}
