<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Include Header -->
<%@ include file="../header/defaultHeader.txt"%>

<!-- Body -->
<div class="wrapper row3">
	<main class="hoc clear">
	<h4 class="text-center">Party Details</h4>
	<div id="comments">
		<ul>
			<j:forEach items="${listOfparties}" var="party">
				<li>
					<article>
						<header>
							<address>
								<a href="#"><j:out value="${party.partyName.toUpperCase()}" /></a>
							</address>
							<time>

								<a href="mailto:<j:out value="${party.partyEmail}"/>"><j:out
										value="${party.partyEmail}" /></a>
							</time>
						</header>
						<div class="comcont">
							<p align="justify">
								<j:out value="${party.partyDescription}" />
							</p>
						</div>
					</article>
				</li>
			</j:forEach>
		</ul>
	</div>
	</main>
</div>

<!-- Include Footer -->
<%@ include file="../footer/defaultFooter.txt"%>