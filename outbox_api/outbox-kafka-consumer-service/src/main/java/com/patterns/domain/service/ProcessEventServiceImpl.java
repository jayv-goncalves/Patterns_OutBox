package com.patterns.domain.service;

import com.patterns.ports.in.service.ProcessEventService;
import com.patterns.ports.out.repository.AggregationRepository;
import org.springframework.stereotype.Service;

@Service
public class ProcessEventServiceImpl implements ProcessEventService {

    private final AggregationRepository aggregationRepository;

    public ProcessEventServiceImpl(AggregationRepository aggregationRepository) {
        this.aggregationRepository = aggregationRepository;
    }

    @Override
    public void execute(Long userId, Long money) {
        aggregationRepository.updateUserAggregations(userId, money);
        aggregationRepository.updateGlobalAggregation(money);
    }
}
