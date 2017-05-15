<%@ taglib uri="http://www.springframework.org/tags/form" prefix="x"%>

<!-- Include Header -->
<%@ include file="../header/defaultHeader.txt" %>


<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
		$('#register').click(function(e) {
			e.preventDefault();
			console.log('Registering user');
			var data = {
					name : $('#name').val(),
					email : $('#email').val(),
					password : $('#password').val(),
					mobile : $('#mobile').val()
			};
			console.log("FormData " , data);
			$.ajax({
				url : 'processUserRegistration',
				data : JSON.stringify(data),
				type : 'POST',
				headers : {
					'Content-Type' : 'application/json'
				},
				success : function(responseText) {
					console.log(responseText);
					if(responseText ==  'success'){
						alert("Registration success..Please Login")
						$(window.location).attr('href', 'userLogin');
					}
					else
						alert(responseText);
				}
			});
		});
	});
</script>



<!-- Body -->
<div class="wrapper row3">
	<main class="hoc container clear">
	<div class="sectiontitle">
		<div class="col-lg-15">
			<header class="panel-heading">
				<h4>
					<b>Create Login</b>
				</h4>
			</header>
			<font color="Red"> ${errMsg}</font>
			<x:form class="form-horizontal">
				<div class="form-group">
					<label class="col-lg-3 col-sm-2 control-label"> Full Name </label>
					<div class="col-lg-9">
						<input type="text" class="form-control" id="name" 
						placeholder="Enter Full Name" title="Please Enter your official name" required/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 col-sm-2 control-label"> Email  </label>
					<div class="col-lg-9">
						<input type="email" class="form-control" id="email" 
						placeholder="Enter Email" title="Please Enter your email" required/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 col-sm-2 control-label"> Password </label>
					<div class="col-lg-9">
						<input type="password" class="form-control" id="password"
						placeholder="Enter Password" title="Please Enter Password" required/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 col-sm-2 control-label">Confirm Password </label>
					<div class="col-lg-9">
						<input type="password" class="form-control" name="cpassword"
						placeholder="Re-Enter Password" title="Please Re-Enter Password" required/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 col-sm-2 control-label"> Mobile </label>
					<div class="col-lg-9">
						<input type="text" class="form-control" id="mobile"
						placeholder="Enter Mobile Number" title="Please enter your mobile number" max="10" min="10" required/>
					</div>
				</div>
				<div class="text-center">
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-8">
						<a href="register"> Back to Login </a> <br /> <br />
							<button type="submit" class="btn btn-danger" id="register">Register</button>
							<input type="reset" class="btn btn-danger" value="Clear"/>
						</div>
					</div>
				</div>
			</x:form>
		</div>
	</div>
	</main>
</div>

<!-- Include Footer -->
<%@ include file="../footer/defaultFooter.txt" %>