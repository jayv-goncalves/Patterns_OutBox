package main.java.com.patterns.outbox_api.adapters.controllers;


import main.java.com.patterns.outbox_api.dtos.AggregationDTO;
import main.java.com.patterns.outbox_api.dtos.TotalAmountDTO;
import main.java.com.patterns.outbox_api.ports.in.services.AggregationService;
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
    ResponseEntity<TotalAmountDTO> getTotalAmount() {
        AggregationDTO aggregationDTO = aggregationService.getGlobalAggregation();

        if(aggregationDTO == null) {
            return ResponseEntity.ok(new TotalAmountDTO(0L));
        }

        return ResponseEntity.ok(new TotalAmountDTO(aggregationDTO.getTotal_money()));
    }

    @GetMapping("/aggregations/users/{id}/total_amount")
    ResponseEntity<TotalAmountDTO> getAllAggregationDetails(@PathVariable String id) {
        AggregationDTO aggregationDTO = aggregationService.getUserAggregation(id);

        if(aggregationDTO == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new TotalAmountDTO(aggregationDTO.getTotal_money()));
    }
}
