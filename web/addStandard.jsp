<%--
  Created by IntelliJ IDEA.
  User: 25397
  Date: 2016/12/22
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<form action="AddStandardServlet" method="post"  >
    标准号：<input type="text" id="std_num" name="std_num"/><br/>
    中文名称：<input type="text" id="zhname" name="zhname"/><br/>
    版本：<input type="text" id="version" name="version"/><br/>
    关键字：<input type="text" id="skeys" name="skeys"/><br/>
    发布日期(yyyy-MM-dd)： <input type="text" class="Wdate" id="release_date" name="release_date"
                             onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" size="21"
                             value="" /><br/>
    实施日期(yyyy-MM-dd)：<input type="text" class="Wdate" id="impl_date" name="impl_date"
                            onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" size="21"
                            value="" /><br/>
    附件：<input type="file" name="package_path"/><br/>
    <input type="submit" value="保存"/>&nbsp;
    <input type="reset" value="取消"/>
</form>
</body>
</html>
