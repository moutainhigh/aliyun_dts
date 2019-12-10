package com.pep.business.entity;

/**
 * @Description:订单详情对应JavaBean
 * @author:QZ
 * @date:2019/9/10 13:35
 */
public class OrderDetail {
    private String id;
    private String app_id;
    private String app_order_id;
    private String product_id;
    private String product_name;
    private String price;
    private String quantity;
    private String type;
    private String code;
    private String start_time;
    private String end_time;
    private String beans;
    private String materiel_code;
    private String materiel_name;
    private String row_timestamp ;
    private String row_status ;

    public String getRow_timestamp() {
        return row_timestamp;
    }

    public void setRow_timestamp(String row_timestamp) {
        this.row_timestamp = row_timestamp;
    }

    public String getRow_status() {
        return row_status;
    }

    public void setRow_status(String row_status) {
        this.row_status = row_status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getApp_order_id() {
        return app_order_id;
    }

    public void setApp_order_id(String app_order_id) {
        this.app_order_id = app_order_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getBeans() {
        return beans;
    }

    public void setBeans(String beans) {
        this.beans = beans;
    }

    public String getMateriel_code() {
        return materiel_code;
    }

    public void setMateriel_code(String materiel_code) {
        this.materiel_code = materiel_code;
    }

    public String getMateriel_name() {
        return materiel_name;
    }

    public void setMateriel_name(String materiel_name) {
        this.materiel_name = materiel_name;
    }
}
