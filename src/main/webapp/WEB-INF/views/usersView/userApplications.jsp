<%@ taglib uri="http://www.springframework.org/tags/form" prefix="x"%>
<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Header -->
<%@ include file="../../header/userHeader.txt"%>

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
								<div class="form-group">
									<Label class="col-lg-3 col-sm-2 control-label">	Name</Label>
									<div class="col-lg-9">
										${ApplicationDetails.name}
									</div>
								</div>

								<div class="form-group">
									<Label class="col-lg-3 col-sm-2 control-label">	Date of Birth</Label>
									<div class="col-lg-9">
										${ApplicationDetails.name}
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
								<!--  	<j:choose>
										<j:when test="${application.applicationStatus == 'pending' }">
											<td><a
												href="getUserApplications?id=<j:out value="${application.id}"/>">
												<j:out value="${application.name}" /></a>
											</td>
										</j:when>
										<j:otherwise> 
											<td><j:out value="${application.name}" /></td>
										</j:otherwise>
									</j:choose>
									
								-->
									<td><a
											href="getUserApplications?id=<j:out value="${application.id}"/>">
											<j:out value="${application.name}" /></a>
									</td>
									<td><j:out value="${application.email}" /></td>
									<td><j:out value="${application.mobile}" /></td>
									<td><j:out value="${application.aadhar}" /></td>
									<td>
										<j:choose>
										<j:when test="${application.applicationStatus == 'pending' }">
										<a
										href="editUserApplication?id=<j:out value="${application.id}"/>">Edit</a>
										/
										<a
										href="deleteUserApplication?id=<j:out value="${application.id}"/>">Delete</a>
										</j:when>
										<j:otherwise>
											Accepted
										</j:otherwise>
										</j:choose>
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
<%@ include file="../../footer/userFooter.txt"%>