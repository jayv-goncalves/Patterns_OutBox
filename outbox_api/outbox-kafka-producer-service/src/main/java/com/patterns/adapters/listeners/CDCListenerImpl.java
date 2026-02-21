package com.patterns.adapters.listeners;

import com.patterns.ports.out.listeners.DatabaseListener;
import io.debezium.engine.ChangeEvent;
import io.debezium.engine.DebeziumEngine;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class CDCListenerImpl implements DatabaseListener {

    private final DebeziumEngine<ChangeEvent<String, String>> debeziumEngine;

    public CDCListenerImpl(DebeziumEngine<ChangeEvent<String, String>> debeziumEngine) {
        this.debeziumEngine = debeziumEngine;
    }

    @Override
    @PostConstruct
    public void listenDatabase() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(debeziumEngine);
    }
}
