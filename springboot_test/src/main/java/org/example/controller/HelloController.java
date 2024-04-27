package org.example.controller;

import org.example.pojo.Result;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping("/Hello")
    public Result hello(){
        System.out.println("Hello World ~");
        return Result.success("OK!");
    }

}