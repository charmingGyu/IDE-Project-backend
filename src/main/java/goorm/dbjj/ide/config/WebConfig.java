package goorm.dbjj.ide.config;

import org.springframework.web.servlet.View;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;


@Configuration
public class WebConfig {
    @Bean
    public View jsonTemplate() {
        var view = new JsonView();

        return view;
    }

    @Bean
    public ViewResolver viewResolver() {
        var viewResolver = new BeanNameViewResolver();
        return new BeanNameViewResolver();
    }

}
