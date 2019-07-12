package com.okta.spring.springbootoauthclient

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

import java.security.Principal

@Controller
class WebController {

    @RequestMapping("securedPage")
    String securedPage(Model model, Principal principal) {
        return "securedPage"
    }

    @RequestMapping("/")
    String index(Model model, Principal principal) {
        "index"
    }
}
