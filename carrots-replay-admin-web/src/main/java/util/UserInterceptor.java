package util;


import com.qding.common.util.http.cookie.CookieUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class UserInterceptor extends HandlerInterceptorAdapter {

    private static final Log log = LogFactory.getLog(UserInterceptor.class);
    private static final String excelName = "customer_statics_"+System.currentTimeMillis()+".csv";


    @Autowired
    private CookieUtil cookieUtil;



    public static Map getUserIdentity(String userName, Long userId) {
        Map map = new HashMap();
        map.put(CookieUtil.USER_NAME, userName);
        map.put(CookieUtil.USER_ID, userId);
        return map;
    }

    private boolean noPermission(HttpServletResponse response,HttpServletRequest request)  {
        log.info("sssssssssssss");
        log.info("ddddddddd   " + request.getRequestURI());


       RequestDispatcher rd =  request.getRequestDispatcher("/r/json/noPermission.json");
       try {
		rd.forward(request,response);
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       // response.sendRedirect("/noPermissin");


        return false;

    }

    private boolean noLogin(HttpServletResponse response,HttpServletRequest request) throws IOException {

      log.info(" manager don't login");

        RequestDispatcher rd =  request.getRequestDispatcher("/r/json/noLogin.json");
        try {
            rd.forward(request,response);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // response.sendRedirect("/noPermissin");


        return false;

    }
//
   
//
    /**
     * 获取跳转链接的地址
     *
     */
    public String getInterceptorUrl(HttpServletRequest request) {

        String interceptorUrl = request.getRequestURI()
                + (null == request.getQueryString() ? "" : "?"
                + request.getQueryString()).toString();
        interceptorUrl = interceptorUrl.replace("/app/", "/");

        log.info("get getInterceptorUrl is " + interceptorUrl);

        return interceptorUrl;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {

        String x = URLEncoder.encode("p/hello", "utf-8");
        log.info(x);

    }
}
