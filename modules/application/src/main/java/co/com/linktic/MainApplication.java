package co.com.linktic;

import co.com.linktic.properties.ComponentProperties;
import co.com.linktic.rest.common.statuscode.StatusCodeConfig;
import co.com.linktic.rest.util.ControllerProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@SpringBootApplication
@EnableScheduling
@EnableCaching
@RequiredArgsConstructor
@EnableConfigurationProperties({
        StatusCodeConfig.class,
        ComponentProperties.class,
        ControllerProperties.class
})
public class MainApplication implements ApplicationListener<ContextRefreshedEvent> {
    private final Environment environment;
    public static final String LONG_LINE = "------------------------------------------------";
    public static final String LOG_START_PROJECT = "Aplicación iniciada: [{}]";
    public static final String LOG_PORT_OF_PROJECT = "Puerto: [{}]";
    public static final String LOG_PROJECT_VERSION = "Versión: [{}]";
    public static final String LOG_CONTEXT_PATH = "Context path: [{}]";

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info(LONG_LINE);
        log.info(LOG_START_PROJECT, environment.getProperty("component.name", ""));
        log.info(LOG_PROJECT_VERSION, environment.getProperty("component.version", ""));
        log.info(LOG_PORT_OF_PROJECT, environment.getProperty("server.port", ""));
        log.info(LOG_CONTEXT_PATH, environment.getProperty("server.servlet.context-path", ""));
        log.info(LONG_LINE);
    }
}
