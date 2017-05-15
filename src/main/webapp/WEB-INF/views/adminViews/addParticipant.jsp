<!-- Header -->
<%@ include file="../../header/adminHeader.txt"%>

<!-- Body -->
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
		$.ajax({
			url : 'getAllStates',
			success : function(responseText) {
				console.log('States ', responseText)
				showStates(responseText);
			}
		});
	});

	function showStates(responseText) {
		var selection = '<label class="col-lg-3 col-sm-2 control-label">State</label>';
		selection += '<div class="col-lg-6">';

		selection += '<select name="stateId" id="stateId" class="form-control" title="Select State in order to proceed">';
		selection += '<option value=0>Select State</option>';
		$(responseText).each(
				function(i, item) {
					console.log('Iterating ', item.assembly);
					selection = selection + '<option value='+ item.id+'>'
							+ item.stateName + '</option>';

				});
		selection = selection + '</select>'
		selection += '</div><br /> <br />'
		$("#state").html(selection);
		$("#participantForm").hide();
	}

	$(document).ready(function() {
		$('#state').change(function() {
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

	$(document).ready(function() {
		$('#assembly').change(function(event) {
			event.preventDefault();
			console.log('Getting elections');
			$.ajax({
				url : 'getElectionDate',
				data : {
					stateId : $('#stateId').val()
				},
				success : function(elections) {
					$('#electionDto').text(elections);
					console.log(elections);
					showElections(elections);
				}
			});
		});
	});

	function showDistrics(responseText) {
		var selection = '<label class="col-lg-3 col-sm-2 control-label">District</label>';
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
		var selection = '<label class="col-lg-3 col-sm-2 control-label">Assembly</label>';
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

	function showElections(elections) {
		var selection = '<label class="col-lg-3 col-sm-2 control-label">Election Date</label>';
		selection += '<div class="col-lg-6">';

		selection += '<select name="electionId" id="electionId" class="form-control" title="Select election date in order to proceed">';
		selection += '<option value=0>Select Election Date</option>';
		$(elections).each(
				function(i, item) {
					console.log('Iterating ', item.elections);
					selection = selection + '<option value='+ item.id+'>'
							+ item.electionDate + '</option>';

				});
		selection = selection + '</select>'
		selection += '</div><br /> <br />'
		$("#elections").html(selection);
	}

	//Get the parties
	$(document).ready(function() {
		$('#elections').change(function() {
			console.log('Getting ElectionDates');
			$.ajax({
				url : 'getPartyWithNoParticipant',
				data : {
					assemblyId : $('#assemblyId').val(),
					electionId : $('#electionId').val()
				},
				success : function(responseData) {
					console.log(responseData);
					showParties(responseData);
				}
			});
		});
	});

	function showParties(responseData) {
		var selection = '<label class="col-lg-3 col-sm-2 control-label">Party</label>';
		selection += '<div class="col-lg-6">';

		selection += '<select name="partyId" id="partyId" class="form-control" title="Select party date in order to proceed">';
		selection += '<option value=0>Select Party</option>';
		$(responseData).each(
				function(i, item) {
					console.log('Iterating ', item.elections);
					selection = selection + '<option value='+ item.id+'>'
							+ item.partyName + '</option>';

				});
		selection = selection + '</select>'
		selection += '</div><br /> <br />'
		$("#parties").html(selection);

	}
	$(document).ready(function() {
		$('#parties').change(function() {
			$("#participantForm").show();
		});
	});
	

	//Ajax call to perform add participant operation
	$(document).ready(function() {
		$('#addParticipant').click(function(event) {
			event.preventDefault();
			var data = {
				partyId : $('#partyId').val(),
				stateId : $('#stateId').val(),
				districtId : $('#districtId').val(),
				assemblyId : $('#assemblyId').val(),
				electionId : $('#electionId').val(),
				name : $('#name').val(),
				email : $('#email').val(),
				mobile : $('#mobile').val(),
				dob : $('#dob').val(),
				gender : $('#gender').val(),
				post : $('#post').val(),
				education : $('#education').val(),
				property : $('#property').val(),
				adhaar : $('#adhaar').val(),
				policeRecord : $('#policeRecord').val(),
				address : $('#address').val(),
			};
			console.log('Adding participant with fallowing data ' , data);
			$.ajax({
				url : 'addParticipant',
				data : JSON.stringify(data),
				type : 'POST',
				headers : {
					'Content-Type' : 'application/json'
				},
				success : function(responseText) {
					console.log("Response after calling addParticipant API",responseText);	
					if(responseText == 'success'){
						alert("participant has been added successifully");
						$(window.location).attr('href', 'viewParticipants');
					}
					else{
						alert(responseText);
					}
				}
			}); 
		});
	});
</script>

<div class="wrapper row3">
	<main class="hoc clear">
	<div class="content">
	<h4 class="text-center">Participant Details</h4>
		<div id="comments">
			<ul>
				<li>
					<article>
						<header>
							<address>I. Election Details</address>
						</header>
						<div class="form-group">
							<div id="state"></div>
						</div>
						<div class="form-group">
							<div id="districts"></div>
						</div>

						<div class="form-group">
							<div id="assembly"></div>
						</div>

						<div class="form-group">
							<div id="elections"></div>
						</div>

						<div class="form-group">
							<div id="parties"></div>
						</div>
					</article>
				</li>
				<li id="participantForm">
					<article>
						<header>
							<address>II. Participant Details</address>
						</header>
						<div class="form-group">
							<label class="col-lg-2 col-sm-2 control-label"> Full Name
							</label>
							<div class="col-lg-4">
								<input type="text" class="form-control" name="name" id="name"
									placeholder="Enter Name" title="Please Enter your officel name"
									required />
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-2 col-sm-2 control-label"> Email </label>
							<div class="col-lg-4">
								<input type="email" class="form-control" name="email" id="email"
									placeholder="Enter Email" title="Please Enter your email"
									required />
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-2 col-sm-2 control-label"> Mobile </label>
							<div class="col-lg-4">
								<input type="text" class="form-control" name="mobile"
									id="mobile" placeholder="Enter Mobile Number"
									title="Please enter your mobile number" minlength="10"
									maxlength="10" required />
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-2 col-sm-2 control-label"> Date of
								Birth </label>
							<div class="col-lg-4">
								<input type="Date" class="form-control" name="dob" id="dob"
									required />
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-2 col-sm-2 control-label"> Gender </label>
							<div class="col-lg-4">
								<select name="gender" id="gender" class="form-control">
									<option value="male">Male</option>
									<option value="female">Female</option>
									<option value="other">Other</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-2 col-sm-2 control-label">
								Participating For </label>
							<div class="col-lg-4">
								<select name="post" id="post" class="form-control">
									<option value="mla">MLA</option>
									<option value="mp">MP</option>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label class="col-lg-2 col-sm-2 control-label"> Education
							</label>
							<div class="col-lg-4">
								<input type="text" class="form-control" name="education"
									id="education" placeholder="Enter Education Qualification"
									title="Please enter education" required />
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-2 col-sm-2 control-label"> Property
							</label>
							<div class="col-lg-4">
								<input type="text" class="form-control" name="property"
									id="property" placeholder="Enter property"
									title="Please enter property value" required />
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-2 col-sm-2 control-label"> Adhaar
								Number </label>
							<div class="col-lg-4">
								<input type="text" class="form-control" name="adhaar"
									id="adhaar" placeholder="Enter Address"
									title="Please enter adhaar number" minlength="12"
									maxlength="12" required />
								<!-- <font color="red">Note: You
									cannot have a two participant on same Aadhar Number</font> -->
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-2 col-sm-2 control-label"> Police
								Record </label>
							<div class="col-lg-4">
								<select name="policeRecord" id="policeRecord"
									class="form-control">
									<option value="Select State">Select Option</option>
									<option value="yes">Yes</option>
									<option value="no" selected>No</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-2 col-sm-2 control-label"> Address </label>
							<div class="col-lg-4">
								<textarea rows="4" cols="50" class="form-control" name="address"
									id="address" placeholder="Enter Address"
									title="Please enter address" required></textarea>
							</div>
						</div>
						<div class="text-center">
							<div class="form-group">
								<div class="col-lg-offset-2 col-lg-8">
									<button type="submit" class="btn btn-danger"
										id="addParticipant">ADD</button>
								</div>
							</div>
						</div>
						<br />
						<br />
						<br />
						<br />
						<br />
						<br />
						<br />
						<br />
						<br />
						<br />
						<br />
						<br />
						<br />
						<br />
						<br />
						<br />
						<br />
						<br />
						<br />
						<br />
						<br />
						<br />
					</article>
				</li>
			</ul>
		</div>
	</div>
	</main>
</div>









<!-- Footer -->
<%@ include file="../../footer/adminFooter.txt"%>