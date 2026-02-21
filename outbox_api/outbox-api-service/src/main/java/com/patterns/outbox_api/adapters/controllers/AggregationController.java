package com.patterns.outbox_api.adapters.controllers;

import com.patterns.outbox_api.dtos.AggregationDTO;
import com.patterns.outbox_api.ports.in.services.AggregationService;
import com.patterns.outbox_api.responses.TotalAmountResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AggregationController {

    private final AggregationService aggregationService;

    public AggregationController(AggregationService aggregationService) {
        this.aggregationService = aggregationService;
    }

    @GetMapping("/aggregations/total_amount")
    ResponseEntity<TotalAmountResponse> getTotalAmount() {
        AggregationDTO aggregationDTO = aggregationService.getGlobalAggregation();

        if(aggregationDTO == null) {
            return ResponseEntity.ok(new TotalAmountResponse(0L));
        }

        return ResponseEntity.ok(new TotalAmountResponse(aggregationDTO.getTotal_money()));
    }

    @GetMapping("/aggregations/users/{id}/total_amount")
    ResponseEntity<TotalAmountResponse> getAllAggregationDetails(@PathVariable String id) {
        AggregationDTO aggregationDTO = aggregationService.getUserAggregation(id);

        if(aggregationDTO == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new TotalAmountResponse(aggregationDTO.getTotal_money()));
    }
}
