package com.pep.business.entity;

/**
 * @Description:订单信息对应JavaBean
 * @author:QZ
 * @date:2019/9/10 13:34
 */
public class OrderInfo {
    private String id;
    private String app_id;
    private String app_order_id;
    private String user_id;
    private String user_name;
    private String sale_channel_id;
    private String sale_channel_name;
    private String s_state;
    private String s_create_time;
    private String s_delete_time;
    private String order_price;
    private String discount;
    private String pay_channel;
    private String pay_time;
    private String pay_price;
    private String pay_tradeno;
    private String remark;
    private String beans;
    private String bean_type;
    private String coupons;
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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getSale_channel_id() {
        return sale_channel_id;
    }

    public void setSale_channel_id(String sale_channel_id) {
        this.sale_channel_id = sale_channel_id;
    }

    public String getSale_channel_name() {
        return sale_channel_name;
    }

    public void setSale_channel_name(String sale_channel_name) {
        this.sale_channel_name = sale_channel_name;
    }

    public String getS_state() {
        return s_state;
    }

    public void setS_state(String s_state) {
        this.s_state = s_state;
    }

    public String getS_create_time() {
        return s_create_time;
    }

    public void setS_create_time(String s_create_time) {
        this.s_create_time = s_create_time;
    }

    public String getS_delete_time() {
        return s_delete_time;
    }

    public void setS_delete_time(String s_delete_time) {
        this.s_delete_time = s_delete_time;
    }

    public String getOrder_price() {
        return order_price;
    }

    public void setOrder_price(String order_price) {
        this.order_price = order_price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPay_channel() {
        return pay_channel;
    }

    public void setPay_channel(String pay_channel) {
        this.pay_channel = pay_channel;
    }

    public String getPay_time() {
        return pay_time;
    }

    public void setPay_time(String pay_time) {
        this.pay_time = pay_time;
    }

    public String getPay_price() {
        return pay_price;
    }

    public void setPay_price(String pay_price) {
        this.pay_price = pay_price;
    }

    public String getPay_tradeno() {
        return pay_tradeno;
    }

    public void setPay_tradeno(String pay_tradeno) {
        this.pay_tradeno = pay_tradeno;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBeans() {
        return beans;
    }

    public void setBeans(String beans) {
        this.beans = beans;
    }

    public String getBean_type() {
        return bean_type;
    }

    public void setBean_type(String bean_type) {
        this.bean_type = bean_type;
    }

    public String getCoupons() {
        return coupons;
    }

    public void setCoupons(String coupons) {
        this.coupons = coupons;
    }
}
