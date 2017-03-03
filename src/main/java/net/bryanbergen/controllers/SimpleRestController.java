/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bryanbergen.controllers;

import net.bryanbergen.services.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bryan
 */
@RestController
public class SimpleRestController {

    @Autowired
    private SimpleService service;

    @RequestMapping(path = "/simple", method = RequestMethod.GET)
    public void simpleEndpoint() {
        System.out.print("Simple Endpoint Reached - ");
        System.out.println("Service Value: " + service.getServiceValue());
    }

}
