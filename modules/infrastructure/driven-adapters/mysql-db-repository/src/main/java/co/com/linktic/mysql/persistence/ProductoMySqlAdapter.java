package co.com.linktic.mysql.persistence;

import co.com.linktic.model.ProductoRequest;
import co.com.linktic.model.ProductoResponse;
import co.com.linktic.mysql.entities.ProductoEntity;
import co.com.linktic.mysql.repository.ProductoMySqlRepository;
import co.com.linktic.ports.out.ProductoOutPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component()
public class ProductoMySqlAdapter implements ProductoOutPort {

    private final ProductoMySqlRepository productoMySqlRepository;


    @Override
    public ProductoResponse findById(Integer id) {
        var response = productoMySqlRepository.findById(id);

        return ProductoResponse.builder()
                .id(response.get().getId())
                .nombre(response.get().getNombre())
                .descripcion(response.get().getDescripcion())
                .precio(response.get().getPrecio())
                .build();
    }

    @Override
    public ProductoResponse create(ProductoRequest productoRequest) {

        ProductoEntity product = ProductoEntity.builder()
                .id(productoRequest.getId())
                .nombre(productoRequest.getNombre())
                .descripcion(productoRequest.getDescripcion())
                .precio(productoRequest.getPrecio())
                .build();

        var response = productoMySqlRepository.save(product);

        return ProductoResponse.builder()
                .id(response.getId())
                .nombre(response.getNombre())
                .descripcion(response.getDescripcion())
                .precio(response.getPrecio())
                .build();
    }


    @Override
    public ProductoResponse update(ProductoRequest productoRequest, Integer id) {

        var search = productoMySqlRepository.findById(id);

        if(!search.isEmpty()){
            ProductoEntity product = ProductoEntity.builder()
                    .id(search.get().getId())
                    .nombre(productoRequest.getNombre())
                    .descripcion(productoRequest.getDescripcion())
                    .precio(productoRequest.getPrecio())
                    .build();

            var response = productoMySqlRepository.save(product);

            return ProductoResponse.builder()
                    .id(response.getId())
                    .nombre(response.getNombre())
                    .descripcion(response.getDescripcion())
                    .precio(response.getPrecio())
                    .build();
        }
        return  ProductoResponse.builder().build();
    }

    @Override
    public void delete(Integer id) {
        productoMySqlRepository.deleteById(id);
    }
}
