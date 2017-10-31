package cn.com.sparknet.cityToGovService.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by WCL on 2017/10/30.
 */
@WebService
@SOAPBinding(style= SOAPBinding.Style.RPC, use= SOAPBinding.Use.LITERAL)
public interface CityToGovService
{
    /**
     * 2.3.1 办件快递推送接口
     * @param msg
     * @return
     */
    @WebMethod
    String CityToGovMail(@WebParam(name = "arg0") String msg);

    /**
     * 2.3.2 物流信息获取接口
     * @param msg
     * @return
     */
    String CityGetGovLogis(@WebParam(name = "arg0") String msg);
}
