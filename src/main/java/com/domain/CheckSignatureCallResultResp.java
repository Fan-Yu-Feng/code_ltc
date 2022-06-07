package com.domain;

import java.util.Map;

/**
 * @author FYF @Description
 * @date 2022/5/19
 */
public class CheckSignatureCallResultResp {
  String status;
  String msg;

  String request_id;
  Map<String, String> data;

  public String getRequest_id() {
    return request_id;
  }

  public void setRequest_id(String request_id) {
    this.request_id = request_id;
  }

  public Map<String, String> getData() {
    return data;
  }

  public void setData(Map<String, String> data) {
    this.data = data;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
