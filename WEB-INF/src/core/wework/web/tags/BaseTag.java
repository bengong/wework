package wework.web.tags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.nutz.mvc.Mvcs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @since 0.1
 */
public class BaseTag extends TagSupport {

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6441649737849571253L;
	
	static final Logger log = LoggerFactory.getLogger(BaseTag.class);

    public BaseTag() {
    }

    protected Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    protected void verifyAttributes() throws JspException {
    }

    public int doStartTag() throws JspException {
    	HttpServletRequest request =  Mvcs.getReq(); 
    	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"; 
    	
    	try {
			pageContext.getOut().write(basePath);
		} catch (IOException e) {
			throw new JspTagException("Error writing [" + basePath + "] to JSP.", e);
		}

    	return SKIP_BODY;
    }
}
