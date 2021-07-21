package com.neu.customermanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    /**
     * token服务配置
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenServices(tokenServices());
    }

    /**
     * 路由安全认证配置
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 客户新增（权限：客户经理，销售总监）
                .antMatchers(HttpMethod.POST,"/cusManagement/customer/addCustomers").hasAnyRole("30000010","30000030")
                // 客户修改（权限：客户经理，销售总监，营销专员）
                .antMatchers(HttpMethod.POST,"/cusManagement/customer/updateCustomers").hasAnyRole("30000010","30000030")
                // 客户冻结（权限：营销专员）
                .antMatchers(HttpMethod.POST,"/cusManagement/customer/frozenCustomer").hasRole("20000020")
                // 导出客户信息（权限：营销副总，营销专员）
                .antMatchers(HttpMethod.GET,"/cusManagement/customer/export").hasAnyRole("20000010","20000020")
                // 客户移交（权限：营销专员）
                .antMatchers(HttpMethod.POST,"/cusManagement/handoverlog/**").hasRole("20000020")
                .anyRequest().authenticated();
    }

    /**
     * jwt token 校验解析器
     */
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    /**
     * Token转换器必须与认证服务一致
     */
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        accessTokenConverter.setSigningKey("YoCiyy");
        return accessTokenConverter;
    }

    /**
     * 资源服务令牌解析服务
     */
    @Bean
    @Primary
    public ResourceServerTokenServices tokenServices() {
        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
        remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:15000/oauth/check_token");
        remoteTokenServices.setClientId("client_1");
        remoteTokenServices.setClientSecret("123456");
        return remoteTokenServices;
    }
}
