package com.domain;

import java.util.Map;

/**
 * @author FYF @Description
 * @date 2022/5/19
 */
public class CheckSignatureReq {
  String request_id;
  String sys_id;
  String fb_no;
  Map<String, String> data;

  public String getRequest_id() {
    return request_id;
  }

  public void setRequest_id(String request_id) {
    this.request_id = request_id;
  }

  public String getSys_id() {
    return sys_id;
  }

  public void setSys_id(String sys_id) {
    this.sys_id = sys_id;
  }

  public String getFb_no() {
    return fb_no;
  }

  public void setFb_no(String fb_no) {
    this.fb_no = fb_no;
  }

  public Map<String, String> getData() {
    return data;
  }

  public void setData(Map<String, String> data) {
    this.data = data;
  }
}
