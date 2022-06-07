import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.domain.CheckSignatureReq;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FYF @Description
 * @date 2022/5/19
 */
public class httpTest {

  @Test
  public void doPost() {
    CheckSignatureReq checkSignatureReq = new CheckSignatureReq();
    Map<String, String> map = new HashMap<>();
    map.put(
        "check_signature_path",
        "D:\\工作\\项目记录\\python验签\\fadada\\8d96dfd1d1604f80949ad658417ae4e6.pdf");
    map.put("check_signature_result_path", "D:\\工作\\项目记录\\python验签\\fadada\\结果.pdf");
    checkSignatureReq.setRequest_id("123123123");
    checkSignatureReq.setFb_no("xnb");
    checkSignatureReq.setSys_id("fyf");
    checkSignatureReq.setData(map);

    String url = "http://localhost:8890/api/check_signature";
    JSON json = JSONUtil.parse(checkSignatureReq);
    String result2 = HttpRequest.post(url).body(json.toString()).execute().body();
    System.out.println(result2);
  }
}
