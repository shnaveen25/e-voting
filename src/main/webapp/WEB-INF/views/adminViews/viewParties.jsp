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
					<th>Email</th>
					<th>Description</th>
				</tr>
			</thead>
			<tbody>
				<j:forEach items="${listOfparties}" var="party">
					<tr>
						<td><j:out value="${party.partyName}"/></td>
						<td><j:out value="${party.partyEmail}"/></td>
						<td><j:out value="${party.partyDescription}"/></td>
					</tr>
				</j:forEach>
			</tbody>
		</table>
	</div>
</div>


<!-- Footer -->
<%@ include file="../../footer/adminFooter.txt"%>