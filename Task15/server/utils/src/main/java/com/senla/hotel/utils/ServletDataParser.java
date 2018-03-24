/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.utils;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class ServletDataParser {

    public String createWebToken(String name, String password) {
        Map<String, Object> tokenData = new HashMap<>();
        tokenData.put(Constants.LOGIN, name);
        tokenData.put(Constants.PASSWORD, password);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 100);
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setExpiration(calendar.getTime());
        jwtBuilder.setClaims(tokenData);
        String key = Constants.KEY;
        String token = jwtBuilder.signWith(SignatureAlgorithm.HS512, key).compact();
        return token;
    }

    public JSONObject getJsonObjectFromReques(HttpServletRequest request) throws IOException {
        StringBuilder sb = new StringBuilder();
        String str;
        try (BufferedReader br = request.getReader()) {
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            return new JSONObject(sb.toString());
        }
    }

    public void createResponse(HttpServletResponse response, List data) throws IOException {
        JSONArray arr = new JSONArray(data);
        response.s
        try (PrintWriter out = response.getWriter()) {
            out.print(arr);
        }
    }

}
