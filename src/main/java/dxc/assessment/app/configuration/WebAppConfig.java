package dxc.assessment.app.configuration;
import dxc.assessment.app.interceptor.SecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebAppConfig implements WebMvcConfigurer {
    SecurityInterceptor securityInterceptor;
    @Autowired
    public WebAppConfig(SecurityInterceptor securityInterceptor) {
        this.securityInterceptor = securityInterceptor;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(securityInterceptor)
//                .addPathPatterns(
//                        "/",
//                        "/manager/*",
//                        "/employee/*"
//                )
        ;
    }
}