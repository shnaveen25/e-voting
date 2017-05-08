<%@ taglib uri="http://www.springframework.org/tags/form" prefix="x"%>
<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Header -->
<%@ include file="../../header/adminHeader.txt"%>

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
		$('#accept').click(function() {
			console.log('Application Accepted');
			$.ajax({
				url : 'acceptVoterApplication',
				data : {
					applicationId : $('#applicationId').val(),
					comment : $('#comment').val()
				},
				success : function(responseText) {
					$('#assemblyDistrictsDto').text(responseText);
					console.log(responseText);
					alert("Application Accepted");
					 $(window.location).attr('href', 'adminHome');
				}
			});
		});
	});
	
	$(document).ready(function() {
		$('#reject').click(function() {
			console.log('Application Rejected');
			$.ajax({
				url : 'rejectVoterApplication',
				data : {
					applicationId : $('#applicationId').val(),
					comment : $('#comment').val()
				},
				success : function(responseText) {
					$('#assemblyDistrictsDto').text(responseText);
					alert("Applicaton has been Rejected");
					 $(window.location).attr('href', 'adminHome');
				}
			});
		});
	});

	
</script>
<!-- Body -->
<div class="wrapper row3">
	<main class="hoc clear">
	<j:choose>
		<j:when test="${ApplicationDetails != null}">
		<br/>
			<h4 class="text-center">Application Details</h4>
			<div id="comments">
				<ul>
					<li>
						<article>
							<header>
								<address>I. AC (Assembly Constituency)</address>
							</header>
							<div class="comcont">
								<div class="form-group">
									<Label class="col-lg-3 col-sm-2 control-label">	State</Label>
									<div class="col-lg-9">
										${ApplicationDetails.stateName}
									</div>
								</div>

								<div class="form-group">
									<Label class="col-lg-3 col-sm-2 control-label">	District</Label>
									<div class="col-lg-9">
										${ApplicationDetails.districtName}
									</div>
								</div>

								<div class="form-group">
									<Label class="col-lg-3 col-sm-2 control-label">	Assembly Constituency</Label>
									<div class="col-lg-9">
										${ApplicationDetails.assemblyName}
									</div>
								</div>
								<br /> <br /><br /> <br /><br />
							</div>
						</article>
					</li>
					
					<li>
						<article>
							<header>
								<address>II. Applicant's Details</address>
							</header>
							<div class="comcont">
								<input type="hidden" id="applicationId" value='<j:out value="${ApplicationDetails.id}"></j:out>'/>
								
								<div class="form-group">
									<Label class="col-lg-3 col-sm-2 control-label">	Name</Label>
									<div class="col-lg-9">
										${ApplicationDetails.name}
									</div>
								</div>

								<div class="form-group">
									<Label class="col-lg-3 col-sm-2 control-label">	Date of Birth</Label>
									<div class="col-lg-9">
										${ApplicationDetails.dob}
									</div>
								</div>
								<!-- 
								<div class="form-group">
									<Label class="col-lg-3 col-sm-2 control-label">	Gender</Label>
									<div class="col-lg-9">
										${ApplicationDetails.gender	}
									</div>
								</div>
								 -->
								<div class="form-group">
									<Label class="col-lg-3 col-sm-2 control-label">	Mobile</Label>
									<div class="col-lg-9">
										${ApplicationDetails.mobile}
									</div>
								</div>
								
								<div class="form-group">
									<Label class="col-lg-3 col-sm-2 control-label">	Email</Label>
									<div class="col-lg-9">
										${ApplicationDetails.email}
									</div>
								</div>
								
								<div class="form-group">
									<Label class="col-lg-3 col-sm-2 control-label">	Aadhar</Label>
									<div class="col-lg-9">
										${ApplicationDetails.aadhar}
									</div>
								</div>
								<br /> <br /><br /> <br /><br /><br /> <br /><br /> <br /><br />
							</div>
						</article>
					</li>
					
					<li>
						<article>
							<header>
								<address>III. Particulars Of Place Of Ordinary
									Residence</address>
							</header>
							<div class="comcont">
								<div class="form-group">
									<Label class="col-lg-3 col-sm-2 control-label">	Address</Label>
									<div class="col-lg-9">
										${ApplicationDetails.area}
									</div>
								</div>

								<div class="form-group">
									<Label class="col-lg-3 col-sm-2 control-label">	Land Mark</Label>
									<div class="col-lg-9">
										${ApplicationDetails.landMark}
									</div>
								</div>

								<div class="form-group">
									<Label class="col-lg-3 col-sm-2 control-label">	Pin</Label>
									<div class="col-lg-9">
										${ApplicationDetails.pinCode}
									</div>
								</div>
								<br /> <br /><br /> <br /><br /><br />
							</div>
						</article>
					</li>

					<li>
						<article>
							<header>
								<address>IV.Add Your Comment</address>
							</header>
							<div class="comcont">
								<div class="form-group">
									<label class="col-lg-2 col-sm-2 control-label">
										Comment </label>
									<div class="col-lg-4">
										<textarea rows="4" cols="50" class="form-control" name="comment"
											id="comment" placeholder="Add your comment."
										></textarea>
									</div>
								</div>
								<div class="text-center">
								<div class="form-group">
									<div class="col-lg-offset-2 col-lg-8">
										<button type="submit" class="btn btn-danger" id="accept">Accept</button>
										<button type="submit" class="btn btn-danger" id="reject">Reject</button>
									</div>
								</div>
								</div>
								<br /> <br /><br /> <br /><br /> <br /><br /> <br />
							</div>
						</article>
				</ul>
			</div>
		</j:when>
		<j:otherwise>
			<center>
				<div class="scrollable">
					<table>
						<thead>
							<tr>
								<th>Name</th>
								<th>Email</th>
								<th>Mobile</th>
								<th>Aadhar</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<j:forEach items="${applicationList}" var="application">
								<tr>
									<td><j:out value="${application.name}" /></td>
									<td><j:out value="${application.email}" /></td>
									<td><j:out value="${application.mobile}" /></td>
									<td><j:out value="${application.aadhar}" /></td>
									<td><a
										href="viewUserApplications?id=<j:out value="${application.id}"/>">View</a>
									</td>
								</tr>
							</j:forEach>
						</tbody>
					</table>
				</div>
			</center>
		</j:otherwise>
	</j:choose> </main>
</div>

<!-- Footer -->
<%@ include file="../../footer/adminFooter.txt"%>