package com.bootssmserver.bootssmserver.configution;


import com.bootssmserver.bootssmserver.entity.IP;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.beanvalidation.LocaleContextMessageInterpolator;
import org.springframework.web.servlet.config.annotation.*;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebMvc
public class SpringConfigution  implements WebMvcConfigurer{
    /**
     * 使static中的静态对象可以被解析
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
        //上传的文件的虚拟映射                    //虚拟路径                                  //物理路径
        registry.addResourceHandler("/uploadfile/**").addResourceLocations("file:D:/ACG_Package/");//使用方式，例:http://localhost:8080/uploadfile/Videoface/JoTaRo.jpeg
        System.out.println("路径映射完毕");
    }
    @Bean("ip")
    public IP ip(){
        IP ip = new IP();
        return ip;
    }
}
