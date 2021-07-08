package com.neu.customermanagement.management.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xsb
 * @since 2021-07-07
 */
@RestController
@RequestMapping("/management/customer")
public class CustomerController {

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }

}

