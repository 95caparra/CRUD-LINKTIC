package co.com.linktic.ports.in;

import co.com.linktic.model.ProductoRequest;
import co.com.linktic.model.ProductoResponse;

public interface ProductoInPort {

    ProductoResponse findById(Integer id);

    ProductoResponse create(ProductoRequest productoRequest);

    ProductoResponse update(ProductoRequest productoRequest, Integer id);

    void delete(Integer id);
}
