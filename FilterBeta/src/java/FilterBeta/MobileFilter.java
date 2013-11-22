/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FilterBeta;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author memmedimanli
 */
public class MobileFilter implements Filter {
    
 
    private FilterConfig filterConfig = null;
    
    public MobileFilter() {
    }    
    
   
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
           HttpServletRequest req = (HttpServletRequest) request;
           HttpServletResponse res = (HttpServletResponse) response;
           HttpSession session = req.getSession();
           
        Throwable problem = null;
        try {
            
            String agent = req.getHeader("User-Agent");
            String accept = req.getHeader("Accept");
                    
            UAgentInfo detect = new UAgentInfo(agent, accept);
            
           if (detect.detectAndroid() || detect.detectIphone())
            {
               RequestDispatcher rd = session.getServletContext().getRequestDispatcher("/mobile.jsp");
               rd.forward(request, response);
            }
            else
            {
                RequestDispatcher rd = session.getServletContext().getRequestDispatcher("/desktop.jsp");
                rd.forward(request, response);
            } 
            chain.doFilter(request, response);
        } catch (Throwable t) {
            // If an exception is thrown somewhere down the filter chain,
            // we still want to execute our after processing, and then
            // rethrow the problem after that.
            problem = t;
            t.printStackTrace();
        }
        
    }
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

   
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        
        }
    }

   