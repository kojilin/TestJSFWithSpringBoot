package com.example;

import org.springframework.stereotype.Component;

@Component
public class Module {

    public String welcome() {
        return "from module!";
    }

}
