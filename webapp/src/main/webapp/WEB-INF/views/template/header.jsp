<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header">
	<div class="top-header">
		<div class="container">
			<div class="logo">
				<a href="index.html"><img src="<c:url value='/resources/images/logo.png' />"/></a>
			</div>
			<span class="menu"> </span>
			<div class="m-clear"></div>
			<div class="top-menu">
				<ul>
					<li class="active" <c:url value='/index'/> >START</li>
					<li><a class="scroll" href="<c:url value='/facilities' />" href="">FACILITIES</a></li>
					<li><a class="scroll" href="<c:url value='/booking' />">BOOKING</a></li>
					<li><a class="scroll" href="<c:url value='/contact' />">CONTACT US</a></li>
				</ul>
				<script>
					$("span.menu").click(function () {
						$(".top-menu ul").slideToggle(200);
					});
				</script>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="banner">
		<div class="banner-info text-center">
			<h3><label>Hello,</label> You've Reached</h3>
			<h1>HOTEL FORTUNE</h1>
			<span></span>
			<ul>
				<li><a class="scroll" href="#">HOTEL</a><i class="line"></i></li>
				<li><a class="scroll" href="#">SPA SALOON</a><i class="line2"></i></li>
				<li><a class="scroll" href="#">FINE DINING</a></li>
				<div class="clearfix"></div>
			</ul>
		</div>
	</div>
</div>