package filter;

import biz.StandardBiz;
import biz.bizimpl.StandardBizImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 25397 on 2016/12/24.
 */
@WebFilter(filterName = "Std_numFilter", urlPatterns = "/AddStandardServlet")
public class Std_numFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        StandardBiz standardBiz = new StandardBizImpl();
        String std_num = req.getParameter("std_num");
        if (null != standardBiz.getStandardByStd_num(std_num)) {
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("<script type=\"text/javascript\" >alert(\"标准号已存在\");history.back()</script> ");
            printWriter.flush();
            printWriter.close();

        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
