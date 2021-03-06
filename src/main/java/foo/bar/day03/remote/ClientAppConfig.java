package foo.bar.day03.remote;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

/**
 * Created by ainurminibaev on 08.04.15.
 */
@Configuration
@Order(2)
public class ClientAppConfig {

    @Bean
    @DependsOn("accountService")
    public SimpleObject simpleObject(AccountService accountService) {
        SimpleObject simpleObject = new SimpleObject();
        simpleObject.setAccountService(accountService);
        return simpleObject;
    }

    @Bean
    public RmiProxyFactoryBean accountService() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:1199/AccountService");
        rmiProxyFactoryBean.setServiceInterface(AccountService.class);
        rmiProxyFactoryBean.setLookupStubOnStartup(false);
        rmiProxyFactoryBean.setRefreshStubOnConnectFailure(true);
        rmiProxyFactoryBean.afterPropertiesSet();

        return rmiProxyFactoryBean;
    }
}
