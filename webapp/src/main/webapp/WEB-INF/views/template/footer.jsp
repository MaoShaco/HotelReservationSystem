<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!---->
<div class="footer">
	<div class="container">
		<h3 ><i class="fa fa-lock"></i>143 City Located Hotels WorldWide</h3>
		<h4>"Hospitality, Quality & Good Locations. We only provide you with the best hotels" - John Deo</h4>
		<i class="man"></i>
	</div>
</div>
<!---->
<div class="footer-info">
	<div class="container">
		<div class="col-md-5 details">
			<div class="hotel-info">
				<h4>ABOUT THIS HOTEL</h4>
				<p>Suspendisse erat mi, tincidunt sit amet massa quis, commodo fermentum diam. Sed nec dui nec nunc
					tempor interdum.</p>
				<p>Ut vulputate augue urna, ut porta dolor imperdiet a. Vestibulum nec leo eu magna aliquam ornare.</p>
			</div>
			<div class="news">
				<h4>LATEST NEWS</h4>
				<h5>Grand Hotel Joins Deluxe Hotels</h5>
				<a href="#">15 AUG</a>
				<h5>Happy Christmas To Everyone</h5>
				<a href="#">15 AUG</a>
				<h5>Best Places To Visit 2014</h5>
				<a href="#">15 AUG</a>
				<h5>Various Offers</h5>
				<a href="#">15 AUG</a>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="col-md-7 details">
			<div class="join">
				<h4>JOIN DELUXE HOTELS</h4>
				<p>Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus
					vestibulum blandit egestas.
					Nam id lectus vel orci luctus consectetur eget id elit. In tortor odio, pellentesque eu arcu sit
					amet, lacinia euismod nisi. Aliquam sodales tristique mauris ac fermentum.
					Donec vel varius ipsum. Pellentesque vitae mollis massa. </p>
				<p>There is no costs or whatsoever so sign up today!</p>
				<a href="#">READ MORE</a>
			</div>
			<div class="member">
				<h4>MEMBERS AREA</h4>
				<c:url var="loginUrl" value="/login" />
				<form action="${loginUrl}" method="post" class="form-horizontal">
					<c:if test="${param.error != null}">
						<div class="alert alert-danger">
							<p>Invalid username and password.</p>
						</div>
					</c:if>
					<c:if test="${param.logout != null}">
						<div class="alert alert-success">
							<p>You have been logged out successfully.</p>
						</div>
					</c:if>
					<div class="input-group input-sm">
						<label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
						<input type="text" class="form-control" id="username" name="ssoId" placeholder="Enter Username" required>
					</div>
					<div class="input-group input-sm">
						<label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label>
						<input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
					</div>
					<div class="input-group input-sm">
						<div class="checkbox">
							<label class="text-muted" ><input type="checkbox"  id="rememberme" name="remember-me"> Remember Me</label>
						</div>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						   value="${_csrf.token}" />

					<div class="form-actions">
						<input type="submit"
							   class="btn btn-block btn-primary btn-default" value="LOG IN">
					</div>
				</form>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<!---->