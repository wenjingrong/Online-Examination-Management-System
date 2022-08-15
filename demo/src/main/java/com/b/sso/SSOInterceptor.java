package com.b.sso;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SSOInterceptor implements HandlerInterceptor {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

            if(HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
                System.out.println("option请求，放行");//跨域时预检，判断实际发送的请求是否安全
                return true;
            }

            String token = request.getHeader("token");
            System.out.println("拦截器取得的token："+token);
            //token为空
            if (ObjectUtils.isEmpty(token)) {
                System.out.println("需要token");
                return false;
            }
            DecodedJWT decode = JWT.decode(token);
            String userid = decode.getClaim("userid").asString();
            //token不为空但缓存里不存在该token,无效或超时
            if (userid == null) {
                System.out.println("token无效或超时");
                return false;
            }
            return true;
        }
}
