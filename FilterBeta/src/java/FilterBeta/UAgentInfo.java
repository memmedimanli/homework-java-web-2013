/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FilterBeta;

/**
 *
 * @author memmedimanli
 */
class UAgentInfo {
    
     private String userAgent = "";
     private String httpAccept = "";
     
     public static final String Iphone = "iPhone";
     public static final String Android = "Android";
        
                
    public UAgentInfo(String agent, String accept) {
         
        if(userAgent != null)
        {
            userAgent = agent;
        }
        
        if(httpAccept != null)
        {
            httpAccept = accept;
        }
        
    }
    
    public boolean detectIphone()
    {
       if(userAgent.indexOf(Iphone) > -1 )
       {
           return true;
       }else
       {
           return false;
       }
    }
    
    public boolean detectAndroid()
    {
        if(userAgent.indexOf(Android) > -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
 

}
