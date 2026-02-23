## Project Goal:
- [X] Implement Kafka Consumer
- [X] Implement Materialized Aggregation to sum amount
- [X] Implement API /total_amount
- [ ] Add unit test
- [ ] Add integration test

## Refactor Outbox folder:
- [X] Remove common modules (like repository module, domain module, etc.)
- [X] Add Spring initializer in all services;
- [X] Add application properties in all services;
- [X] Implement correct layers to the application so they can work isolated
- [ ] Implement docker for each application
- [ ] Update offset logic to not break when Container is recreated

## Bugs
- [ ] Fix the "money" to return cents
