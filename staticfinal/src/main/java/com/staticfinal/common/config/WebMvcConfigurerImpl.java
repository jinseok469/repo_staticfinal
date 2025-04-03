package com.staticfinal.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.staticfinal.common.interceptor.CheckLoginSessionInterceptor;

@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer{
	 @Override
	    public void addInterceptors(InterceptorRegistry registry) {
			registry.addInterceptor(new CheckLoginSessionInterceptor())
//					.order(1)
					.addPathPatterns("/*Xdm*","/*Usr*")
					.excludePathPatterns(
//							"/resources/**",
							"/userUsrUpdt",
							"/userUsrInst",
							"/indexUsrView",
							"/signupUsrForm",
							"/signinUsrProc",
							"/signinUsrForm",
							"/signinXdmForm",
							"/signinXdmProc",
							"/blogXdmInst",
							"/blogXdmUpdt",
							"/codeXdmForm",
							"/codeXdmUpdt",
							"/codeXdmUele",
							"/codeXdmInst",
							"/codeGroupXdmInst",
							"/codeGroupXdmUpdt",
							"/codeGroupXdmUele",
							"/userXdmUpdt",
							"/userXdmInst",
							"/userXdmUele",
							"/codyXdmInst",
							"/codyXdmUpdt",
							"/codyXdmUele"
			);
		}
}
