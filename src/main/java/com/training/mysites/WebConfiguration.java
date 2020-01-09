package com.training.mysites;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    /**
     * 把拦截器作为Bean让Spring管理，以防止Spring无法找到拦截器
     * @return
     */
    @Bean
    public CheckUserIntercepter checkUserIntercepter() {
        return new CheckUserIntercepter();
    }
    @Bean
    public Utils utils() {
        return new Utils();
    }

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(checkUserIntercepter());
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new Formatter<LocalDate>() {
            /**
             *日期转换成字符串
             * @param object 日期数据
             * @param locale 本地化数据
             * @return
             */
            @Override
            public String print(LocalDate object, Locale locale) {
                //定义一个格式化器对象
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd", locale);
                //调用格式化器的对象，将日期转换成字符串
                return dtf.format(object);
            }

            /**
             * 字符串转换成日期
             * @param text   格式为：2019-01-02的字符串
             * @param locale 本地化
             * @return 日期
             * @throws ParseException 如果提供的text格式不正确则抛出异常
             */
            @Override
            public LocalDate parse(String text, Locale locale) throws ParseException {
                return LocalDate.parse(text);   //调用parse方法把字符串解析为日期对象
            }
        });
        WebMvcConfigurer.super.addFormatters(registry);
    }
}
