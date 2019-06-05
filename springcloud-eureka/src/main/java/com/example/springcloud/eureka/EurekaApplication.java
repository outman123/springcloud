package com.example.springcloud.eureka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
    public static void main(String[] args) {

        SpringApplication.run(EurekaApplication.class, args);
    }
}
//public class EurekaApplication extends WebSecurityConfigurerAdapter {
//    public static void main(String[] args) {
//
//        SpringApplication.run(EurekaApplication.class, args);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // Configure HttpSecurity as needed (e.g. enable http basic).
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
//        http.csrf().disable();
//        //注意：为了可以使用 http://${user}:${password}@${host}:${port}/eureka/ 这种方式登录,所以必须是httpBasic,
//        // 如果是form方式,不能使用url格式登录
//        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
//
//    }
//
//}