package com.deveficiente.casadocodigo.shared;

import com.deveficiente.casadocodigo.domain.Carrinho;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Component
public class Cookies {


    public void writeAsJson(String key, Carrinho carrinho, HttpServletResponse response) {

        try {
            Cookie cookie = new Cookie(key, new ObjectMapper().writeValueAsString(carrinho));
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
