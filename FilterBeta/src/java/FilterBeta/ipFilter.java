package FilterBeta;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.*;

/**
 *
 * @author memmedimanli
 */
public class ipFilter implements Filter {

    private String whiteList;
    private FilterConfig filterConfig = null;

    public ipFilter() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        
    

      //  String ipAddress = req.getHeader("X-FORWARDED-FOR");
       // ipAddress = request.getRemoteAddr();

        Throwable problem = null;
        try {
                
            if (request.getRemoteAddr().equals(this.whiteList)) {
                System.out.println("This is allowed ip.");
                chain.doFilter(request, response);
            } else {
                System.out.println("This is not allowed ip.");
                res.sendRedirect("bannedIP.jsp");

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

        this.whiteList = filterConfig.getInitParameter("whitelist");

    }
}
