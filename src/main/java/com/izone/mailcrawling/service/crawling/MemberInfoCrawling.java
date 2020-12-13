package com.izone.mailcrawling.service.crawling;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MemberInfoCrawling {

    public static void main(String[] args) throws IOException {
        memberInfoCrawling("미야와키%20사쿠라");
    }


    public static void memberInfoCrawling(String memberCode) throws IOException {
        String url = "https://namu.wiki/w/" + memberCode;
        Document document = Jsoup.connect(url).get();

        Elements memberInfoElements = document.select("div.table-right table.wiki-table");
        String name = memberInfoElements.select("tr:nth-child(1) div.wiki-paragraph div span.wiki-size:nth-child(3) span.wiki-color strong").text();
        String img = memberInfoElements.select("tr:nth-child(2) span.wiki-image-wrapper img.wiki-image").attr("data-src");
        String birthDate = memberInfoElements.select("tr:nth-child(4) td:nth-child(2) div.wiki-paragraph").text().split("일")[0] + "일";
        String age = memberInfoElements.select("tr:nth-child(4) td:nth-child(2) div.wiki-paragraph").text().split("세")[0].substring(memberInfoElements.select("tr:nth-child(4) td:nth-child(2) div.wiki-paragraph").text().split("세")[0].length() - 2) + "세";
        String bloodType = memberInfoElements.select("tr:nth-child(11) td:nth-child(2) div.wiki-paragraph a:nth-child(2)").text();
        if (!(bloodType.equals("A형") || bloodType.equals("B형") || bloodType.equals("AB형") || bloodType.equals("O형"))) {
            bloodType = memberInfoElements.select("tr:nth-child(12) td:nth-child(2) div.wiki-paragraph a:nth-child(2)").text();
        }

        System.out.println("name = " + name);
        System.out.println("img = " + img);
        System.out.println("birthDate = " + birthDate);
        System.out.println("age = " + age);
        System.out.println("bloodType = " + bloodType);
    }
}
