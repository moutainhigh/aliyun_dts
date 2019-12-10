package com.pep.business;

import java.util.Map;

/**
 * 描述:
 *
 * @author zhangfz
 * @create 2019-09-02 11:07
 */
public class ConvertEntityConfig {
    private String from_db;
    private String from_table;
    private String to_entity;
    private Map<String, String> field_mapping;
    private Map<String, String> field_default;
    private String date_format;
    private Map<String, String> date2timestamp;
    private Map<String, String> field_copy;
    private String to_topic;
    private Boolean all_field_mapping;

    public String getFrom_db() {
        return from_db;
    }

    public void setFrom_db(String from_db) {
        this.from_db = from_db;
    }

    public String getFrom_table() {
        return from_table;
    }

    public void setFrom_table(String from_table) {
        this.from_table = from_table;
    }

    public String getTo_entity() {
        return to_entity;
    }

    public void setTo_entity(String to_entity) {
        this.to_entity = to_entity;
    }

    public Map<String, String> getField_mapping() {
        return field_mapping;
    }

    public void setField_mapping(Map<String, String> field_mapping) {
        this.field_mapping = field_mapping;
    }

    public Map<String, String> getField_default() {
        return field_default;
    }

    public void setField_default(Map<String, String> field_default) {
        this.field_default = field_default;
    }

    public String getDate_format() {
        return date_format;
    }

    public void setDate_format(String date_format) {
        this.date_format = date_format;
    }

    public Map<String, String> getDate2timestamp() {
        return date2timestamp;
    }

    public void setDate2timestamp(Map<String, String> date2timestamp) {
        this.date2timestamp = date2timestamp;
    }

    public Map<String, String> getField_copy() {
        return field_copy;
    }

    public void setField_copy(Map<String, String> field_copy) {
        this.field_copy = field_copy;
    }

    public String getTo_topic() {
        return to_topic;
    }

    public void setTo_topic(String to_topic) {
        this.to_topic = to_topic;
    }

    public Boolean getAll_field_mapping() {
        return all_field_mapping;
    }

    public void setAll_field_mapping(Boolean all_field_mapping) {
        this.all_field_mapping = all_field_mapping;
    }
}
