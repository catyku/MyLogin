package com.creations;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class JspFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
                HttpServletRequest request = ((HttpServletRequest)req);
        String uri = ((HttpServletRequest)request).getServletPath();
        // 只對html作用
        if (uri.equals("/")) {
            uri = "/index.html";
        }
        System.out.println("filter:"+uri);
         if (uri.lastIndexOf(".html")!=-1 && uri.lastIndexOf(".html") == (uri.length() - 5)) {
            if(uri.indexOf("welcome.html")>=0){
                //檢查是否登入成功
                if( request.getSession().getAttribute("user")!=null)
                {
                    request.setAttribute("title","啦啦啦!");
                    request.getRequestDispatcher(
                            "/welcome.jsp")
                            .forward(req, resp);
                }else{
                    ((HttpServletResponse) resp).setStatus(HttpServletResponse.SC_BAD_GATEWAY);
                    ((HttpServletResponse) resp).sendError(502);
                }
            }
            
         }
         chain.doFilter(req, resp);
        
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }
    
}
