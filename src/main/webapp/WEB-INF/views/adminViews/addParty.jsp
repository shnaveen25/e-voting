<%@ taglib uri="http://www.springframework.org/tags/form" prefix="x"%>
<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<%@ include file="../../header/adminHeader.txt"%>


<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
		$('#addParty').click(function(e) {
			e.preventDefault();
			console.log('Adding party');
			var data = {
				partyName : $('#partyName').val(),
				partyEmail : $('#partyEmail').val(),
				partyDescription : $('#partyDescription').val()
			}
			console.log("FormData", data);
			$.ajax({
				url : 'addPartyDescription',
				data : JSON.stringify(data),
				type : 'POST',
				headers : {
					'Accept' : 'application/json',
					'Content-Type' : 'application/json'
				},
				success : function(responseText) {
					console.log("Response from Success",responseText);
					alert(responseText.responseText);
					$(window.location).attr('href', 'adminHome');
				},
				error : function(responseText) {
					console.log("Response from failur",responseText);
					alert(responseText.responseText);
					window.location.reload();
				}
				
			});
		});
	});
</script>


<!-- Body -->
<div class="wrapper row3">
	<br />
	<div class="sectiontitle">
		<div class="col-lg-15">
			<header class="panel-heading">
				<h4>
					<b>Add Party</b>
				</h4>
			</header>
			<form class="form-horizontal animate">

				<div class="form-group">
					<label class="col-lg-3 col-sm-2 control-label"> Party Name
					</label>
					<div class="col-lg-9">
						<input type="text" class="form-control" id="partyName"
							placeholder="Enter Party Name"
							title="Please enter name of the party" required />
							<font color="red">Note: Two parties cannot have same name</font>
					</div>
				</div>

				<div class="form-group">
					<label class="col-lg-3 col-sm-2 control-label"> Party Email
					</label>
					<div class="col-lg-9">
						<input type="email" class="form-control" id="partyEmail"
							placeholder="Enter party email" title="Please enter party email"
							required />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 col-sm-2 control-label"> Party
						Description </label>
					<div class="col-lg-9">
						<textarea rows="4" cols="50" class="form-control"
							id="partyDescription" placeholder="Enter party description"
							title="Enter party description"></textarea>
					</div>
				</div>
				<div class="text-center">
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-8">
							<button type="submit" class="btn btn-danger" id="addParty">ADD</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>

	<!-- Footer -->
	<%@ include file="../../footer/adminFooter.txt"%>
</div>