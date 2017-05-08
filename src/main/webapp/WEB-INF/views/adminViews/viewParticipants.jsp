<%@ taglib uri="http://www.springframework.org/tags/form" prefix="x"%>
<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<%@ include file="../../header/adminHeader.txt"%>


<!-- Body -->
<div class="wrapper row3 text-center">
	<div class="col-lg-30">
		<header class="panel-heading">
			<h4>
				<b>List of Parties</b>
			</h4>
		</header>
		<font color="Red"> ${errMsg}</font>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Party Name</th>
					<th>Post</th>
					<th>Email</th>
					<th>State</th>
					<th>district</th>
					<th>Assembly</th>
					<th>Participating election</th>
				</tr>
			</thead>
			<tbody>
				<j:forEach items="${listOfParticipants}" var="participants">
					<tr>
						<td><j:out value="${participants.name}"/></td>
						<td><j:out value="${participants.partyName}"/></td>
						<td><j:out value="${participants.post}"/></td>
						<td><j:out value="${participants.email}"/></td>
						<td><j:out value="${participants.stateName}"/></td>
						<td><j:out value="${participants.districtName}"/></td>
						<td><j:out value="${participants.assemblyName}"/></td>
						<td><j:out value="${participants.electionFor}"/> On <j:out value="${participants.electionDate}"/></td>
					</tr>
				</j:forEach>
			</tbody>
		</table>
	</div>
</div>



<!-- Footer -->
<%@ include file="../../footer/adminFooter.txt"%>