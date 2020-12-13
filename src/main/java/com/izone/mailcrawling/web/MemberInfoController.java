package com.izone.mailcrawling.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MemberInfoController {

    @GetMapping("/memberInfo/{memberName}")
    public String memberInfoPage(@PathVariable("memberName") String memberName) {
        return "memberInfo/" + memberName;
    }
}
