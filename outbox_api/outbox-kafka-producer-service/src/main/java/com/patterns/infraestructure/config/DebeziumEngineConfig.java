package com.patterns.infraestructure.config;

import com.patterns.infraestructure.properties.DebeziumProperties;
import com.patterns.ports.in.services.ProcessDatabaseEventService;
import io.debezium.engine.ChangeEvent;
import io.debezium.engine.DebeziumEngine;
import io.debezium.engine.format.Json;
import io.debezium.engine.format.KeyValueHeaderChangeEventFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class DebeziumEngineConfig {

    private final DebeziumProperties debeziumProperties;

    public  DebeziumEngineConfig(DebeziumProperties debeziumProperties) {
        this.debeziumProperties = debeziumProperties;
    }

    @Bean
    public Properties debeziumEngineProperties() {
        Properties p = new Properties();
        p.setProperty("name",                                  debeziumProperties.getName());
        p.setProperty("connector.class",                       debeziumProperties.getConnectorClass());
        p.setProperty("bootstrap.servers",                     debeziumProperties.getBootstrapServers());
        p.setProperty("database.hostname",                     debeziumProperties.getDatabase().getHostname());
        p.setProperty("database.port",            String.valueOf(debeziumProperties.getDatabase().getPort()));
        p.setProperty("database.user",                         debeziumProperties.getDatabase().getUser());
        p.setProperty("database.password",                     debeziumProperties.getDatabase().getPassword());
        p.setProperty("database.server.id",                    debeziumProperties.getDatabase().getServerId());
        p.setProperty("database.server.name",                  debeziumProperties.getDatabase().getServerName());
        p.setProperty("database.include.list",                 debeziumProperties.getDatabase().getIncludeList());
        p.setProperty("table.include.list",                    debeziumProperties.getTable().getIncludeList());
        p.setProperty("offset.storage",                        debeziumProperties.getOffset().getStorage());
        p.setProperty("offset.storage.file.filename",          debeziumProperties.getOffset().getStorageFileFilename());
        p.setProperty("offset.flush.interval.ms", String.valueOf(debeziumProperties.getOffset().getFlushIntervalMs()));
        p.setProperty("schema.history.internal",               debeziumProperties.getSchemaHistory().getInternal());
        p.setProperty("schema.history.internal.file.filename", debeziumProperties.getSchemaHistory().getInternalFileFilename());
        p.setProperty("topic.prefix",                          debeziumProperties.getTopic().getPrefix());
        return p;
    }


    @Bean
    public DebeziumEngine<ChangeEvent<String, String>> debeziumEngine(
            Properties debeziumEngineProperties,
            ProcessDatabaseEventService processDatabaseEventService) {

        return DebeziumEngine
                .create(KeyValueHeaderChangeEventFormat.of(Json.class, Json.class, Json.class),
                        "io.debezium.embedded.async.ConvertingAsyncEngineBuilderFactory")
                .using(debeziumEngineProperties)
                .notifying(record -> processDatabaseEventService.execute(record.value()))
                .build();
    }
}
