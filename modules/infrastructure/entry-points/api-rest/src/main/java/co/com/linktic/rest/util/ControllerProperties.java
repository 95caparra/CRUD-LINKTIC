package co.com.linktic.rest.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "services.rest")
public class ControllerProperties {
    ControllerProperties(){
    }

    public static final String TRANSACTIONS = "${services.rest.transactions.path}";
}
