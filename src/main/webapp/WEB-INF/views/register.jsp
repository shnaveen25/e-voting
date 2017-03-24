<!-- Include Header -->
<%@ include file="../header/defaultHeader.txt" %>

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
			<form class="form-horizontal" role="form" action="processLogin"
				method="post">
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
					<label class="col-lg-3 col-sm-2 control-label"> Conform Email </label>
					<div class="col-lg-9">
						<input type="text" class="form-control" name="cnfEmail"
						placeholder="Re-Enter Email" title="Please Re-Enter your email" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 col-sm-2 control-label"> Mobile </label>
					<div class="col-lg-9">
						<input type="text" class="form-control" name="mobile"
						placeholder="Enter Mobile Number" title="Please enter your mobile number" />
					</div>
				</div>
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
				<div class="text-center">
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-8">
						<a href="register"> Back to Login </a> <br /> <br />
							<button type="submit" class="btn btn-danger">Submit</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	</main>
</div>

<!-- Include Footer -->
<%@ include file="../footer/defaultFooter.txt" %>