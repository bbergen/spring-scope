/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bryanbergen.services;

import java.util.Random;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

/**
 *
 * @author bryan
 */
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = BeanDefinition.SCOPE_PROTOTYPE)
public class DefaultService implements SimpleService {

    private final int serviceValue;

    public DefaultService() {
        serviceValue = new Random().nextInt();
    }

    @Override
    public int getServiceValue() {
        return serviceValue;
    }

}
