package com.patterns.outbox_api.ports.in.services;

import com.patterns.outbox_api.dtos.AggregationDTO;

public interface AggregationService {
    AggregationDTO getGlobalAggregation();
    AggregationDTO getUserAggregation(String id);
}
