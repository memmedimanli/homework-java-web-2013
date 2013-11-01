/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FilterBeta;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author raminorujov
 */
public class LoginFilter implements Filter {
    
    
    private FilterConfig filterConfig = null;
    
    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        HttpSession session = req.getSession();
        
        Throwable problem = null;
        try {
            
            if(session.getAttribute("username") != null && 
                    session.getAttribute("loginTime") != null) {
                System.out.println("User " + session.getAttribute("username")  + " is logged in, continue processing.");
                chain.doFilter(request, response);
            } else {
                System.out.println("User is not logged in, redirect to login page.");
                res.sendRedirect("index.jsp");
            }
            
            
        } catch (Throwable t) {
            problem = t;
            t.printStackTrace();
        }
        
    }

    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void destroy() {        
    }

    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;    
    }
           
}
