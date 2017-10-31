package cn.com.gesoft.action;

import cn.com.gesoft.util.WsUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by WCL on 2017/10/30.
 */
@RestController
@RequestMapping("/wsdl")
public class WsdlController
{

    @Value("${ws.url}")
    private String wsUrl;

    /**
     * 传入WS格式内容
     * @param model
     * @return
     */
    @RequestMapping("/CityToGovMail")
    public String CityToGovMail(@RequestParam Map<String, Object> model)
    {
        return WsUtil.HttpClientUtil(model.get("content").toString(), wsUrl);
    }


    /**
     * 传入加密后的内容
     * @param model
     * @return
     */
    @RequestMapping("/CityToGovMailEncrypt")
    public String CityToGovMailEncrypt(@RequestParam Map<String, Object> model)
    {
        return WsUtil.HttpClientUtil(WsUtil.getCityToGovMailXml(model.get("content").toString()), wsUrl);
    }


    /**
     * 2.3.2 物流信息获取接口-加密后的完整数据
     * @param model
     * @return
     */
    @RequestMapping("/CityGetGovLogis")
    public String CityGetGovLogis(@RequestParam Map<String, Object> model)
    {
        return WsUtil.HttpClientUtil(model.get("content").toString(), wsUrl);
    }


    /**
     * 2.3.2 物流信息获取接口- 加密后的数据
     * @param model
     * @return
     */
    @RequestMapping("/CityGetGovLogisEncrypt")
    public String CityGetGovLogisEncrypt(@RequestParam Map<String, Object> model)
    {
        return WsUtil.HttpClientUtil(WsUtil.getCityGetGovLogisXml(model.get("content").toString()), wsUrl);
    }

}
