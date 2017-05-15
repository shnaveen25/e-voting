<!-- Header -->
<%@ include file="../../header/adminHeader.txt"%>


<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
		$.ajax({
			url : 'getAllStates',
			success : function(responseText) {
				console.log(responseText);
				$("#showElectors").hide();
				showStates(responseText);
			}
		})
	});

	$(document).ready(function() {
		$('#states').change(function() {
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
		$('#assembly').change(function() {
			console.log('Getting Electors');
			$.ajax({
				url : 'showElectorsForAssembly',
				data : {
					assId : $('#assemblyId').val()
				},
				success : function(responseText) {
					console.log(responseText);
					showElectors(responseText);
				}
			});
		});
	});

	function showStates(responseText) {
		var selection = '<label class="col-lg-3 col-sm-2 control-label">States</label>';
		selection += '<div class="col-lg-6">';

		selection += '<select name="stateId" id="stateId" class="form-control" title="Select State in order to proceed">';
		selection += '<option value="0">Select State</option>';
		$(responseText).each(
				function(i, item) {
					console.log('Iterating ', item.stateName, item.id);
					selection = selection + '<option value='+ item.id+'>'
							+ item.stateName + '</option>';

				});
		selection = selection + '</select>'
		selection += '</div><br /> <br />'
		$("#states").html(selection);
	}

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

	function showElectors(responseText) {
		if (responseText.length == 0) {
			alert("No Electors hav been added yet...!!");
			$(window.location).attr('href', 'adminHome');
		} else {
			var table = "<tbody>"
			$(responseText)
					.each(
							function(i, item) {
								table += "<tr><td>"
										+ item.electorId.toUpperCase()
										+ "</td>";
								table += "<td>" + item.name.toUpperCase()
										+ "</td>";
								table += "<td>" + item.aadhar
										+ "</td>";
								table += "<td>" + item.email
										+ "</td>";
								table += "<td>" + item.mobile
										+ "</td>";
								table += "<td>" + item.area + " " +item.pinCode
										+ "</td>";
								if(item.status == 'active'){
									table += "<td><button type='button' class='changeStatus btn btn-info btn-sm' id="+item.id+">Inactive</button></td></tr>";
								} else{
									table += "<td><button type='button' class='changeStatus btn btn-info btn-sm' id="+item.id+">Active</button></td></tr>";
								}
								
								});
			table += "</tbody>";
			$("#showElectors").show();
			$("#electors").append(table);
			
			$('.changeStatus').click(function(){
				var id = $(this).attr('id');
			    
				console.log("A/I elector with id " , id);
				$.ajax({
		            url: 'activeOrInavtiveElector',
		            data: {
		            	id : id,
		            },
		            success: function (responseText) {
		            	alert(responseText);
		            	window.location.reload();
		            }
				});
			});
		}
	}
</script>

<!-- Body -->
<div class="wrapper row3">
	<main class="hoc clear">
	<h4 class="text-center">Electors List</h4>
	<div id="comments">
		<ul>
			<li>
				<article>
					<header>
						<address>I. AC (Assembly Constituency)</address>
					</header>
					<div class="comcont">
						<div class="form-group">
							<div id="states"></div>
						</div>

						<div class="form-group">
							<div id="districts"></div>
						</div>

						<div class="form-group">
							<div id="assembly"></div>
						</div>

					</div>
				</article>
			</li>

			<li id="showElectors">
				<article>
					<header>
						<address>II. List of Electors</address>
					</header>
					<div class="comcont">
						<div class="form-group">
							<div>
								<table id="electors">
									<thead>
										<tr>
											<td >Elector Id</td>
											<td >Name</td>
											<td >Aadhar</td>
											<td >email</td>
											<td >Mobile</td>
											<td >Address</td>
											<td >Action</td>
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
	</main>
</div>


<!-- Footer -->
<%@ include file="../../footer/adminFooter.txt"%>
