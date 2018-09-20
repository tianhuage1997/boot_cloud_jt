package eureka.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * jt-服务治理中心!
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaCenterStart
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaCenterStart.class,args);
    }
}
