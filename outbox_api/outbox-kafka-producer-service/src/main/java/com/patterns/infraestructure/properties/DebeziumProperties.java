package main.java.com.patterns.infraestructure.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "debezium")
public class DebeziumProperties {
    private String name;
    private String connectorClass;
    private String bootstrapServers;
    private DatabaseProperties database;
    private TableProperties table;
    private OffsetProperties offset;
    private SchemaHistoryProperties schemaHistory;
    private TopicProperties topic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConnectorClass() {
        return connectorClass;
    }

    public void setConnectorClass(String connectorClass) {
        this.connectorClass = connectorClass;
    }

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public DatabaseProperties getDatabase() {
        return database;
    }

    public void setDatabase(DatabaseProperties database) {
        this.database = database;
    }

    public TableProperties getTable() {
        return table;
    }

    public void setTable(TableProperties table) {
        this.table = table;
    }

    public OffsetProperties getOffset() {
        return offset;
    }

    public void setOffset(OffsetProperties offset) {
        this.offset = offset;
    }

    public SchemaHistoryProperties getSchemaHistory() {
        return schemaHistory;
    }

    public void setSchemaHistory(SchemaHistoryProperties schemaHistory) {
        this.schemaHistory = schemaHistory;
    }

    public TopicProperties getTopic() {
        return topic;
    }

    public void setTopic(TopicProperties topic) {
        this.topic = topic;
    }

    public static class DatabaseProperties {
        private String hostname;
        private Integer port;
        private String user;
        private String password;
        private Long serverId;
        private String serverName;
        private String includeList;

        public String getHostname() {
            return hostname;
        }

        public void setHostname(String hostname) {
            this.hostname = hostname;
        }

        public Integer getPort() {
            return port;
        }

        public void setPort(Integer port) {
            this.port = port;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Long getServerId() {
            return serverId;
        }

        public void setServerId(Long serverId) {
            this.serverId = serverId;
        }

        public String getServerName() {
            return serverName;
        }

        public void setServerName(String serverName) {
            this.serverName = serverName;
        }

        public String getIncludeList() {
            return includeList;
        }

        public void setIncludeList(String includeList) {
            this.includeList = includeList;
        }
    }

    public static class TableProperties {
        private String includeList;

        public String getIncludeList() {
            return includeList;
        }

        public void setIncludeList(String includeList) {
            this.includeList = includeList;
        }
    }

    public static class OffsetProperties {
        private String storage;
        private String storageFileFilename;
        private Integer flushIntervalMs;

        public String getStorage() {
            return storage;
        }

        public void setStorage(String storage) {
            this.storage = storage;
        }

        public String getStorageFileFilename() {
            return storageFileFilename;
        }

        public void setStorageFileFilename(String storageFileFilename) {
            this.storageFileFilename = storageFileFilename;
        }

        public Integer getFlushIntervalMs() {
            return flushIntervalMs;
        }

        public void setFlushIntervalMs(Integer flushIntervalMs) {
            this.flushIntervalMs = flushIntervalMs;
        }
    }

    public static class SchemaHistoryProperties {
        private String internal;
        private String internalFileFilename;

        public String getInternal() {
            return internal;
        }

        public void setInternal(String internal) {
            this.internal = internal;
        }

        public String getInternalFileFilename() {
            return internalFileFilename;
        }

        public void setInternalFileFilename(String internalFileFilename) {
            this.internalFileFilename = internalFileFilename;
        }
    }

    public static class TopicProperties {
        private String prefix;

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }
    }
}
