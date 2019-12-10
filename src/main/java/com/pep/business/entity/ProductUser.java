package com.pep.business.entity;

/**
 * 描述:
 * 产品用户表
 *
 * @author zhangfz
 * @create 2019-08-27 9:22
 */
public class ProductUser {
    private String user_id;
    private String product_id;
    private String company;
    private String reg_name;//用户注册账号
    private String nick_name;//昵称
    private String real_name;//真实姓名
    private String phone;
    private String email;
    private String sex;
    private String birthday;
    private String address;
    private String org_id; //机构ID
    private String user_type; //用户类型 [A01-学生|A02-教师|A03-教育管理人员|A04-家长|A05-学龄前儿童|A06-未入学青少年|A07-不分年龄的人群]',
    private String first_access_time;
    private String last_access_time;
    private String last_access_ip;
    private String country;
    private String province;
    private String city;
    private String location;
    private String s_state;
    private String row_timestamp;
    private String row_status;

    public String getS_state() {
        return s_state;
    }

    public void setS_state(String s_state) {
        this.s_state = s_state;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getReg_name() {
        return reg_name;
    }

    public void setReg_name(String reg_name) {
        this.reg_name = reg_name;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrg_id() {
        return org_id;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getFirst_access_time() {
        return first_access_time;
    }

    public void setFirst_access_time(String first_access_time) {
        this.first_access_time = first_access_time;
    }

    public String getLast_access_time() {
        return last_access_time;
    }

    public void setLast_access_time(String last_access_time) {
        this.last_access_time = last_access_time;
    }

    public String getLast_access_ip() {
        return last_access_ip;
    }

    public void setLast_access_ip(String last_access_ip) {
        this.last_access_ip = last_access_ip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

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
}
