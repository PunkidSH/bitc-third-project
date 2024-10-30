package bitc.fullstack405.finalprojectspringboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry reg) {
    reg.addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
        .allowedHeaders("*");
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    // 지정한 외부폴더를 스프링의 내부 폴더로 추가(행사 이미지)
    registry.addResourceHandler("/eventImg/**").addResourceLocations("file:/home/ec2user/eventImg/");

    // 지정한 외부폴더를 스프링의 내부 폴더로 추가(QR 코드 이미지)
    registry.addResourceHandler("/qrImg/**").addResourceLocations("file:/home/ec2-user/qrImg/");

    registry.addResourceHandler("/assets/**")
        .addResourceLocations("classpath:/static/assets/")
        .setCachePeriod(3600)
        .resourceChain(true)
        .addResolver(new PathResourceResolver());
  }
}
