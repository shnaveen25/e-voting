<!-- Header -->
<%@ include file="../../header/userHeader.txt"%>

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
		$('#changePassword').click(function(event) {
			event.preventDefault();
			console.log('Change password event called');
			$.ajax({
				url : 'processChangePassword',
				data : {
					oldPassword : $('#oldPass').val(),
					newPassword : $('#newPass').val()
				},
				success : function(responseText) {
					if(responseText == "success"){
						alert("Password has been changed");
						 $(window.location).attr('href', 'userHome');
					} else {
						alert(responseText);
					}
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
					<b>Change Password</b>
				</h4>
			</header>
			<form class="form-horizontal animate">

				<div class="form-group">
					<label class="col-lg-3 col-sm-2 control-label"> Old Password
					</label>
					<div class="col-lg-9">
						<input type="password" class="form-control" id="oldPass"
							placeholder="Enter Old Password"
							title="Please Enter Old Password" required />
					</div>
				</div>

				<div class="form-group">
					<label class="col-lg-3 col-sm-2 control-label"> New Password
					</label>
					<div class="col-lg-9">
						<input type="password" class="form-control" id="newPass"
							placeholder="Enter New Password" title="Please Enter New Password"
							required />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 col-sm-2 control-label"> Conform Password</label>
					<div class="col-lg-9">
						<input type="password" class="form-control"
							id="cnfPass" placeholder="Re-Enter Password"
							title="Enter Re-Enter Password"/>
					</div>
				</div>
				
				<div class="text-center">
						<div class="form-group">
							<div class="col-lg-offset-2 col-lg-8">
								<button type="submit" class="btn btn-danger" id="changePassword">SAVE</button>
							</div>
						</div>
					</div>

			</form>
		</div>
	</div>
	</main>
</div>





<!-- Footer -->
<%@ include file="../../footer/userFooter.txt"%>