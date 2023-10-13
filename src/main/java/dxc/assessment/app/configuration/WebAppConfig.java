package dxc.assessment.app.configuration;
import dxc.assessment.app.interceptor.AuthorityInterceptor;
import dxc.assessment.app.interceptor.SecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebAppConfig implements WebMvcConfigurer {
    SecurityInterceptor securityInterceptor;
    AuthorityInterceptor authorityInterceptor;
    @Autowired
    public WebAppConfig(SecurityInterceptor securityInterceptor, AuthorityInterceptor authorityInterceptor) {
        this.securityInterceptor = securityInterceptor;
        this.authorityInterceptor = authorityInterceptor;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorityInterceptor)
                .addPathPatterns(
                        "/manager/*"
                ).order(Ordered.HIGHEST_PRECEDENCE);

        registry.addInterceptor(securityInterceptor)
                .addPathPatterns(
                        "/",
                        "/manager/*",
                        "/employee/*"
                );
    }
}