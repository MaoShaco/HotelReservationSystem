<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
    <title>Hotel Fortune a Hotel Category Flat Bootstrap Responsive Website Template | Home :: w3layouts</title>
    <link href='<c:url value="//fonts.googleapis.com/css?family=Open+Sans:600italic,700italic,800italic,400,300,600,700,800"/>'
          rel='stylesheet' type='text/css'>
    <link href='<c:url value="//fonts.googleapis.com/css?family=Pinyon+Script"/>' rel='stylesheet' type='text/css'>
    <link href='<c:url value="//fonts.googleapis.com/css?family=Quicksand:400,700"/>' rel='stylesheet' type='text/css'>
    <link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet" type="text/css" media="all"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <script src="<c:url value='/resources/js/jquery.min.js' />"></script>
</head>
<body>
<!--Header Page -->
<div>
    <div>
        <!-- Header -->
        <tiles:insertAttribute name="header"/>
    </div>

    <div >
        <tiles:insertAttribute name="fastlink"/>
    </div>

    <div>
        <tiles:insertAttribute name="body"/>
    </div>

    <div>
        <!-- Footer Page -->
        <tiles:insertAttribute name="footer"/>
    </div>

</div>

</body>
</html>