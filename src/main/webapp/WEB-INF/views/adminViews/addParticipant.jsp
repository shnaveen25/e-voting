<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="x"%>


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
</script>



<!-- Header -->
<%@ include file="../../header/adminHeader.txt"%>

<!-- Body -->
<div class="wrapper row3 text-center">
	<div class="col-lg-30">
		<header class="panel-heading">
			<h4>
				<b>Member Description Form</b>
			</h4>
		</header>
		<font color="Red"> ${errMsg}</font>
		<x:form class="form-horizontal animate" action="addParticipant"
			modelAttribute="participant">
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label"> Party
				</label>
				<div class="col-lg-6">
					<select name="partyId" class="form-control">
						<option value="0">Select Party</option>
						<j:forEach items="${partyList}" var="party">
							<option value=<j:out value="${party.id}"/>>
								<j:out value="${party.partyName}" />
							</option>
						</j:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label">State
				</label>
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
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label"> Full Name </label>
				<div class="col-lg-6">
					<input type="text" class="form-control" name="name"
						placeholder="Enter Name" title="Please Enter your officel name" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label"> Email </label>
				<div class="col-lg-6">
					<input type="text" class="form-control" name="email"
						placeholder="Enter Email" title="Please Enter your email" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label"> Mobile </label>
				<div class="col-lg-6">
					<input type="text" class="form-control" name="mobile"
						placeholder="Enter Mobile Number"
						title="Please enter your mobile number" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label"> Date of
					Birth </label>
				<div class="col-lg-6">
					<input type="Date" class="form-control" name="dob" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label"> Gender </label>
				<div class="col-lg-6">
					<select name="gender" class="form-control">
						<option value="male">Male</option>
						<option value="female">Female</option>
						<option value="other">Other</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label">
					Participating For </label>
				<div class="col-lg-6">
					<select name="post" class="form-control">
						<option value="mla">MLA</option>
						<option value="mp">MP</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label">
					Participating Place </label>
				<div class="col-lg-6">
					<input type="text" class="form-control" name="participatingPlace"
						placeholder="Enter Participating Place"
						title="Please enter participating place" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label"> Education </label>
				<div class="col-lg-6">
					<input type="text" class="form-control" name="education"
						placeholder="Enter Education Qualification"
						title="Please enter education" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label"> Property </label>
				<div class="col-lg-6">
					<input type="text" class="form-control" name="property"
						placeholder="Enter property" title="Please enter property value" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label"> Adhaar
					Number </label>
				<div class="col-lg-6">
					<input type="text" class="form-control" name="adhaar"
						placeholder="Enter Address" title="Please enter adhaar number" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label"> Police
					Record </label>
				<div class="col-lg-6">
					<select name="policeRecord" class="form-control">
						<option value="Select State">Select Option</option>
						<option value="yes">Yes</option>
						<option value="no">No</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label"> Address </label>
				<div class="col-lg-6">
					<textarea rows="4" cols="50" class="form-control" name="address"
						placeholder="Enter Address" title="Please enter address"></textarea>
				</div>
			</div>
			<div class="text-center">
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-8">
						<button type="submit" class="btn btn-danger">Submit</button>
					</div>
				</div>
			</div>
		</x:form>
	</div>
</div>


<!-- Footer -->
<%@ include file="../../footer/adminFooter.txt"%>