<%@ taglib uri="http://www.springframework.org/tags/form" prefix="x"%>

<!-- Include Header -->
<%@ include file="../header/defaultHeader.txt" %>

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
			<x:form class="form-horizontal" action="processUserRegistration"
				modelAttribute="userDto">
				<div class="form-group">
					<label class="col-lg-3 col-sm-2 control-label"> Full Name </label>
					<div class="col-lg-9">
						<input type="text" class="form-control" name="name" 
						placeholder="Enter Full Name" title="Please Enter your official name"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 col-sm-2 control-label"> Email  </label>
					<div class="col-lg-9">
						<input type="text" class="form-control" name="email" 
						placeholder="Enter Email" title="Please Enter your email"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 col-sm-2 control-label"> Password </label>
					<div class="col-lg-9">
						<input type="password" class="form-control" name="password"
						placeholder="Enter Password" title="Please Enter Password" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 col-sm-2 control-label">Confirm Password </label>
					<div class="col-lg-9">
						<input type="password" class="form-control" name="cpassword"
						placeholder="Re-Enter Password" title="Please Re-Enter Password" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 col-sm-2 control-label"> Mobile </label>
					<div class="col-lg-9">
						<input type="text" class="form-control" name="mobile"
						placeholder="Enter Mobile Number" title="Please enter your mobile number" />
					</div>
				</div>
				<!-- 
				<div class="form-group">
					<label class="col-lg-3 col-sm-2 control-label"> State </label>
					<div class="col-lg-9">
						<select name="state" class="form-control">
						<option value=0>Select State</option>
							<option value="karnataka">Karanataka</option>
							<option value="maharastra">Maharastra</option>
							<option value="andhra">Andhra</option>
						</select>
					</div>
				</div>
				 -->
				<div class="text-center">
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-8">
						<a href="register"> Back to Login </a> <br /> <br />
							<button type="submit" class="btn btn-danger">Register</button>
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