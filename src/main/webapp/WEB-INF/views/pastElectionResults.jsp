<!-- Include Header -->
<%@ include file="../header/defaultHeader.txt"%>

<!-- Body -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script>
	var eleId = 0;
	var stateId = 0;
	$(document).ready(function() {
		$.ajax({
			url : 'getPastElections',
			success : function(responseText) {

				showUpcomingElectionData(responseText);
			}
		});
	});

	function showUpcomingElectionData(responseText) {
		console.log("Response Data", responseText);
		var table = "<tbody>";
		$(responseText)
				.each(
						function(i, item) {
							table += "<tr><td>" + item.stateName.toUpperCase()
									+ "</td>";
							table += "<td>" + item.electionFor.toUpperCase()
									+ "</td>";
							table += "<td>" + item.electionDate.toUpperCase()
									+ "</td>";
							table += "<td><a class='getStates' style='cursor:pointer' data-toggle='modal' data-target='#getOptions' stateId="+item.stateId+" eleId="+item.id+">View Result</a>";

						});
		table += "</tbody>";
		$("#pastElections").append(table);

		$('.getStates').click(function() {
			stateId = $(this).attr('stateId');
			eleId = $(this).attr('eleId');
			console.log("Selected election ", eleId);
			console.log("Searching states of the selected election ", stateId);
			$.ajax({
				url : 'getDistricts',
				data : {
					stateId : stateId
				},
				success : function(responseText) {
					$('#assemblyDistrictsDto').text(responseText);
					console.log(responseText);
					showDistrics(responseText);
				}
			});
		});

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

		$('#getElectionResults').click(function() {
			
			console.log('Election results for ' , eleId);
			$.ajax({
				url : 'getElectionResults',
				data : {
					eleId : eleId,
					asmbId : $('#assemblyId').val()
				},
				success : function(responseText) {
					console.log(responseText);
					showElectionResult(responseText);
				}
			});
		});

	}

	function showDistrics(responseText) {
		var selection = '<p class="col-lg-3 col-sm-2 control-label">District</p>';
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
		var selection = '<p class="col-lg-3 col-sm-2 control-label">Assembly</p>';
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
	
	function showElectionResult(responseText) {
		console.log("Response Data", responseText);
		var table = "<tbody>";
		$(responseText)
				.each(
						function(i, item) {
							if (i == 0) {
								table += "<tr><td><font color='red'><i class='fa fa-trophy'></i>  " + item.partyName.toUpperCase() + "</font></td>";
								table += "<td><font color='red'>" + item.name.toUpperCase() + "</font></td>";
								table += "<td><font color='red'>" + item.noOfVotes + "</font></td></tr>";
							} else {
								table += "<tr><td>" + item.partyName.toUpperCase() + "</td>";
								table += "<td>" + item.name.toUpperCase() + "</td>";
								table += "<td>" + item.noOfVotes + "</td></tr>";
							}
						});
		table += "</tbody>";
		$("#eleResult").append(table);
	}
</script>

<!-- Body -->
<div class="wrapper row3 text-center">
	<main class="hoc clear">
	<h4 class="text-center">Election Result</h4>
	<div id="comments">
		<ul>
			<li>
				<article>
					<header>
						<address>List of Past Elections</address>
					</header>
					<div class="comcont">
						<div class="form-group">
							<div>
								<table id="pastElections">
									<thead>
										<tr>
											<td class="col-lg-3">State</td>
											<td class="col-lg-3">Election For</td>
											<td class="col-lg-3">Election date</td>
											<td class="col-lg-3">Action</td>
										</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>
				</article>
			</li>
			
			<li>
				<article>
					<header>
						<address>Result for the selected election</address>
					</header>
					<div class="comcont">
						<div class="form-group">
							<div>
								<table id="eleResult">
									<thead>
										<tr>
											<td class="col-lg-3">Party</td>
											<td class="col-lg-3">Candidate</td>
											<td class="col-lg-3">No of Votes</td>
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

	<!-- Modal -->
	<div id="getOptions" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Select Assembly Constituency</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<div id="districts"></div>
					</div>

					<div class="form-group">
						<div id="assembly"></div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal"
						id="getElectionResults">SUBMIT</button>
				</div>
			</div>

		</div>
	</div>

	</main>
</div>






<!-- Include Footer -->
<%@ include file="../footer/defaultFooter.txt"%>