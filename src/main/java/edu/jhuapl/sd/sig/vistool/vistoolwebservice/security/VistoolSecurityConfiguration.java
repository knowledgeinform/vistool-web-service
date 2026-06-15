package edu.jhuapl.sd.sig.vistool.vistoolwebservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
public class VistoolSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Value("${vistool.security.enabled}")
    private boolean vistoolSecurityEnabled;
    @Value("${vistool.security.cors.allowed.origin}")
    private String vistoolSecurityCORSAllowedOrigin;
    @Value("${vistool.svc-account-ldap.enabled}")
    private boolean ldapServiceAccountEnabled;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        if (vistoolSecurityEnabled) {
            httpSecurity
                    .cors().and()
                    .authorizeRequests()
                    .antMatchers("/admin")
                    .hasAuthority("ADMIN")
                    .anyRequest()
                    .fullyAuthenticated()
                    .and()
                    .exceptionHandling()
                    .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                    .and()
                    .formLogin()
                    .permitAll()
                    .loginProcessingUrl("/login")
                    .successHandler(new AuthSuccessHandler())
                    .failureHandler(new SimpleUrlAuthenticationFailureHandler())
                    .and()
                    .logout()
                    .permitAll()
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .logoutUrl("/logout")
                    .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.NO_CONTENT))
                    .and()
                    .csrf()
                    .ignoringAntMatchers("/login")
                    .csrfTokenRepository(getCsrfTokenRepository())
                    .and()
                    .headers()
                    .xssProtection()
                    .and()
                    .contentSecurityPolicy("script-src 'self'");
        } else {
            httpSecurity
                    .cors().and()
                    .authorizeRequests().anyRequest().permitAll()
                    .and().csrf().disable()
                    .headers().xssProtection().disable()
                    .and().logout().disable();
        }
    }

    private CsrfTokenRepository getCsrfTokenRepository() {
        CookieCsrfTokenRepository tokenRepository = CookieCsrfTokenRepository.withHttpOnlyFalse();
        tokenRepository.setCookiePath("/");
        return tokenRepository;
    }

    @Bean
    public VistoolUserDetailsContextMapper userDetailsContextMapper() {
        return new VistoolUserDetailsContextMapper();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        configuration.setAllowedOriginPatterns(Collections.singletonList(vistoolSecurityCORSAllowedOrigin));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        if (vistoolSecurityEnabled) {
            if (!ldapServiceAccountEnabled) {
                auth.ldapAuthentication()
                        .userSearchFilter("(UID={0})")
                        .userSearchBase("cn=users,dc=jhuapl,dc=edu")
                        .contextSource()
                        .url("ldaps://aplid.jhuapl.edu")
                        .port(636)
                        .and().userDetailsContextMapper(userDetailsContextMapper());
            }
        }
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
