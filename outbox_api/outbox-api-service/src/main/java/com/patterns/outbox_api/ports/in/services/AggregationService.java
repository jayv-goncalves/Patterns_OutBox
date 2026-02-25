package main.java.com.patterns.outbox_api.ports.in.services;


import main.java.com.patterns.outbox_api.dtos.AggregationDTO;

public interface AggregationService {
    AggregationDTO getGlobalAggregation();
    AggregationDTO getUserAggregation(String id);
}
