/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bryanbergen.configuration;

import net.bryanbergen.services.DefaultService;
import net.bryanbergen.services.SimpleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.WebApplicationContext;
import java.util.HashMap;

/**
 *
 * @author bryan.bergen
 */
@Configuration
public class ServiceConfig {

    private static final String DETAILS_KEY = "details_key";

    @Bean
    @Scope( value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS )
    public SimpleService service() {
        int serviceValue = Integer.MAX_VALUE;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if ( auth.getDetails() instanceof HashMap<?, ?> ) {
            HashMap<String, String> details = (HashMap<String, String>) auth.getDetails();
            String value = details.get( DETAILS_KEY );
            serviceValue = Integer.parseInt( value );
        }
        return new DefaultService( serviceValue );
    }
}
