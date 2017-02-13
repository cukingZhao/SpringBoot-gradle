package com.cuking.web

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by cuking on 2017/1/18.
 */
@RestController
class Hello {

    @RequestMapping("/a")
    def hello(){
        return  "sdk current"
    }
}
