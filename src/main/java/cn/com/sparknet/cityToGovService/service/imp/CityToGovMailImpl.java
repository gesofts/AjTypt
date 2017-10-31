package cn.com.sparknet.cityToGovService.service.imp;

import cn.com.gesoft.util.WsUtil;
import cn.com.sparknet.cityToGovService.service.CityToGovService;
import org.springframework.beans.factory.annotation.Value;

import javax.jws.WebParam;
import javax.jws.WebService;


/**
 * Created by WCL on 2017/10/30.
 */
@WebService(endpointInterface="cn.com.sparknet.cityToGovService.service.CityToGovService", serviceName="CityToGovSericeImpService" )
public class CityToGovMailImpl implements CityToGovService
{

    @Value("${ws.url}")
    private String url;

    /**
     * 2.3.1 办件快递推送接口
     * @param msg
     * @return
     */
    public String CityToGovMail(String msg)
    {
        String rs = WsUtil.HttpClientUtil(WsUtil.getCityToGovMailXml(msg), url);
        rs = rs.substring(rs.indexOf("<return>") + "<return>".length(), rs.lastIndexOf("</return>"));
        return rs;
    }


    /**
     * 2.3.2 物流信息获取接口
     * @param msg
     * @return
     */
    public String CityGetGovLogis(@WebParam(name = "arg0") String msg)
    {
        String rs = WsUtil.HttpClientUtil(WsUtil.getCityGetGovLogisXml(msg), url);
        rs = rs.substring(rs.indexOf("<return>") + "<return>".length(), rs.lastIndexOf("</return>"));
        return rs;
    }

}
