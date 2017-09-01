/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bryanbergen.services;

/**
 *
 * @author bryan
 */
public final class DefaultService implements SimpleService {

    private final int serviceValue;

    public DefaultService( int serviceValue ) {
        this.serviceValue = serviceValue;
    }

    @Override
    public int getServiceValue() {
        return serviceValue;
    }

}
