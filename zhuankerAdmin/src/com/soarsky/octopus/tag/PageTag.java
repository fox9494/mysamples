package com.soarsky.octopus.tag;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

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
    private int showNum = 20;// 显示链接数  
    private String css = "";  
    private String style = "";  
    
    /**
     * 用于javascript提交，并提交当前页码参数
     */
    private  final static String PARAM = "<input type=\"hidden\" id=\"currentPage\" name=\"currentPage\">" +  
    "<script type=\"text/javascript\">function do_page(p){document.getElementById(\"currentPage\").value=p;document.forms[0].submit();}</script>"; 
    
    
    @Override  
    public int doStartTag() throws JspException {  
  
        String html = "";  
        if (total > 0)  
            html = html();  
        else  
            html = "<div style=\"text-align:right;padding-top:5px;padding-right:5px;\">未找到数据</div>";  
  
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
          
        if (page != null && page.length() > 0){  
            this.currentPage= Integer.parseInt(page);  
        }  
        int totalPage = this.totalPage();  
        StringBuffer result = new StringBuffer();  
        if (css.trim().length() == 0 && this.style.trim().length() == 0){  
            result.append("<div style=\"text-align:right;padding-top:5px;padding-right:5px;\">");  
        }else{  
            result.append("<div class=\"" + css + "\" style=\""+ style +"\">");  
        }  
        result.append("<div class=\"" + css + "\" style=\""+ style +"\">");  
        result.append(PARAM);  
        result.append("搜索到"+ this.total + "/" + totalPage +"条记录: &nbsp;");  
        if (this.currentPage > 1){  
            result.append("<a href=\"javascript:do_page(1);\">首页</a> &nbsp;");  
            result.append("<a href=\"javascript:do_page(" + previousPage() + ");\">上页</a> &nbsp;");  
        }  
        String link = "&nbsp;<a href=\"javascript:do_page({0});\">{1}</a> &nbsp;";  
  
        List<Integer> list = new ArrayList<Integer>();  
        if (totalPage <= showNum) {  
            for (int i = 1; i <= totalPage; i++) {  
                list.add(i);  
            }  
        } else {  
            Integer left = 0, right = 0;  
            if(showNum % 2 == 0){  
                left = showNum / 2 - 1;  
                right = showNum / 2;  
            }else{  
                left = (showNum -1) / 2;  
                right = (showNum -1) / 2;  
            }  
              
            if (currentPage - left < 1) {  
                for (int i = 1; i <= showNum; i++) {  
                    list.add(i);  
                }  
            } else {  
                if (currentPage + right >= totalPage) {  
                    for (int i = totalPage - showNum + 1; i <= totalPage; i++) {  
                        list.add(i);  
                    }  
                } else {  
                    for (int i = currentPage - left; i <= currentPage + right; i++) {  
                        list.add(i);  
                    }  
                }  
            }  
        }  
  
        result.append("(");  
  
        MessageFormat fmt = new MessageFormat(link);  
        for (int i = 0; i < list.size(); i++) {  
            if (list.get(i) == currentPage) {  
                result.append("&nbsp;"+ list.get(i) +"&nbsp;");  
            } else {  
                Object [] p = {list.get(i), list.get(i)};  
                result.append(fmt.format(p));  
            }  
        }  
          
        result.append(")");  
        if (this.currentPage < totalPage){  
            result.append(" &nbsp;<a href=\"javascript:do_page(" + nextPage() + ");\">下页</a> &nbsp;");  
            result.append(" <a href=\"javascript:do_page(" + totalPage + ");\">末页</a> ");  
        }  
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
  
    public int getShowNum() {  
        return showNum;  
    }  
  
    public void setShowNum(int showNum) {  
        this.showNum = showNum;  
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


}
