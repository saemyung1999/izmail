package com.izone.mailcrawling.web;

import com.izone.mailcrawling.service.MailService;
import com.izone.mailcrawling.service.crawling.MailCrawling;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MailController {

    private final MailService mailService;

    @GetMapping("/main")
    public String main() {
        return "mail/main";
    }

    @ResponseBody
    @GetMapping("/mailConfirm/{memberName}")
    public boolean mailConfirm(@PathVariable("memberName") String memberName) throws IOException {
        log.info("확인 중인 맴버: " + memberName);
        return mailService.isMailArrived(memberName);
    }
}
