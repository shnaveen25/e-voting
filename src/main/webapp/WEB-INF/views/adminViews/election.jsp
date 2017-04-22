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
					alert("Election date has been submited");
					$(window.location).attr('href', 'adminHome');
				},
				error : function(responseText) {
					alert("Failed to add");
				}
			});
		});
	});
	
	
</script>


<!-- Body -->
<div class="wrapper row3 text-center">
	<main class="hoc container clear">
	<div class="col-lg-30">
		<header class="panel-heading">
			<h4>
				<b>ADD UPCOMING ELECTION</b>
			</h4>
		</header>
		<font color="Red"> ${errMsg}</font>
		<form class="form-horizontal animate" method="post">
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label"> Election For
				</label>
				<div class="col-lg-6">
					<select name="electionFor" class="form-control" id="electionFor">
						<option value="0">Select Option</option>
						<option value="generalElection">General Elections (Lok
							sabha)</option>
						<option value="stateElection">State Assembly Elections</option>
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
				<label class="col-lg-3 col-sm-2 control-label">Election Date</label>
				<div class="col-lg-6">
					<input type="date" class="form-control" name="electionDate" id="electionDate"/>
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
	</main>
</div>


<!-- Footer -->
<%@ include file="../../footer/adminFooter.txt"%>