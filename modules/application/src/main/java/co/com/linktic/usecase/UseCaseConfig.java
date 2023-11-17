package co.com.linktic.usecase;

import co.com.linktic.ports.in.ProductoInPort;
import co.com.linktic.ports.out.ProductoOutPort;
import co.com.linktic.services.CrudService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UseCaseConfig {


    @Bean
    public ProductoInPort crudUseCase(ProductoOutPort productoOutPort){
        return new CrudService(productoOutPort);
    }


}
