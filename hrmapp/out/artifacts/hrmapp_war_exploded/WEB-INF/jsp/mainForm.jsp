<%--
  Created by IntelliJ IDEA.
  User: charles
  Date: 2017/10/22
  Time: 下午2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>人事管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="${ctx}/fkjava.ico" rel="shortcut icon" type="image/x-icon" />
    <link href="${ctx}/css/css.css" type="text/css" rel="stylesheet" />
</head>
<body>
<frameset rows="80,*" cols="*" frameborder="no" border="0" framespacing="0">
    <frame src="${ctx}/top" name="title" scrolling="no" noresize="noresize" >
    <frameset cols="220,*" frameborder="no" border="0" framespacing="0">
        <frame src="${ctx}/left" name="tree" scrolling="no" marginheight="0" marginwidth="0">
        <frame src="${ctx}/right" name="main" scrolling="yes" frameborder="0" marginwidth="0" marginheight="0" noresize="noresize">
    </frameset>
</frameset></body>
</html>
