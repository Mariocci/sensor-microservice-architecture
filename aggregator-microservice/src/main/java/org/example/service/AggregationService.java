package org.example.service;

import org.example.config.AggregatorProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class AggregationService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final AggregatorProperties props;

    public AggregationService(AggregatorProperties props) {
        this.props = props;
    }

    public List<Map<String, Object>> aggregate() {

        Map temp = restTemplate.getForObject(props.temperatureUrl, Map.class);
        Map hum = restTemplate.getForObject(props.humidityUrl, Map.class);

        if ("K".equalsIgnoreCase(props.temperatureUnit)) {
            double c = ((Number) temp.get("value")).doubleValue();
            temp.put("value", c + 273.15);
            temp.put("unit", "K");
        }

        return List.of(hum, temp);
    }
}
