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
public class AccessControllFilter implements Filter {

    private String contextPath;

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String requestURI = httpRequest.getRequestURI();

        HttpSession session = httpRequest.getSession();

        // DummyResponse dummy = new DummyResponse((HttpServletResponse)
        // response);
        System.out.println("requestURI-->" + requestURI);
        System.out.println("contextPath-->" + contextPath);
        if (avoidCheckURI(requestURI)) {
            chain.doFilter(request, response);
            return;
        }

        Object loginInfoObj = session.getAttribute("loginInfo");
        if (loginInfoObj == null) {
            // chain.doFilter(request, dummy);
            System.out.println("has not logged in");
            httpResponse.sendRedirect(httpRequest.getContextPath());
            return;
        }
        System.out.println("AuthorityFilter");
        if (!avoidCheckURI(requestURI) && LoginInfo.class.isInstance(loginInfoObj)) {
            LoginInfo info = (LoginInfo) loginInfoObj;
            String authority = info.getAuthority();

            if (incorrectAccess(requestURI, authority)) {
                // chain.doFilter(request, dummy);

                httpResponse.sendRedirect(httpRequest.getContextPath());
                return;
//                return;
//            } else {
//                chain.doFilter(request, response);
            }
//        } else {
        }
        chain.doFilter(request, response);
    }

    private boolean incorrectAccess(String requestURI, String authority) {
        if (requestURI.contains("admin") && "admin".equals(authority)) {
            System.out.println("logged in as admin");
            return false;
        }
        if (requestURI.contains("user") && "user".equals(authority)) {
            System.out.println("logged in as user");
            return false;
        }
        System.out.println("has not logged in");
        return true;
    }

    private boolean avoidCheckURI(String requestURI) {
        String loginURI = contextPath + "login.html";

        if (contextPath.equals(requestURI) || loginURI.equals(requestURI)) {
            return true;
//		} else if (requestURI.contains(".css") || requestURI.contains(".js")) {
//			return false;
//		} else if (!requestURI.contains(".html")) {
//			return false;
//             } else {
//             return true;
        }
        return false;
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig config) throws ServletException {
        contextPath = config.getServletContext().getContextPath() + "/";
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

}
