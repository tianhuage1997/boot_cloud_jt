package eureka.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * jt-服务治理中心!
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaServer
public class EurekaCenterStart
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaCenterStart.class,args);
    }
//    @Bean
//    public EmbeddedServletContainerFactory servletContainer() {
//        TomcatEmbeddedServletContainerFactory factory =
//                new TomcatEmbeddedServletContainerFactory();
//        return factory;
//    }




}

