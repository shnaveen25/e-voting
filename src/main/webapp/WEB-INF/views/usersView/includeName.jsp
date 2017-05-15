<%@ taglib uri="http://www.springframework.org/tags/form" prefix="x"%>
<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Header -->
<%@ include file="../../header/userHeader.txt"%>

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
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
	
	//Ajax call to perform voter name include operation
	$(document).ready(function() {
		$('#addVoterAppl').click(function(event) {
			event.preventDefault();
			var data = {
				stateId : $('#stateId').val(),
				districtId : $('#districtId').val(),
				assemblyId : $('#assemblyId').val(),
				name : $('#name').val(),
				surName : $('#surName').val(),
				dob : $('#dob').val(),
				gender : $('#gender').val(),
				mobile : $('#mobile').val(),
				email : $('#email').val(),
				appliedFor : $('#appliedFor').val(),
				id : $('#id').val(),
				aadhar : $('#aadhar').val(),
				area : $('#area').val(),
				street : $('#street').val(),
				landMark : $('#landMark').val(),
				pinCode : $('#pinCode').val(),
				
			};
			console.log('Adding Voter Applocation with fallowing data ' , data);
			 $.ajax({
				url : 'registerVoterApplication',
				data : JSON.stringify(data),
				type : 'POST',
				headers : {
					'Content-Type' : 'application/json'
				},
				success : function(responseText) {
					console.log("Response after calling addParticipant API",responseText);	
					if(responseText == 'success'){
						alert("Application has been submitted successifully");
						$(window.location).attr('href', 'userHome');
					}
					else{
						alert(responseText);
					}
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
			<form>
				<h4 class="text-center">Application for inclusion of name in
					Electoral Roll</h4>
				<ul>
					<j:if test="${voterApplicationDto.id == null}">
						<li>
							<article>
								<header>
									<address>I. Select Your AC (Assembly Constituency)</address>
								</header>
								<div class="comcont">
									<div class="form-group">
										<p class="col-lg-3 col-sm-2 control-label">Select your
											State</p>
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
									<br /> <br />
								</div>
							</article>
						</li>
					</j:if>
					<li>
						<article>
							<header>
								<address>II. Applicant's Details</address>
							</header>
							<div class="comcont">
								<div class="form-group">
									<label class="col-lg-2 col-sm-2 control-label"> Name </label>
									<div class="col-lg-4 ">
										<input type="text" class="form-control" name="name" id="name"
											placeholder="Enter Your First Name. Special Character/ numbers not allowed." 
											value="<j:out value="${ApplicationDetails.name}" />" required/>
									</div>
									<label class="col-lg-2 col-sm-2 control-label"> Surname
										(if any)</label>
									<div class="col-lg-4">
										<input type="text" class="form-control" name="surName" id="surName"
											placeholder="Your Surname / Lastname. Special Character/ numbers not allowed." />
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 col-sm-2 control-label"> Date of
										Birth </label>
									<div class="col-lg-4">
										<input type="date" class="form-control" name="dob" id="dob" value="<j:out value="${ApplicationDetails.dob}" />"
											title="Please select DOB." required/>
									</div>
									<label class="col-lg-2 col-sm-2 control-label"> Gender</label>
									<div class="col-lg-4">
										<select name="gender" id="gender" class="form-control" value="<j:out value="${ApplicationDetails.gender}" />">
											<option value="male">Male</option>
											<option value="female">Female</option>
											<option value="other">Other</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 col-sm-2 control-label"> Mobile
									</label>
									<div class="col-lg-4">
										<input type="text" class="form-control" name="mobile" id="mobile"
											placeholder="Enter Your Mobile Number" 
											value="<j:out value="${ApplicationDetails.mobile}" />" required/>
									</div>
									<label class="col-lg-2 col-sm-2 control-label"> Email </label>
									<div class="col-lg-4">
										<input type="email" class="form-control" name="email" id="email"
											placeholder="Enter Your Email"
											value="<j:out value="${ApplicationDetails.email}" />" required/>
									</div>
									<input type="hidden" name="appliedFor" id="appliedFor"
											value="including" />
									<input type="hidden" class="form-control" name="id" id="id"
											value="<j:out value="${ApplicationDetails.id}" />" />
								</div>
							</div>
							<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
						</article>

					</li>

					<li>
						<article>
							<header>
								<address>III. Identity Information</address>
							</header>
							<div class="comcont">
								<div class="form-group">
									<label class="col-lg-2 col-sm-2 control-label"> Aadhar
										Number </label>
									<div class="col-lg-10">
										<input type="text" class="form-control" name="aadhar" id="aadhar"
											placeholder="Please Enter Aadhar Number." minlength="12" maxlength="12"
											value="<j:out value="${ApplicationDetails.aadhar}" />" required/> 
											<font color="red">Note: You cannot have a two application on same Aadhar Number</font>
									</div>
								</div>
							</div>
							<br />
							<br />
							<br />
						</article>
					</li>

					<li>
						<article>
							<header>
								<address>IV. Particulars Of Place Of Ordinary
									Residence</address>
							</header>
							<div class="comcont">
								<div class="form-group">
									<label class="col-lg-2 col-sm-2 control-label">
										Area/Street 1 </label>
									<div class="col-lg-4">
										<textarea rows="4" cols="50" class="form-control" name="area" id="area"
											placeholder="Please Enter details of your place of residence."
											><j:out value="${ApplicationDetails.area}" /></textarea>
									</div>
									<label class="col-lg-2 col-sm-2 control-label">
										Area/Street 2 </label>
									<div class="col-lg-4">
										<textarea rows="4" cols="50" class="form-control"
											name="street" id="street"
											placeholder="Please Enter details of your place of residence."></textarea>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 col-sm-2 control-label"> Land
										Mark </label>
									<div class="col-lg-4 ">
										<input type="text" class="form-control" name="landMark" id="landMark"
											placeholder="Enter Land Mark." 
											value="<j:out value="${ApplicationDetails.landMark}" />"/>
									</div>
									<label class="col-lg-2 col-sm-2 control-label"> Pin
										Code </label>
									<div class="col-lg-4">
										<input type="text" class="form-control" name="pinCode" id="pinCode"
											placeholder="Enter Pin" minlength="6" maxlength="6"
											value="<j:out value="${ApplicationDetails.pinCode}" />" required/>
									</div>
								</div>
								
								<div class="text-center">
								<div class="form-group">
									<div class="col-lg-offset-2 col-lg-8">
										<button type="submit" class="btn btn-danger" id="addVoterAppl">SUBMIT</button>
									</div>
								</div>
							</div>							
							</div>
							<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
							<br /> <br />
						</article>
					</li>
				</ul>
			</form>
		</div>
	</div>
	<div class="clear"></div>
	</main>
</div>


<!-- Footer -->
<%@ include file="../../footer/userFooter.txt"%>