package foo.bar.day03.tp;


import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

@EnableWebMvc
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public FreeMarkerConfigurer freemarkerConfig() throws IOException, TemplateException {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("/WEB-INF/views/");
        configurer.setDefaultEncoding("UTF-8");
        configurer.setFreemarkerSettings(new Properties() {{
            this.put("default_encoding", "UTF-8");
            this.put("url_escaping_charset", "UTF-8");
        }});
        return configurer;
    }

    @Bean
    @Autowired
    public freemarker.template.Configuration freeMarkerConfiguration(
            FreeMarkerConfig configurer) {
        return configurer.getConfiguration();
    }

    @Bean
    public ViewResolver setupViewResolver() {
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
        viewResolver.setCache(false);
        viewResolver.setSuffix(".ftl");
        viewResolver.setPrefix("");
        viewResolver.setContentType("text/html;charset=UTF-8");
        viewResolver.setRequestContextAttribute("rc");
        return viewResolver;
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/").setViewName("hello");
    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        Properties mappings = new Properties();
        mappings.put(Exception.class, "/");

        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
        exceptionResolver.addStatusCode("/", HttpStatus.NOT_FOUND.value());
        exceptionResolver.setExceptionMappings(mappings);
        exceptionResolvers.add(exceptionResolver);
        super.configureHandlerExceptionResolvers(exceptionResolvers);
    }


}