package com.izone.mailcrawling.service;

import com.izone.mailcrawling.service.crawling.MailCrawling;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class MailService {

    private final MailCrawling mailCrawling;

    public boolean isMailArrived(String memberName) throws IOException {

        boolean isMailArrived = false;

        if (memberName.equals("권은비")) {
            isMailArrived = mailCrawling.checkMailByCrawlingWeb("긍프메");
        } else if (memberName.equals("사쿠라")) {
            isMailArrived = mailCrawling.checkMailByCrawlingWeb("샄프메");
        } else if (memberName.equals("강혜원")) {
            isMailArrived = mailCrawling.checkMailByCrawlingWeb("광프메");
        } else if (memberName.equals("최예나")) {
            isMailArrived = mailCrawling.checkMailByCrawlingWeb("옌프메");
        } else if (memberName.equals("이채연")) {
            isMailArrived = mailCrawling.checkMailByCrawlingWeb("깃프메");
        } else if (memberName.equals("김채원")) {
            isMailArrived = mailCrawling.checkMailByCrawlingWeb("쌈프메");
        } else if (memberName.equals("김민주")) {
            isMailArrived = mailCrawling.checkMailByCrawlingWeb("밍프메");
        } else if (memberName.equals("나코")) {
            isMailArrived = mailCrawling.checkMailByCrawlingWeb("낰프메");
        } else if (memberName.equals("히토미")) {
            isMailArrived = mailCrawling.checkMailByCrawlingWeb("히프메");
        } else if (memberName.equals("조유리")) {
            isMailArrived = mailCrawling.checkMailByCrawlingWeb("율프메");
        } else if (memberName.equals("안유진")) {
            isMailArrived = mailCrawling.checkMailByCrawlingWeb("댕프메");
        } else if (memberName.equals("장원영")) {
            isMailArrived = mailCrawling.checkMailByCrawlingWeb("녕프메");
        }

        return isMailArrived;
    }
}
