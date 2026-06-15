package edu.jhuapl.sd.sig.vistool.vistoolwebservice.security;

import org.apache.commons.text.StringEscapeUtils;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;

public class VisToolXSSUtils {

	private static final PolicyFactory SANITIZER = new HtmlPolicyBuilder().toFactory();

	public static String stripXSS(String value) {
		if (value == null) {
	        return null;
	    }
		return StringEscapeUtils.unescapeHtml4(SANITIZER.sanitize(value));
	}
}