package org.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "aggregator")
public class AggregatorProperties {

    private String temperatureUrl;
    private String humidityUrl;
    private String temperatureUnit;

    public String getTemperatureUrl() {
        return temperatureUrl;
    }

    public void setTemperatureUrl(String temperatureUrl) {
        this.temperatureUrl = temperatureUrl;
    }

    public String getHumidityUrl() {
        return humidityUrl;
    }

    public void setHumidityUrl(String humidityUrl) {
        this.humidityUrl = humidityUrl;
    }

    public String getTemperatureUnit() {
        return temperatureUnit;
    }

    public void setTemperatureUnit(String temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }
}