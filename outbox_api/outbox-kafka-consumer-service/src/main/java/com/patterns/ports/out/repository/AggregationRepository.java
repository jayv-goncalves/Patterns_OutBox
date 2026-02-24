package main.java.com.patterns.ports.out.repository;


public interface AggregationRepository {
    void updateUserAggregations(Long userId, Long amount);
    void updateGlobalAggregation(long amount);
}
