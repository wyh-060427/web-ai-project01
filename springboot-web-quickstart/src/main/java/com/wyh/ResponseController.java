package com.wyh;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws Exception {
        //1.设置响应状态码
        response.setStatus(401);

        //2.设置响应头
        response.setHeader("name","wyhhh");

        //3.设置响应体
        response.getWriter().write("<h1>hello world</h1>");
    }
}
