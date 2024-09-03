package com.web.projectplanner.a01_controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LanguageController {

    private final LocaleResolver localeResolver;

    public LanguageController(LocaleResolver localeResolver) {
        this.localeResolver = localeResolver;
    }

    @GetMapping("/sendMail")
    public String sendMail(@RequestParam(value = "lang", required = false) String lang, HttpServletRequest request, HttpServletResponse response) {
        if (lang != null) {
            Locale locale;
            switch (lang) {
                case "ko":
                    locale = new Locale.Builder().setLanguage("ko").build();
                    break;
                case "en":
                    locale = new Locale.Builder().setLanguage("en").build();
                    break;
                default:
                    locale = Locale.ENGLISH; // 기본값으로 설정할 언어
            }
            localeResolver.setLocale(request, response, locale);
        }
        return "z04_MailFrm"; // JSP 파일을 반환
    }
}