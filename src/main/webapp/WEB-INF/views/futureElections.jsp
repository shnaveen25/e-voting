<!-- Include Header -->
<%@ include file="../header/defaultHeader.txt"%>

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script>
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
									+ "</td></tr>";
						});
		table += "</tbody>";
		$("#upcomingElections").append(table);
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
					<div class="comcont">
						<div class="form-group">
							<div>
								<table id="upcomingElections">
									<thead>
										<tr>
											<td class="col-lg-3">State</td>
											<td class="col-lg-3">Election For</td>
											<td class="col-lg-3">Election date</td>
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


<!-- Include Footer -->
<%@ include file="../footer/defaultFooter.txt"%>