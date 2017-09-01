/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bryanbergen.configuration;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bryan
 */
@Component
public class SimpleHandlerInterceptor extends HandlerInterceptorAdapter {

    private static final String DETAILS_KEY = "details_key";

    @Override
    public boolean preHandle( HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception {
        System.out.println( "=== Before Call ===" );
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String test = request.getParameter( "test" );
        Map<String, String> details = new HashMap<>();
        details.put( DETAILS_KEY, test );
        if ( auth instanceof AbstractAuthenticationToken ) {
            ( (AbstractAuthenticationToken) auth ).setDetails( details );
        }
        return true;
    }

}
