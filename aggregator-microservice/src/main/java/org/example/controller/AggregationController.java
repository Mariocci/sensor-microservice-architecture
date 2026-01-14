package org.example.controller;

import org.example.config.AggregatorProperties;
import org.example.service.AggregationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/aggregate")
public class AggregationController {

    private final AggregationService service;
    private final AggregatorProperties props;

    public AggregationController(AggregationService service, AggregatorProperties props) {
        this.service = service;
        this.props = props;
    }

    @GetMapping
    public List<Map<String, Object>> aggregate() {
        return service.aggregate();
    }
    @GetMapping("/props")
    public AggregatorProperties getProps() {
        return props;
    }
}
