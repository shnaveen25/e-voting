<%@ taglib uri="http://www.springframework.org/tags/form" prefix="x"%>
<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Header -->
<%@ include file="../../header/userHeader.txt"%>

<!-- Body -->
<div class="wrapper row3">
	<main class="hoc container clear">
	<div id="comments">
		<x:form>
			<h3 class="text-center">Application for inclusion of name in
				Electoral Roll</h3>
			<ul>
				<li>
					<article>
						<header>
							<address>Select Your AC (Assembly Constituency)</address>
						</header>
						<article>
							<div class="comcont">

								<div class="form-group">
									<p class="col-lg-3 col-sm-2 control-label"> Select your District </p>
									<div class="col-lg-6">
										<select name="partyId" class="form-control">
											<option value=0>Select State</option>
											<j:forEach items="${assemblyStateDto}" var="state">
												<option value=<j:out value="${state.id}"/>>
													<j:out value="${state.stateName}" />
												</option>
											</j:forEach>
										</select>
									</div>
								</div>
							</div>
							<br/><br/>
						</article>
					</article>
				</li>







			</ul>
		</x:form>
	</div>
	<div class="clear"></div>
	</main>
</div>


<!-- Footer -->
<%@ include file="../../footer/userFooter.txt"%>