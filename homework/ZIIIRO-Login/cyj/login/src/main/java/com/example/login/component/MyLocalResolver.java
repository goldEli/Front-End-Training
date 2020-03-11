package com.example.login.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


public class MyLocalResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
       String lang = httpServletRequest.getParameter("l");
       Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(lang)){
            String[] S = lang.split("_");
            locale = new Locale(S[0],S[1]);
       }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
