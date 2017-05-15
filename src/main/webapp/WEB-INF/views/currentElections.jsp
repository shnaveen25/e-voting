<%@page import="org.springframework.web.bind.annotation.RequestMapping"%>
<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Include Header -->
<%@ include file="../header/defaultHeader.txt"%>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script>

var participantId ;
	$(document).ready(function() {
		$("#showCandiadets").hide();
	
		$('#stateId').change(function() {
			console.log('Getting Districts');
			$.ajax({
				url : 'getDistricts',
				data : {
					stateId : $('#stateId').val()
				},
				success : function(responseText) {
					$('#assemblyDistrictsDto').text(responseText);
					console.log(responseText);
					showDistrics(responseText);
				}
			});
		});
	});

	$(document).ready(function() {
		$('#districts').change(function() {
			console.log('Getting Assemblies');
			$.ajax({
				url : 'getAssemblies',
				data : {
					districtId : $('#districtId').val()
				},
				success : function(assemblies) {
					$('#assemblies').text(assemblies);
					console.log(assemblies);
					showAssimblies(assemblies);
				}
			});
		});
	});

	function showDistrics(responseText) {
		var selection = '<p class="col-lg-3 col-sm-2 control-label">Select your District</p>';
		selection += '<div class="col-lg-6">';

		selection += '<select name="districtId" id="districtId" class="form-control" title="Select District in order to proceed">';
		selection += '<option value="0">Select District</option>';
		$(responseText).each(
				function(i, item) {
					console.log('Iterating ', item.districtName, item.id);
					selection = selection + '<option value='+ item.id+'>'
							+ item.districtName + '</option>';

				});
		selection = selection + '</select>'
		selection += '</div><br /> <br />'
		$("#districts").html(selection);
	}

	function showAssimblies(assemblies) {
		var selection = '<p class="col-lg-3 col-sm-2 control-label">Select your Assembly Constituency</p>';
		selection += '<div class="col-lg-6">';

		selection += '<select name="assemblyId" id="assemblyId" class="form-control" title="Select Assembly in order to proceed">';
		selection += '<option value=0>Select Assembly Constituency</option>';
		$(assemblies).each(
				function(i, item) {
					console.log('Iterating ', item.assembly);
					selection = selection + '<option value='+ item.id+'>'
							+ item.assembly + '</option>';

				});
		selection = selection + '</select>'
		selection += '</div><br /> <br />'
		$("#assembly").html(selection);
	}

	$(document).ready(function() {
		$('#assembly').change(function() {
			console.log('Getting electionParticipants');
			$.ajax({
				url : 'getElectionParticipants',
				data : {
					assemblyId : $('#assemblyId').val(),
					stateId : $('#stateId').val()
				},
				success : function(responseText) {
					$('#participantsDto').text(responseText);
					console.log(responseText);
					showParticipants(responseText);
				}
			});
		});
	});

	function showParticipants(responseText, callback) {
		if (responseText.length == 0) {
			alert("No Current elections... Please visit again later");
			$(window.location).attr('href', '/');
		} else {
			var table = "<tbody>"
			$(responseText)
					.each(
							function(i, item) {
								table += "<tr><td>"
										+ item.partyName.toUpperCase()
										+ "</td>";
								table += "<td>" + item.name.toUpperCase()
										+ "</td>";
								table += "<td><button type='button' class='saveId btn btn-info btn-sm' data-toggle='modal' data-target='#myModal' participantId="+item.id+">Vote</button></td></tr>";
							});
			table += "</tbody>";
			$("#showCandiadets").show();
			$("#participants").append(table);
			
			$('.saveId').click(function() {
				
				participantId = $(this).attr('participantId');
				
				console.log('PArtcipant Id ' ,participantId );
			});
		}
	}
	
	//Voting
	$(document).ready(function() {
		$('#vote').click(function() {
			console.log('Getting electionParticipants' , participantId);
			$.ajax({
				url : 'voteForParticipant',
				data : {
					participantId : participantId,
					electorId : $('#electorId').val(),
					password : $('#password').val()
				},
				success : function(responseText) {
					console.log('Server response' , responseText);
					alert(responseText);
					window.location.reload();
				}
			});
		});
	});
	
	$(document).ready(function() {
		$('#getNewPassword').click(function() {
			console.log('Getting Districts');
			$.ajax({
				url : 'getElectorNewPassword',
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

</script>


<!-- Body -->
<div class="wrapper row3">
	<main class="hoc clear">
	<div class="content">
		<div id="comments">
			<h4 class="text-center">Cast Your Vote</h4>
			<ul>
				<li>
					<article>
						<header>
							<address>I. Select Your AC (Assembly Constituency)</address>
						</header>
						<div class="comcont">
							<div class="form-group">
								<p class="col-lg-3 col-sm-2 control-label">Select your State</p>
								<div class="col-lg-6">
									<select name="stateId" id="stateId" class="form-control"
										title="Select State in order to proceed">
										<option value="0">Select State</option>
										<j:forEach items="${assemblyStateDto}" var="state">
											<option value=<j:out value="${state.id}"/>>
												<j:out value="${state.stateName}" />
											</option>
										</j:forEach>
									</select>
								</div>
							</div>

							<div class="form-group">
								<div id="districts"></div>
							</div>

							<div class="form-group">
								<div id="assembly"></div>
							</div>
							<!-- 			
							<div class="form-group">
								<div id="participants"></div>
							</div>
							 -->

						</div>
						<br /> <br /> <br />
					</article>
				</li>


				<li id="showCandiadets">
					<article>
						<header>
							<address>II. List of Participants</address>
						</header>
						<div class="comcont">
							<div class="form-group">
								<div>
									<table id="participants">
										<thead>
											<tr>
												<td class="col-lg-5">Party</td>
												<td class="col-lg-6">Participant name</td>
												<td class="col-lg-6">Action</td>
											</tr>
										</thead>
									</table>
								</div>
							</div>

						</div>
					</article>
				</li>

			</ul>
		</div>
	</div>

	<!-- Modal -->
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Provide your Credentials to Vote </h4>
				</div>
				<div class="modal-body">
					<input type="email" class="form-control" name="electorId" id="electorId"
								placeholder="Elector Id" required/> <br /> 
					<input type="password" class="form-control" name="password" id="password"
								placeholder="Password" required/>
					<div class="text-center"><a style='cursor:pointer' data-toggle='modal' data-target='#changePassword'> Forgot Password ? </a></div>
				</div>
				
				
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal" id="vote">Vote</button>
				</div>
			</div>

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
<%@ include file="../footer/defaultFooter.txt"%>