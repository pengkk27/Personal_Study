
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class ltp {
    // webapi接口地址
    private static final String WEBTTS_URL = "http://ltpapi.xfyun.cn/v1/ke";
    // 应用ID
    private static final String APPID = "";
    // 接口密钥
    private static final String API_KEY = "";
    // 文本
    private static final String TEXT = "这是以一个新的笔记，用来测试关键词识别功能。\r\n";


    private static final String TYPE = "dependent";

    private static List<String> keywordList;

    public static void main(String[] args) throws IOException {
        System.out.println(TEXT.length());
        Map<String, String> header = buildHttpHeader();
        keywordList = new ArrayList<>();
        String text = TEXT.replaceAll("(\r\n|\r|\n|\n\r)", "");
        String result = HttpUtil.doPost1(WEBTTS_URL, header, "text=" + URLEncoder.encode(text, "utf-8"));
        getKeywordList(result);
        System.out.println(keywordList.toString());
        for (String name : keywordList) {
            if (text.contains(name)) {
                text = text.replace(name, "*" + name + "*");
            }
        }
        System.out.println(text);
        String[] split = text.split("([。？！])");

        System.out.println("itp 接口调用结果：" + result);
    }

    private static void getKeywordList(String result) {
        JSONObject resultObject = JSON.parseObject(result);
        JSONObject data = resultObject.getJSONObject("data");
        JSONArray keArr = data.getJSONArray("ke");
        for (int i = 0; i < keArr.size(); i++) {
            JSONObject keArrObj = keArr.getJSONObject(i);
            String keyword = keArrObj.getString("word");
            if (keywordList.size() > 4) {
                break;
            }
            keywordList.add(keyword);
        }
    }

    /**
     * 组装http请求头
     */
    private static Map<String, String> buildHttpHeader() throws UnsupportedEncodingException {
        String curTime = System.currentTimeMillis() / 1000L + "";
        String param = "{\"type\":\"" + TYPE + "\"}";
        String paramBase64 = new String(Base64.encodeBase64(param.getBytes("UTF-8")));
        String checkSum = DigestUtils.md5Hex(API_KEY + curTime + paramBase64);
        Map<String, String> header = new HashMap<String, String>();
        header.put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        header.put("X-Param", paramBase64);
        header.put("X-CurTime", curTime);
        header.put("X-CheckSum", checkSum);
        header.put("X-Appid", APPID);
        return header;
    }
}
