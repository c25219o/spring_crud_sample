package jp.co.opst.spring.filter;

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

/**
 * Servlet Filter implementation class SessionControllFilter
 */
@WebFilter("/SessionControllFilter")
public class LoginControllFilter implements Filter {

    private static String contextPath;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String requestURI = httpRequest.getRequestURI();

        if (mustCheckURI(requestURI) && hasNotLoggedIn(httpRequest)) {
            httpResponse.sendRedirect(contextPath);
            return;
        }
        chain.doFilter(request, response);

    }

    private static boolean mustCheckURI(String requestURI) {
        String loginURI = contextPath + "login.html";

        if (contextPath.equals(requestURI) || loginURI.equals(requestURI)) {
            return false;
        } else if (requestURI.contains(".css") || requestURI.contains(".js")) {
            return false;
        } else if (!requestURI.contains(".html")) {
            return false;
//        } else {
//            return true;
        }
        return true;
    }

    private static boolean hasNotLoggedIn(HttpServletRequest httpRequest) {
        if (httpRequest.getSession().getAttribute("loginInfo") == null) {
            System.out.println("has not logged in -->" + httpRequest.getRequestURI());
            return true;
        } else {
            System.out.println("logged in -->" + httpRequest.getRequestURI());
            return false;
        }
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("LoginController#init()");
        contextPath = config.getServletContext().getContextPath() + "/";
        System.out.println(contextPath);
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }
}
