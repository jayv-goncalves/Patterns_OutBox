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

## Schema Update: UUID IDs and Integer Money Types

**Summary of Changes:**
- User IDs: INT → BINARY(16) (stored as UUID in Java)
- Money fields: BigDecimal/Long → INT
- Global Aggregation ID: BINARY(16) → INT

### Entities to Update:

#### 1. **UsersEntity** (outbox-api-service)
- File: `outbox-api-service/src/main/java/com/patterns/outbox_api/domain/entity/UsersEntity.java`
- [x] ✅ id: Already UUID
- [ ] Change `money` from `Long` to `Integer`

#### 2. **UsersEventsEntity** (outbox-api-service)
- File: `outbox-api-service/src/main/java/com/patterns/outbox_api/domain/entity/UsersEventsEntity.java`
- [ ] Change `id_user` from `Long` to `UUID`
- [ ] Change `money` from `Long` to `Integer`
- [ ] Add `@Column(columnDefinition = "BINARY(16)")` to `id_user` field

#### 3. **UsersEventsEntity** (outbox-kafka-producer-service)
- File: `outbox-kafka-producer-service/src/main/java/com/patterns/domain/entity/UsersEventsEntity.java`
- [ ] Change `id_user` from `Long` to `UUID`
- [ ] Change `money` from `Long` to `Integer`
- [ ] Add `@Column(columnDefinition = "BINARY(16)")` to `id_user` field
- [ ] Add `import java.util.UUID;`

#### 4. **GlobalAggregationEntity** (outbox-api-service)
- File: `outbox-api-service/src/main/java/com/patterns/outbox_api/domain/entity/GlobalAggregationEntity.java`
- [ ] Change `id` from `Long` to `Integer`
- [ ] Change `total_money` from `Long` to `Integer`

#### 5. **GlobalAggregationEntity** (outbox-kafka-consumer-service)
- File: `outbox-kafka-consumer-service/src/main/java/com/patterns/domain/domain/GlobalAggregationEntity.java`
- [ ] Change `id` from `Long` to `Integer`
- [ ] Change `total_money` from `Long` to `Integer`

#### 6. **UserAggregationEntity** (outbox-api-service)
- File: `outbox-api-service/src/main/java/com/patterns/outbox_api/domain/entity/UserAggregationEntity.java`
- [x] ✅ user_id: Already UUID
- [ ] Change `total_money` from `Long` to `Integer`

#### 7. **UserAggregationEntity** (outbox-kafka-consumer-service)
- File: `outbox-kafka-consumer-service/src/main/java/com/patterns/domain/domain/UserAggregationEntity.java`
- [x] ✅ user_id: Already UUID
- [ ] Change `total_money` from `Long` to `Integer`

### Additional Notes:
- All UUID id_user fields need `@Column(columnDefinition = "BINARY(16)")` for Hibernate mapping
- Update constructors and getter/setter return types
- No changes needed to table names in @Table annotations
- Database schema already updated in `script.sql`
