package com.patterns.dtos;

import java.util.List;

public class PayloadDataDTO<V> {
    private Schema schema;
    private Payload payload;

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public class Schema {
        private String type;
        private List<Field> fields;
        private boolean optional;
        private String name;
        private int version;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<Field> getFields() {
            return fields;
        }

        public void setFields(List<Field> fields) {
            this.fields = fields;
        }

        public boolean isOptional() {
            return optional;
        }

        public void setOptional(boolean optional) {
            this.optional = optional;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }
    }

    public class Field {
        private String type;
        private boolean optional;
        private String name;
        private int version;
        private Parameters parameters;
        private String field;
        private List<Field> fields;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public boolean isOptional() {
            return optional;
        }

        public void setOptional(boolean optional) {
            this.optional = optional;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public Parameters getParameters() {
            return parameters;
        }

        public void setParameters(Parameters parameters) {
            this.parameters = parameters;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public List<Field> getFields() {
            return fields;
        }

        public void setFields(List<Field> fields) {
            this.fields = fields;
        }
    }

    public class Parameters {
        private String allowed;

        public String getAllowed() {
            return allowed;
        }

        public void setAllowed(String allowed) {
            this.allowed = allowed;
        }
    }

    public class Payload {
        private V before;
        private V after;
        private Source source;
        private Transaction transaction;
        private String op;
        private Long tsMs;
        private Long tsUs;
        private Long tsNs;

        public V getBefore() {
            return before;
        }

        public void setBefore(V before) {
            this.before = before;
        }

        public V getAfter() {
            return after;
        }

        public void setAfter(V after) {
            this.after = after;
        }

        public Source getSource() {
            return source;
        }

        public void setSource(Source source) {
            this.source = source;
        }

        public Transaction getTransaction() {
            return transaction;
        }

        public void setTransaction(Transaction transaction) {
            this.transaction = transaction;
        }

        public String getOp() {
            return op;
        }

        public void setOp(String op) {
            this.op = op;
        }

        public Long getTsMs() {
            return tsMs;
        }

        public void setTsMs(Long tsMs) {
            this.tsMs = tsMs;
        }

        public Long getTsUs() {
            return tsUs;
        }

        public void setTsUs(Long tsUs) {
            this.tsUs = tsUs;
        }

        public Long getTsNs() {
            return tsNs;
        }

        public void setTsNs(Long tsNs) {
            this.tsNs = tsNs;
        }
    }

    public class Source {
        private String version;
        private String connector;
        private String name;
        private Long tsMs;
        private String snapshot;
        private String db;
        private String sequence;
        private Long tsUs;
        private Long tsNs;
        private String table;
        private Long serverId;
        private String gtid;
        private String file;
        private Long pos;
        private Integer row;
        private Long thread;
        private String query;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getConnector() {
            return connector;
        }

        public void setConnector(String connector) {
            this.connector = connector;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getTsMs() {
            return tsMs;
        }

        public void setTsMs(Long tsMs) {
            this.tsMs = tsMs;
        }

        public String getSnapshot() {
            return snapshot;
        }

        public void setSnapshot(String snapshot) {
            this.snapshot = snapshot;
        }

        public String getDb() {
            return db;
        }

        public void setDb(String db) {
            this.db = db;
        }

        public String getSequence() {
            return sequence;
        }

        public void setSequence(String sequence) {
            this.sequence = sequence;
        }

        public Long getTsUs() {
            return tsUs;
        }

        public void setTsUs(Long tsUs) {
            this.tsUs = tsUs;
        }

        public Long getTsNs() {
            return tsNs;
        }

        public void setTsNs(Long tsNs) {
            this.tsNs = tsNs;
        }

        public String getTable() {
            return table;
        }

        public void setTable(String table) {
            this.table = table;
        }

        public Long getServerId() {
            return serverId;
        }

        public void setServerId(Long serverId) {
            this.serverId = serverId;
        }

        public String getGtid() {
            return gtid;
        }

        public void setGtid(String gtid) {
            this.gtid = gtid;
        }

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public Long getPos() {
            return pos;
        }

        public void setPos(Long pos) {
            this.pos = pos;
        }

        public Integer getRow() {
            return row;
        }

        public void setRow(Integer row) {
            this.row = row;
        }

        public Long getThread() {
            return thread;
        }

        public void setThread(Long thread) {
            this.thread = thread;
        }

        public String getQuery() {
            return query;
        }

        public void setQuery(String query) {
            this.query = query;
        }
    }

    public class Transaction {
        private String id;
        private Long totalOrder;
        private Long dataCollectionOrder;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Long getTotalOrder() {
            return totalOrder;
        }

        public void setTotalOrder(Long totalOrder) {
            this.totalOrder = totalOrder;
        }

        public Long getDataCollectionOrder() {
            return dataCollectionOrder;
        }

        public void setDataCollectionOrder(Long dataCollectionOrder) {
            this.dataCollectionOrder = dataCollectionOrder;
        }
    }
}

