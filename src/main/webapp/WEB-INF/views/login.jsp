<!-- Include Header -->
<%@ include file="../header/defaultHeader.txt"%>

<div class="wrapper row3">
	<main class="hoc container clear">
	<div class="sectiontitle">
		<div class="col-lg-15">
			<header class="panel-heading">
				<h4>
					<b>Login</b>
				</h4>
			</header>
			<div class="panel-body"></div>
			<font color="Red"> ${errMsg}</font>
			<form class="form-horizontal" role="form" action="processLogin"
				method="post">
				<div class="form-group">
					<label class="col-lg-2 col-sm-2 control-label"> Email </label>
					<div class="col-lg-9">
						<input type="text" class="form-control" name="email" 
						placeholder="Enter Registered Email"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2 col-sm-2 control-label"> Password </label>
					<div class="col-lg-9">
						<input type="password" class="form-control" name="password"
							placeholder="Password" />
					</div>
				</div>
				<div class="text-center">
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-8">
							<a href="#/hr/forgotPassword"> Forgot Password ? </a> <br />
							<a href="register"> New User? Create Login </a> <br /> <br />
							<button type="submit" class="btn btn-danger">Sign in</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	</main>
</div>

<!-- Include Footer -->
<%@ include file="../footer/defaultFooter.txt"%>