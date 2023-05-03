package com.pessoas.api.utils;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



@Component
public class UrlUtils {
    public URI getCreatedLocation(Long id) {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String requestUri = StringUtils.defaultString(httpServletRequest.getRequestURI());
        StringBuilder sb = new StringBuilder();

        sb.append(requestUri);

        if (!StringUtils.endsWith(requestUri, "/")) {
            sb.append("/");
        }

        sb.append(id);

        return URI.create(sb.toString());
    }
}
