package com.ivandanylov.movieland.config.yaml;

public class YamlTestSql {
    private String createTableSql;
    private String dropTableSql;
    private String insertSql;
    private String getAllSql;
    private String getRandomSql;

    public String getCreateTableSql() {
        return createTableSql;
    }

    public void setCreateTableSql(String createTableSql) {
        this.createTableSql = createTableSql;
    }

    public String getDropTableSql() {
        return dropTableSql;
    }

    public void setDropTableSql(String dropTableSql) {
        this.dropTableSql = dropTableSql;
    }

    public String getInsertSql() {
        return insertSql;
    }

    public void setInsertSql(String insertSql) {
        this.insertSql = insertSql;
    }

    public String getGetAllSql() {
        return getAllSql;
    }

    public void setGetAllSql(String getAllSql) {
        this.getAllSql = getAllSql;
    }

    public String getGetRandomSql() {
        return getRandomSql;
    }

    public void setGetRandomSql(String getRandomSql) {
        this.getRandomSql = getRandomSql;
    }

    @Override
    public String toString() {
        return "YamlTestSql{" +
                "createTableSql='" + createTableSql + '\'' +
                ", dropTableSql='" + dropTableSql + '\'' +
                ", insertSql='" + insertSql + '\'' +
                ", getAllSql='" + getAllSql + '\'' +
                ", getRandomSql='" + getRandomSql + '\'' +
                '}';
    }
}
