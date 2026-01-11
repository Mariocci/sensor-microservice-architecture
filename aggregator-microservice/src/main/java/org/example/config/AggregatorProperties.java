package org.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "")
public class AggregatorProperties {

    public String temperatureUrl;
    public String humidityUrl;
    public String temperatureUnit;
}
