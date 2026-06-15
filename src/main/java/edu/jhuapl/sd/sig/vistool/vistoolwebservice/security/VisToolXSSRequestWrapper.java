package edu.jhuapl.sd.sig.vistool.vistoolwebservice.security;

import lombok.SneakyThrows;
import org.springframework.util.StreamUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.security.VisToolXSSUtils.stripXSS;

public class VisToolXSSRequestWrapper extends HttpServletRequestWrapper {

    private byte[] content;

    @SneakyThrows
    public VisToolXSSRequestWrapper(HttpServletRequest request) {
        super(request);
        InputStream requestInputStream = request.getInputStream();
        this.content = StreamUtils.copyToByteArray(requestInputStream);
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

	@Override
    public String[] getParameterValues(String parameter) {
        String[] values = super.getParameterValues(parameter);
        if (values == null) {
            return null;
        }
        int count = values.length;
        String[] encodedValues = new String[count];
        for (int i = 0; i < count; i++) {
            encodedValues[i] = stripXSS(values[i]);
        }
        return encodedValues;
    }

    @Override
    public String getParameter(String parameter) {
        return stripXSS(super.getParameter(parameter));
    }

	@Override
	public Enumeration getHeaders(String name) {
	    List result = new ArrayList<>();
	    Enumeration headers = super.getHeaders(name);
	    while (headers.hasMoreElements()) {
	        String header = (String) headers.nextElement();
	        String[] tokens = header.split(",");
	        for (String token : tokens) {
	            result.add(stripXSS(token));
	        }
	    }
	    return Collections.enumeration(result);
	}

	@Override
	public String getHeader(String name) {
        return stripXSS(super.getHeader(name));
    }

    @Override
    public String getQueryString() {
        return stripXSS(super.getQueryString());
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new WrappedServletInputStream(content);
    }

    @Override
    public BufferedReader getReader() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(content);
        return new BufferedReader(new InputStreamReader(byteArrayInputStream));
    }

    private class WrappedServletInputStream extends ServletInputStream {
        private InputStream inputStream;

        public WrappedServletInputStream(byte[] buffer) {
            inputStream = new ByteArrayInputStream(buffer);
        }

        @Override
        public int read() throws IOException {
            return inputStream.read();
        }

        @SneakyThrows
        @Override
        public boolean isFinished() {
            return inputStream.available() == 0;
        }

        @Override
        public boolean isReady() {
            return true;
        }

        @Override
        public void setReadListener(ReadListener readListener) {}
    }
}