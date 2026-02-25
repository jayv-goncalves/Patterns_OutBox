package main.java.com.patterns.outbox_api.domain.service;

import main.java.com.patterns.outbox_api.domain.entity.GlobalAggregationEntity;
import main.java.com.patterns.outbox_api.domain.entity.UserAggregationEntity;
import main.java.com.patterns.outbox_api.dtos.AggregationDTO;
import main.java.com.patterns.outbox_api.ports.in.services.AggregationService;
import main.java.com.patterns.outbox_api.ports.out.repositories.AggregationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AggregationServiceImpl implements AggregationService {

    private final AggregationRepository aggregationRepository;

    public AggregationServiceImpl(AggregationRepository aggregationRepository) {
        this.aggregationRepository = aggregationRepository;
    }

    @Override
    public AggregationDTO getGlobalAggregation() {
        Optional<GlobalAggregationEntity> globalAggregation = aggregationRepository.getGlobalAggregation();

        if(globalAggregation.isPresent()) {
            AggregationDTO globalAggregationDTO = new AggregationDTO();
            globalAggregationDTO.setId(globalAggregation.get().getId().toString());
            globalAggregationDTO.setTotal_money(globalAggregation.get().getTotal_money());
            globalAggregationDTO.setTransaction_count(globalAggregation.get().getTransaction_count());
            globalAggregationDTO.setLast_updated(globalAggregation.get().getLast_updated());

            return globalAggregationDTO;
        }

        return null;
    }

    @Override
    public AggregationDTO getUserAggregation(String id) {
        Optional<UserAggregationEntity> userAggregation = aggregationRepository.getUserAggregationById(UUID.fromString(id));

        if(userAggregation.isPresent()) {
            AggregationDTO globalAggregationDTO = new AggregationDTO();
            globalAggregationDTO.setId(userAggregation.get().getUserId().toString());
            globalAggregationDTO.setTotal_money(userAggregation.get().getTotal_money());
            globalAggregationDTO.setTransaction_count(userAggregation.get().getTransaction_count());
            globalAggregationDTO.setLast_updated(userAggregation.get().getLast_updated());

            return globalAggregationDTO;
        }

        return null;
    }
}
