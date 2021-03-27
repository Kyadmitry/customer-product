package app.smart.test_project.config;

import freemarker.template.TemplateModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.HashMap;
import java.util.Map;

@EnableWebMvc
@Configuration
public class FreeMarkerConfig extends WebMvcConfigurerAdapter {
    @Bean
    public Map<String, TemplateModel> freemarkerLayoutDirectives() {
        Map<String, TemplateModel> freemarkerLayoutDirectives = new HashMap<>();
        return freemarkerLayoutDirectives;
    }

    @Bean
    public FreeMarkerConfigurer freemarkerConfig() {
        FreeMarkerConfigurer freemarkerConfig = new FreeMarkerConfigurer();
        freemarkerConfig.setTemplateLoaderPath("classpath:/templates");
        freemarkerConfig.setDefaultEncoding("UTF-8");

        Map<String, Object> freemarkerVariables = new HashMap<>();
        freemarkerVariables.put("layout", freemarkerLayoutDirectives());

        freemarkerConfig.setFreemarkerVariables(freemarkerVariables);
        return freemarkerConfig;
    }

    @Bean
    public ViewResolver viewResolver() {
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
        viewResolver.setCache(false);
        viewResolver.setPrefix("");
        viewResolver.setSuffix(".ftl");
        viewResolver.setContentType("text/html; charset=utf-8");
        return viewResolver;
    }
}
