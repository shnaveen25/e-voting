<%@page import="org.springframework.web.bind.annotation.RequestMapping"%>
<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Include Header -->
<%@ include file="../header/defaultHeader.txt"%>


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

	$(document).ready(function() {
		$('#assembly').change(function() {
			console.log('Getting electionParticipants');
			$.ajax({
				url : 'getElectionParticipants',
				data : {
					assemblyId : $('#assemblyId').val(),
					stateId  : $('#stateId').val()
				},
				success : function(responseText) {
					$('#participantsDto').text(responseText);
					console.log(responseText);
					showParticipants(responseText);
				}
			});
		});
	});
	
	function showParticipants(responseText) {
		if(responseText.length == 0){
			alert("No Current elections... Please visit again later");
			 $(window.location).attr('href', '/');
		}
	}
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
						</div>
						<br /> <br /> <br /> 
				</li>
			</ul>

		</div>
		
	</div>
	</main>
</div>



<!-- Include Footer -->
<%@ include file="../footer/defaultFooter.txt"%>