package com.example.configurations;

import com.example.constants.AppConstants;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "account")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema accountSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(AppConstants.PORT_TYPE_NAME);
        wsdl11Definition.setLocationUri(AppConstants.BASE_LOCATION);
        wsdl11Definition.setTargetNamespace(AppConstants.TARGET_NAMESPACE);
        wsdl11Definition.setSchema(accountSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema accountSchema() {
        return new SimpleXsdSchema(new ClassPathResource(AppConstants.CLASS_PATH_XSD));
    }

}
