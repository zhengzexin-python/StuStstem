package servlet;

import biz.StandardBiz;
import biz.bizimpl.StandardBizImpl;
import emtity.Standard;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

/**
 * Created by 25397 on 2016/12/22.
 */
@WebServlet(name = "UpdateServlet",urlPatterns = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String std_num=request.getParameter("std_num");
        String zhname=request.getParameter("zhname");
        String version=request.getParameter("version");
        String skeys=request.getParameter("skeys");
        Date release_date=Date.valueOf(request.getParameter("release_date"));
        Date impl_date=Date.valueOf(request.getParameter("impl_date"));
        String package_path=request.getParameter("package_path");
        Standard standard=new Standard(id,std_num,zhname,version,skeys,release_date,impl_date,package_path);
        StandardBiz standardBiz=new StandardBizImpl();
        int count=standardBiz.updateStandard(standard);
        if(count>0){
            response.sendRedirect("GetStandardByPageServlet");

        }else {
            PrintWriter printWriter=response.getWriter();
            printWriter.println("<script type=\"text/javascript\">alert(\"更新失败\");history.back()</script>\n");
            printWriter.flush();
            printWriter.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
