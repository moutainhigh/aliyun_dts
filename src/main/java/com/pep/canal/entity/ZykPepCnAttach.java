package com.pep.canal.entity;

/**
 * 描述:
 *
 * @author zhangfz
 * @create 2019-09-26 11:21
 */
public class ZykPepCnAttach {
    private String attach_id;
    private String rid;
    private String file_md5;
    private String row_timestamp;
    private String row_status;

    public String getAttach_id() {
        return attach_id;
    }

    public void setAttach_id(String attach_id) {
        this.attach_id = attach_id;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getFile_md5() {
        return file_md5;
    }

    public void setFile_md5(String file_md5) {
        this.file_md5 = file_md5;
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
