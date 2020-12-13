package com.izone.mailcrawling.service.crawling;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

@Slf4j
@Component
public class MailCrawling {

    public boolean checkMailByCrawlingWeb(String keyword) throws IOException {
        log.info("checkMailByCrawlingWeb start!");

        Date dDate = new Date();
        dDate = new Date(dDate.getTime()+(1000*60*60*24*-1));
        SimpleDateFormat dSdf = new SimpleDateFormat("yy.MM.dd", Locale.KOREA);
        String yesterday = dSdf.format(dDate);


        log.info("checkMailByCrawlingWeb start!");

        Loop1:
        for (int i = 1; i < 100; i++) {
            String url = "https://m.cafe.daum.net/official-izone/_rec?page="+i;
            Document document = Jsoup.connect(url).get();

            Elements mainElements = document.select("div#slideArticleList");
            Iterator<Element> listIterator = mainElements.select("li").iterator();

            Loop2:
            while (listIterator.hasNext()) {
                Element listInfo = listIterator.next();
                String title = listInfo.select("span.txt_detail").text();
                String date = listInfo.select("span.created_at").text();
                boolean roopBool = false;

                if (date.equals(yesterday)) {
                    log.info("탈출!!!");
                    break Loop1;
                }

                if (date.contains(":") && date.substring(0,1).equals("0")) {
                    if (Integer.parseInt(date.substring(1, 2)) < 9) {
                        roopBool = true;
                    }
                }

                if (title.contains(keyword) && !roopBool) {
                    log.info("메일 이미 보냄");
                    log.info("title: " + title);
                    log.info("date: " + date);
                    log.info("yesterday: " + yesterday);
                    return true;
                }
            }
        }
        return false;
    }

}