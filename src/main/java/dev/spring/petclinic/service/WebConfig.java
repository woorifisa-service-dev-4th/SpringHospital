package dev.spring.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private StringToPetTypeConverter stringToPetTypeConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringToPetTypeConverter);  // String을 PetType으로 변환하는 컨버터 등록
    }
}
