package cn.pj.cts.aop;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 20:37 2019/2/19
 * @Modify By:
 **/

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"},filterName = "chara")
public class CharacterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init++++++++++");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        HttpServletResponse hr = (HttpServletResponse) response;
        hr.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8020");
        hr.setHeader("Access-Control-Allow-Credentials","true");
        hr.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE,PUT");
        hr.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        hr.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE,PUT");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("destory+++++++++++");
    }
}
