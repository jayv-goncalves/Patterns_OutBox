package com.patterns.ports.in.services;

public interface ProcessDatabaseEventService {
    void execute(String event);
}
