package hll.sunshinegirl.mvc.interceptor;

import hll.sunshinegirl.mvc.vo.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LoginInterceptor extends HandlerInterceptorAdapter{
    @Autowired
    private CurrentUser currentUser;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        if(session.getAttribute("uId")==null){
            return handle(request,response);
        }else{
            Integer uId = (Integer)session.getAttribute("uId");
            currentUser.setCurrentUser(uId);
            if(currentUser.currentUser() == null){
                return handle(request,response);
            }
        }
        return true;
    }

    private boolean handle(HttpServletRequest request,HttpServletResponse response) throws Exception{
        response.sendRedirect("/login");
        System.out.println("===front拦截下来！！！！===");
        return false;
    }
}
