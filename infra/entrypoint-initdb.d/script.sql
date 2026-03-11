CREATE TABLE users (
    id BINARY(16) PRIMARY KEY,
    name VARCHAR(100),
    money INT
);

CREATE TABLE users_events (
    id_event INT PRIMARY KEY AUTO_INCREMENT,
    id_user BINARY(16),
    status enum('PENDING', 'IN_PROCESS', 'COMPLETED') NOT NULL
);

CREATE TABLE global_aggregation (
    id INT PRIMARY KEY CHECK (id = 1),
    total_money INT,
    transaction_count INT,
    last_updated TIMESTAMP
);

CREATE TABLE users_aggregations (
    user_id BINARY(16) PRIMARY KEY,
    total_money INT,
    transaction_count INT,
    last_updated TIMESTAMP
);