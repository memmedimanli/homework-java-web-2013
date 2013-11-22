
package FilterBeta;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

/**
 *
 * @author memmedimanli
 */

public class TimeFilter implements Filter {
    

    private FilterConfig filterConfig = null;
    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
          
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        
        PrintWriter out = response.getWriter();
        Throwable problem = null;
        try {
            String username = session.getAttribute("username").toString();
            
                        
            GregorianCalendar time = new GregorianCalendar();
             Date date = new Date();
             time.setTime(date);
             int hour = time.get(Calendar.HOUR_OF_DAY);
          
            
         
             if( hour >= 9 && hour <18 )
            {
                System.out.println("Hey, boos, you are in time.");
                chain.doFilter(request, response);
            }else {
                
                System.out.println("Please, work in work time -_- ");
                res.sendRedirect("outOfWork.jsp");
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

    
