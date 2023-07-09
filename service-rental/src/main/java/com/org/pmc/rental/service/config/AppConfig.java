package com.org.pmc.rental.service.config;

import com.pmc.rental.contract.config.OpenApiConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        OpenApiConfiguration.class
})
public class AppConfig {

}
