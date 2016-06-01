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
import javax.servlet.http.HttpSession;

import jp.co.opst.spring.bean.LoginInfo;

/**
 * Servlet Filter implementation class AuthorityControllFilter
 */
@WebFilter("/AuthorityControllFilter")
public class AuthorityControllFilter implements Filter {

    private String contextPath;

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        String requestURI = httpRequest.getRequestURI();

        HttpSession session = httpRequest.getSession();
        Object loginInfoObj = session.getAttribute("loginInfo") ;

        if (!mustCheckURI(requestURI)) {
            chain.doFilter(request, response);
        }

        if (loginInfoObj != null && LoginInfo.class.isInstance(loginInfoObj)) {
            LoginInfo info = (LoginInfo)loginInfoObj;
            String authority = info.getAuthority();

            if (incorrectAccess(requestURI, authority)) {
                httpResponse.sendRedirect(httpRequest.getContextPath());
            }
        }
        chain.doFilter(request, response);
    }

    private boolean incorrectAccess(String requestURI, String authority) {
        if (requestURI.contains("admin") && "admin".equals(authority)) {
            return false;
        }
        if (requestURI.contains("user") && "user".equals(authority)) {
            return false;
        }
        return true;
    }

    private boolean mustCheckURI(String requestURI) {
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
    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig config) throws ServletException {
        contextPath = config.getServletContext().getContextPath();
    }

}
