package com.xnote.client.core.filter;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.FormContentFilter;

@Component
public class PutFilter extends FormContentFilter
{
    /**
     * 解决PUT获取不到参数的问题
     * @return
     */
    @Bean
    public FormContentFilter formContentFilter()
    {
        return new FormContentFilter();
    }
}
