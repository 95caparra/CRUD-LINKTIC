package co.com.linktic.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "properties")
public class ComponentProperties {

    private Boolean requiredFirstOtp;
    private Boolean allowAllDevices;
    private Integer maxOtpValidationFails;
    private List<String> whiteListNumbers;

}
