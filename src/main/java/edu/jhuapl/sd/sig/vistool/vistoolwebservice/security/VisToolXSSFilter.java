package edu.jhuapl.sd.sig.vistool.vistoolwebservice.security;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class VisToolXSSFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		VisToolXSSRequestWrapper visToolWrappedRequest = new VisToolXSSRequestWrapper((HttpServletRequest) request);
		String body = IOUtils.toString(visToolWrappedRequest.getReader());
		if(!StringUtils.isBlank(body)) {
			body = VisToolXSSUtils.stripXSS(body);
			visToolWrappedRequest.setContent(body.getBytes(StandardCharsets.UTF_8));
		}
		chain.doFilter(visToolWrappedRequest, response);
	}
}