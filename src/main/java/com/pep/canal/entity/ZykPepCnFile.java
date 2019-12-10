package com.pep.canal.entity;

/**
 * 描述:
 *
 * @author zhangfz
 * @create 2019-09-26 11:20
 */
public class ZykPepCnFile {
    private String file_md5;
    private String file_url;
    private String file_oname;
    private String file_name;
    private String file_extension;
    private String file_size;
    private String file_url_view;
    private String file_url_view_deal;
    private String file_transcoded;
    private String row_timestamp;
    private String row_status;

    public String getFile_md5() {
        return file_md5;
    }

    public void setFile_md5(String file_md5) {
        this.file_md5 = file_md5;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getFile_oname() {
        return file_oname;
    }

    public void setFile_oname(String file_oname) {
        this.file_oname = file_oname;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_extension() {
        return file_extension;
    }

    public void setFile_extension(String file_extension) {
        this.file_extension = file_extension;
    }

    public String getFile_size() {
        return file_size;
    }

    public void setFile_size(String file_size) {
        this.file_size = file_size;
    }

    public String getFile_url_view() {
        return file_url_view;
    }

    public void setFile_url_view(String file_url_view) {
        this.file_url_view = file_url_view;
    }

    public String getFile_url_view_deal() {
        return file_url_view_deal;
    }

    public void setFile_url_view_deal(String file_url_view_deal) {
        this.file_url_view_deal = file_url_view_deal;
    }

    public String getFile_transcoded() {
        return file_transcoded;
    }

    public void setFile_transcoded(String file_transcoded) {
        this.file_transcoded = file_transcoded;
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
