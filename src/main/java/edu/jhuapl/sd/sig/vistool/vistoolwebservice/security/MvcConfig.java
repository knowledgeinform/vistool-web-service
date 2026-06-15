package edu.jhuapl.sd.sig.vistool.vistoolwebservice.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Value("${vistool.security.enabled}")
    private boolean vistoolSecurityEnabled;

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");

        if(vistoolSecurityEnabled) {
            registry.addViewController("/login").setViewName("login");
        }
    }
}
