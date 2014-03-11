package com.openframe.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * 用于页面显示分页html
 * @author chenll
 */
public class PageTag extends TagSupport {

	private static final long serialVersionUID = 6477804646329151954L;
	
	Logger log = Logger.getLogger(PageTag.class);  
	
	private int total;// 总记录数  
    private int currentPage = 1;// 当前页  
    private int pageSize = 10;// 每页显示信息数  
    private String css = "";  
    private String style = "";  
    private int showNum = 20;// 显示链接数  
    
    /**
     * 用于javascript提交，并提交当前页码参数
     */
    private  final static String PARAM = "<input type=\"hidden\" id=\"currentPage\" name=\"currentPage\">" +  
    "<script type=\"text/javascript\">function do_page(p){document.getElementById(\"currentPage\").value=p; if(!(/^[0-9]*[1-9][0-9]*$/.test(p))){Boteng.DialogBox.message(\"选择的页码必须是整数并且大于0\"); return;} document.forms[0].submit();}</script>"; 
    
    
    @Override  
    public int doStartTag() throws JspException {  
  
        String html = "";  
        if (total > 0)  
            html = html();  
        else  
            html = "<div style=\"text-align:center;padding-top:5px;padding-right:5px;\">未找到数据</div>";  
  
        try {  
            this.pageContext.getOut().print(html);  
        } catch (IOException e) {  
            log.error(e.getMessage());  
            e.printStackTrace();  
        }  
        return super.doStartTag();  
    }  
  
    private String html() {  
          
        String page = this.pageContext.getRequest().getParameter("currentPage");  
        
        log.debug("currentPage:"+ page);  
          
        if (StringUtils.isNotBlank(page)){  
            this.currentPage= Integer.parseInt(page);  
        }
        int totalPage = this.totalPage();  
        StringBuffer result = new StringBuffer();  
        if (css.trim().length() == 0 && this.style.trim().length() == 0){  
            result.append("<div style=\"text-align:center;padding-top:5px;padding-right:5px;\">");  
        }else{  
            result.append("<div class=\"" + css + "\" style=\""+ style +"\">");  
        }  
        result.append("<div class=\"" + css + "\" style=\""+ style +"\">");  
        result.append(PARAM);  
        result.append("<a href=\"javascript:do_page(1);\">首页</a> &nbsp;");  
        result.append("<a href=\"javascript:do_page(" + previousPage() + ");\">上一页</a> &nbsp;");  
        result.append(" &nbsp;<a href=\"javascript:do_page(" + nextPage() + ");\">下一页</a> &nbsp;");  
        result.append(" <a href=\"javascript:do_page(" + totalPage + ");\">尾页</a> ");  
        result.append("一共有"+ this.total +"条记录 &nbsp;");
        result.append("共"+ this.totalPage() +"页&nbsp;");
        result.append("当前是第"+this.currentPage+"页&nbsp;");
        result.append("转到<input type=\"text\"  style=\"width:35px; text-align: center;\" onblur=\"this.value=this.value.replace(/[^\\d\\.]+/g,'')\" "
							+"		onafterpaste=\"this.value=this.value.replace(/[^\\d\\.]+/g,'')\" id=\"pagenum\"/>&nbsp;页"
						 +"<input type=\"button\" value=\"go\" onclick=\"do_page(document.getElementById('pagenum').value)\" />");
  
        result.append("</div>");  
        return result.toString();  
    }  
  
    private int previousPage() {  
        if (this.currentPage == 1) {  
            return 1;  
        } else {  
            return this.currentPage - 1;  
        }  
    }  
  
    private int nextPage() {  
        if (this.currentPage == totalPage()) {  
            return totalPage();  
        } else {  
            return this.currentPage + 1;  
        }  
    }  
  
    private int totalPage() {  
        if (this.total <= this.pageSize){  
          return 1;  
        }  
        if (this.total % this.pageSize == 0) {  
            return this.total / this.pageSize;  
        } else {  
            return this.total / this.pageSize + 1;  
        }  
    }  
  
    public int getTotal() {  
        return total;  
    }  
  
    public void setTotal(int total) {  
        this.total = total;  
    }  
  
    public int getPageSize() {  
        return pageSize;  
    }  
  
    public void setPageSize(int pageSize) {  
        this.pageSize = pageSize;  
    }  
  
    public String getCss() {  
        return css;  
    }  
  
    public void setCss(String css) {  
        this.css = css;  
    }  
  
  
    public String getStyle() {  
        return style;  
    }  
  
    public void setStyle(String style) {  
        this.style = style;  
    }

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getShowNum() {
		return showNum;
	}

	public void setShowNum(int showNum) {
		this.showNum = showNum;
	}  


}
