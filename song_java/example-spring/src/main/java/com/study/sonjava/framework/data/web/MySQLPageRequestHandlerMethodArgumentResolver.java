package com.study.sonjava.framework.data.web;

import javax.servlet.http.HttpServletRequest;

import com.study.sonjava.framework.data.domain.MySQLPageRequest;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**
 * MySQL 쿼리 페이징 LIMIT, OFFSET 값을 자동 계산하여 MysqlPageRequest 클래스 담아서 컨트롤러에서 받을 수 있게 함.
 */
@Slf4j
public class MySQLPageRequestHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private static final String DEFAULT_PARAMETER_PAGE = "page";
    private static final String DEFAULT_PARAMETER_SIZE = "size";
    private static final int DEFAULT_SIZE = 20;

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest)webRequest.getNativeRequest();
        // 현재 페이지
        int page = NumberUtils.toInt(request.getParameter(DEFAULT_PARAMETER_PAGE), 1);
        // 리스트 갯수
        int offset = NumberUtils.toInt(request.getParameter(DEFAULT_PARAMETER_SIZE), DEFAULT_SIZE);
        // 시작지점
        int limit = (offset * page) - offset;
        log.info("page : {}", page);
        log.info("limit : {}, offset : {}", limit, offset);

        return new MySQLPageRequest(page, offset, limit, offset);
    }
    
    @Override
    public boolean supportsParameter(MethodParameter methodParameter){
        return MySQLPageRequest.class.isAssignableFrom(methodParameter.getParameterType());
    }


    
}
