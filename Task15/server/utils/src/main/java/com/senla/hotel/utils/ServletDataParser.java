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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

public class ServletDataParser {

    private JSONObject json;

    public Object getDataFronJson(String name) {
        return json.get(name);
    }

    public String getInformation(HttpServletRequest request) {
        return request.getMethod() + " " + request.getServletPath();
    }

    public String createWebToken(String name, String password) {
        Map<String, Object> tokenData = new HashMap<>();
        tokenData.put("userPassword", name);
        tokenData.put("username", password);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 100);
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setExpiration(calendar.getTime());
        jwtBuilder.setClaims(tokenData);
        String key = "abc123";
        String token = jwtBuilder.signWith(SignatureAlgorithm.HS512, key).compact();
        return token;
    }

    public void getJsonObjectFromReques(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        String str;
        try (BufferedReader br = request.getReader()) {
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            json = new JSONObject(sb.toString());
        } catch (IOException ex) {
            Logger.getLogger(ServletDataParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createResponse(HttpServletResponse response, String data) throws IOException {
        String[] arr = data.split("/");
        try (PrintWriter out = response.getWriter()) {
            if (arr.length >= 1) {
                for (String arr1 : arr) {
                    out.write(arr1);
                    out.write("\n");
                }
            } else {
                out.print(data);
            }
            out.flush();
        }
    }

}
