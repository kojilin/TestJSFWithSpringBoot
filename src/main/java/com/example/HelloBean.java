package com.example;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("view")
public class HelloBean implements Serializable {

    private static final long serialVersionUID = 802244980861003453L;
    @Autowired
    Module module;

    private String name = "okkk";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void welcome() {
        name += module.welcome();
    }

}
