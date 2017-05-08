<%@ taglib uri="http://www.springframework.org/tags/form" prefix="x"%>
<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<%@ include file="../../header/adminHeader.txt"%>

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
		$('#add').click(function() {
			console.log('Getting Districts');
			$.ajax({
				url : 'addElection',
				data : {
					electionFor : $('#electionFor').val(),
					stateId : $('#stateId').val(),
					electionDate : $('#electionDate').val()
				},
				success : function(responseText) {
					/* $('#assemblyDistrictsDto').text(responseText); */
					console.log(responseText);
					alert(responseText);
					$(window.location).attr('href', 'adminHome');
				}
			});
		});
	});

	$(document).ready(function() {
		$.ajax({
			url : 'getUpcomingElection',
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
							if(item.status == "upcoming_election") {
								table += "<td><a class='start' style='cursor:pointer' id="+item.id+" >Start</a>";
							} else if(item.status == "paused"){
								table += "<td><a class='start' style='cursor:pointer' id="+item.id+" >Start</a> / <a class='stop' style='cursor:pointer' id="+item.id+" >Stop</a>";
							}else{
								table += "<td><a class='pause' style='cursor:pointer' id="+item.id+" >Pause</a> / <a class='stop' style='cursor:pointer' id="+item.id+" >Stop</a></td></tr>";
							}
							
						});
		table += "</tbody>";
		$("#upcomingElections").append(table);
		
		$('.start').click(function(){
			var id = $(this).attr('id');
		    
			console.log("Starting election with id " , id);
			$.ajax({
	            url: 'updateElectionStatus',
	            data: {
	            	id : id,
	            	status : "onGoing"
	            },
	            success: function (responseText) {
	            	alert(responseText);
	            	window.location.reload();
	            }
			});
		});
		
		$('.pause').click(function(){
			var id = $(this).attr('id');
		    
			console.log("Starting election with id " , id);
			$.ajax({
	            url: 'updateElectionStatus',
	            data: {
	            	id : id,
	            	status : "paused"
	            },
	            success: function (responseText) {
	            	alert(responseText);
	            	window.location.reload();
	            }
			});
		});
		
		$('.stop').click(function(){
			var id = $(this).attr('id');
		    
			console.log("Starting election with id " , id);
			$.ajax({
	            url: 'updateElectionStatus',
	            data: {
	            	id : id,
	            	status : "finished"
	            },
	            success: function (responseText) {
	            	alert(responseText);
	            	window.location.reload();
	            }
			});
		});
	}
</script>


<!-- Body -->
<div class="wrapper row3 text-center">
	<main class="hoc clear">
	<h4 class="text-center">Elections</h4>
	<div id="comments">
		<ul>
			<li>
				<article>
					<header>
						<address>Add Elections</address>
					</header>
					<div class="comcont">
						<font color="Red"> ${errMsg}</font>
						<form class="form-horizontal animate" method="post">
							<div class="form-group">
								<label class="col-lg-3 col-sm-2 control-label"> Election
									For </label>
								<div class="col-lg-6">
									<select name="electionFor" class="form-control"
										id="electionFor">
										<option value="0">Select Option</option>
										<option value="generalElection">General Elections
											(Lok sabha)</option>
										<option value="stateElection">State Assembly
											Elections</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-3 col-sm-2 control-label">State</label>
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
								<label class="col-lg-3 col-sm-2 control-label">Election
									Date</label>
								<div class="col-lg-6">
									<input type="date" class="form-control" name="electionDate"
										id="electionDate" min="23-04-2017" />
								</div>
							</div>
							<div class="text-center">
								<div class="form-group">
									<div class="col-lg-offset-2 col-lg-8">
										<button type="submit" class="btn btn-danger" id="add">ADD</button>
									</div>
								</div>
							</div>
						</form>
					</div>
				</article>
			</li>

			<li>
				<article>
					<header>
						<address>Up Coming Elections</address>
					</header>
					<div class="comcont">
						<div class="form-group">
							<div>
								<table id="upcomingElections">
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


		</ul>
	</div>
	</main>
</div>


<!-- Footer -->
<%@ include file="../../footer/adminFooter.txt"%>