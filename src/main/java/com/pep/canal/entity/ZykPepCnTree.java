package com.pep.canal.entity;

/**
 * 描述:
 * 资源库目录树
 *
 * @author zhangfz
 * @create 2019-09-29 15:43
 */
public class ZykPepCnTree {
    private String tid;
    private String tname;
    private String tcode;
    private String parent_id;
    private String tree_type;
    private String cid;
    private String corder;
    private String chapter_id;
    private String row_timestamp;
    private String row_status;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTcode() {
        return tcode;
    }

    public void setTcode(String tcode) {
        this.tcode = tcode;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getTree_type() {
        return tree_type;
    }

    public void setTree_type(String tree_type) {
        this.tree_type = tree_type;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCorder() {
        return corder;
    }

    public void setCorder(String corder) {
        this.corder = corder;
    }

    public String getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(String chapter_id) {
        this.chapter_id = chapter_id;
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
