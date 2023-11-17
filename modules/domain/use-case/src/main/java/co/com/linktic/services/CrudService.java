package co.com.linktic.services;

import co.com.linktic.model.ProductoRequest;
import co.com.linktic.model.ProductoResponse;
import co.com.linktic.ports.in.ProductoInPort;
import co.com.linktic.ports.out.ProductoOutPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CrudService implements ProductoInPort {

    private final ProductoOutPort productoOutPort;
    @Override
    public ProductoResponse findById(Integer id) {
        return productoOutPort.findById(id);
    }

    @Override
    public ProductoResponse create(ProductoRequest productoRequest) {
        return productoOutPort.create(productoRequest);
    }

    @Override
    public ProductoResponse update(ProductoRequest productoRequest, Integer id) {
        return productoOutPort.update(productoRequest, id);
    }

    @Override
    public void delete(Integer id) {
        productoOutPort.delete(id);
    }
}
