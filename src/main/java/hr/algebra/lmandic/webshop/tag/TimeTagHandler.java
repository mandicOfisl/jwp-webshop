/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.lmandic.webshop.tag;

import java.io.IOException;
import java.util.Calendar;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author C
 */
public class TimeTagHandler extends TagSupport {
        
    @Override
    public int doStartTag() {
        JspWriter jw = pageContext.getOut();
        try {
            jw.print(Calendar.getInstance().getTime());
        } catch(IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
