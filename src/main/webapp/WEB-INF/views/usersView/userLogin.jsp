<%@page import="org.springframework.web.bind.annotation.RequestMapping"%>
<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Include Header -->
<%@ include file="../../header/defaultHeader.txt"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
		$('#getNewPassword').click(function() {
			console.log('Generation new password');
			$.ajax({
				url : 'forgotPassword',
				data : {
					email : $('#email').val()
				},
				success : function(responseText) {
					console.log(responseText);
					alert(responseText);
				}
			});
		});
	});
	
	$(document).ready(function() {
		$('#signIn').click(function(e) {
			e.preventDefault();
			console.log('User login is underprocess');
			$.ajax({
				url : 'processUserLogin',
				data : {
					email : $('#email').val(),
					password : $('#password').val()
				},
				success : function(responseText) {
					console.log(responseText);
					if(responseText ==  'success')
						//alert(responseText);
						$(window.location).attr('href', 'userHome');
					else
						alert(responseText);
				}
			});
		});
	});
</script>

<div class="wrapper row3">
	<main class="hoc container clear">
	<div class="sectiontitle">
		<div class="col-lg-15">
			<header class="panel-heading">
				<h4>
					<b>User Login</b>
				</h4>
			</header>
			<div class="panel-body"></div>
			<font color="Red"> ${errMsg}</font>
				<form class="form-horizontal">
					<div class="form-group">
						<label class="col-lg-2 col-sm-2 control-label"> Email </label>
						<div class="col-lg-9">
							<input type="email" class="form-control" id="email"
								placeholder="Enter Registered Email" required/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 col-sm-2 control-label"> Password </label>
						<div class="col-lg-9">
							<input type="password" class="form-control" id="password"
								placeholder="Password" required/>
						</div>
					</div>
					<div class="text-center">
						<div class="form-group">
							<div class="col-lg-offset-2 col-lg-8">
								<a style='cursor:pointer' data-toggle='modal' data-target='#changePassword'> Forgot Password ? </a> <br /> <a
									href="register"> New User? Create Login </a> <br /> <br />
								<button type="submit" class="btn btn-danger" id="signIn">Sign in</button>
							</div>
						</div>
					</div>
				</form>
		</div>
	</div>
	
	<!-- Modal -->
	<div id="changePassword" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Forgot password...?? </h4>
				</div>
				<div class="modal-body">
					<input type="email" class="form-control" name="email" id="email"
								placeholder="email" required/> <br /> 
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal" id="getNewPassword">SUBMIT</button>
				</div>
			</div>

		</div>
	</div>
	
	</main>
</div>

<!-- Include Footer -->
<%@ include file="../../footer/defaultFooter.txt"%>

</body>
</html>