package cn.com.gesoft.config;

import cn.com.sparknet.cityToGovService.service.CityToGovService;
import cn.com.sparknet.cityToGovService.service.imp.CityToGovMailImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Created by WCL on 2017/10/30.
 */
@Configuration
public class CxfConfig
{

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus()
    {
        return new SpringBus();
    }

    @Bean
    public CityToGovService cityToGovService()
    {
        return new CityToGovMailImpl();
    }

    @Bean
    public EndpointImpl cityToGovEndpoint(CityToGovService cityToGovService)
    {
        EndpointImpl endpoint = new EndpointImpl(springBus(), cityToGovService);
        endpoint.publish("/CityToGovService");
        return endpoint;
    }


    /**
     *  正常的http请求注册
     * @param dispatcherServlet
     * @return
     */
    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet)
    {
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
        registration.addUrlMappings("/ajtypt/*");
        return registration;
    }


    /**
     * cxf注册
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean()
    {
        return new ServletRegistrationBean(new CXFServlet(), "/onlineGovEMS/services/*");
    }
}
