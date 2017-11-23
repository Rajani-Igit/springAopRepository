package com.aroundadvicejamonweb.servlet;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.text.*;
import com.jamonapi.*;

@WebServlet("/jamonDemo")
public class JAMonDemo extends javax.servlet.http.HttpServlet {
   private static int active;
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException     {
        Monitor primary=MonitorFactory.startPrimary("JAMonDemo.pageHits");
        Monitor byDate=MonitorFactory.start("JAMonDemo.pageHits."+getDate());
        Monitor byUsersIP=MonitorFactory.start("JAMonDemo.pageHits."+
        getFormattedIP(request));
        active++;



        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();



        try {
            Thread.sleep(3000);
            out.println(getMusicians("Culture"));
            out.println(getMusicians("Maytals"));
            out.println(getMusicians("Wailers"));
        }
        catch(Exception e) {
            throw new ServletException(e.getMessage());
        }
        finally {
            byUsersIP.stop();
            byDate.stop();
            primary.stop();
            active--;
        }
        out.println(MonitorFactory.getReport());
    }



    // Returns date as a string in 05/10/02 format.
    private String getDate()     {
        return DateFormat.getDateInstance(DateFormat.SHORT).format(new Date());
    }



    /*
      Replace the standard "." separated ip address with one separated by dashes.
      i.e., 111.222.333.444 becomes 111-222-333-444.  This is done because "." has
      special meaning to the monitor class and will consume more resources.
      However this is not required.
     */
    private String getFormattedIP(HttpServletRequest request)     {
        String ip=request.getRemoteAddr();
        if (ip==null || "".equals(ip))
            return "";
        else
            return ip.replace('.', '-');
    }



    private String getMusicians(String group) throws Exception {
        Monitor mon=MonitorFactory.start("JAMonDemo.getMusicians("+group+")");
        final String culture="Joseph Hill, Albert Walker, Kenneth Dayes";
        final String maytals="Toots Hibbert, Raleigh Gordon, Jerry Matthias,"+
        " Jackie Jackson, Winston Wright, Hux Brown, Rad Bryan, "+
        "Paul Douglas, Winston Grennan";
        final String wailers="Bob Marley, Peter Tosh, Bunny Wailer, "+
        "Junior Braithwaite, Beverly Kelso";



        String musicians=null;
        if ("Culture".equals(group))
            musicians="<b>"+group+"</b>"+" - "+culture;
        else if ("Maytals".equals(group))
            musicians="<b>"+group+"</b>"+" - "+maytals;
        else if ("Wailers".equals(group))
            musicians="<b>"+group+"</b>"+" - "+wailers;



        Thread.sleep(active*50);
        mon.stop();
        return musicians;
    }
}