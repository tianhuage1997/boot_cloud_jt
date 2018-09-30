//package  com.jt.web.config;
//
//
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Configuration
//public class CasConfig {
//
//    @Bean
//    public FilterRegistrationBean authenticationFilterRegistrationBean() {
//        FilterRegistrationBean authenticationFilter = new FilterRegistrationBean();
//        authenticationFilter.setFilter(new AuthenticationFilter());
//        Map<String, String> initParameters = new HashMap<String, String>();
//        initParameters.put("casServerLoginUrl", "http://localhost:8200/CAS/login");
//        initParameters.put("casServerUrlPrefix", "http://localhost:8200/cas");
//        initParameters.put("serverName", "http://localhost:8091/");
//        authenticationFilter.setInitParameters(initParameters);
//        authenticationFilter.setOrder(2);
//        List<String> urlPatterns = new ArrayList<String>();
//        urlPatterns.add("/*");// 设置匹配的url
//        authenticationFilter.setUrlPatterns(urlPatterns);
//        return authenticationFilter;
//    }
//
//    @Bean
//    public FilterRegistrationBean ValidationFilterRegistrationBean(){
//        FilterRegistrationBean authenticationFilter = new FilterRegistrationBean();
//        authenticationFilter.setFilter(new Cas20ProxyReceivingTicketValidationFilter());
//        Map<String, String> initParameters = new HashMap<String, String>();
//        initParameters.put("casServerUrlPrefix", "http://127.0.0.1");
//        initParameters.put("serverName", "http://192.26.4.28:8080");
//        authenticationFilter.setInitParameters(initParameters);
//        authenticationFilter.setOrder(1);
//        List<String> urlPatterns = new ArrayList<String>();
//        urlPatterns.add("/*");// 设置匹配的url
//        authenticationFilter.setUrlPatterns(urlPatterns);
//        return authenticationFilter;
//    }
//
//    @Bean
//    public FilterRegistrationBean casHttpServletRequestWrapperFilter(){
//        FilterRegistrationBean authenticationFilter = new FilterRegistrationBean();
//        authenticationFilter.setFilter(new HttpServletRequestWrapperFilter());
//        authenticationFilter.setOrder(3);
//        List<String> urlPatterns = new ArrayList<String>();
//        urlPatterns.add("/*");// 设置匹配的url
//        authenticationFilter.setUrlPatterns(urlPatterns);
//        return authenticationFilter;
//    }
//
//    @Bean
//    public FilterRegistrationBean casAssertionThreadLocalFilter(){
//        FilterRegistrationBean authenticationFilter = new FilterRegistrationBean();
//        authenticationFilter.setFilter(new AssertionThreadLocalFilter());
//        authenticationFilter.setOrder(4);
//        List<String> urlPatterns = new ArrayList<String>();
//        urlPatterns.add("/*");// 设置匹配的url
//        authenticationFilter.setUrlPatterns(urlPatterns);
//        return authenticationFilter;
//    }
//}