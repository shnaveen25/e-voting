<!-- Header -->
<%@ include file="../../header/userHeader.txt"%>

<!-- Body -->
<div class="wrapper row3">
	<font color="Red"> ${message}</font>
	<section class="hoc container clear">
		<div class="sectiontitle">
			<h6 class="heading">Welcome ${userName}</h6>
		</div>
		<ul class="nospace group services">
			<li class="one_quarter first">
				<article class="inverse">
					<a href="includeName"><i class="fa fa-3x fa-pencil fa-fw"></i></a>
					<h6 class="heading font-x1">
						<a href="includeName">Including</a>
					</h6>
					<p>For including Your Name in Electoral Roll</p>
				</article>
			</li>
<!-- 			<li class="one_quarter">
				<article>
					<a href="#"><i class="fa fa-3x fa-trash-o fa-lg"></i></a>
					<h6 class="heading font-x1">
						<a href="#">Deleting</a>
					</h6>
					<p>For Deleting Your Name From Electoral Roll</p>
				</article>
			</li> -->
			<li class="one_quarter">
				<article class="inverse">
					<a href="modifyUserApplication"><i
						class="fa fa-3x fa-pencil-square-o"></i></a>
					<h6 class="heading font-x1">
						<a href="modifyUserApplication">Modifying</a>
					</h6>
					<p>For Modifying Your Name in Electoral Roll</p>
				</article>
			</li>
<!-- 			<li class="one_quarter">
				<article>
					<a href="#"><i class="fa fa-3x fa-location-arrow"></i></a>
					<h6 class="heading font-x1">
						<a href="#">Transposing</a>
					</h6>
					<p>For Transposing Your Name in Electoral Roll</p>
				</article>
			</li> -->
		</ul>
	</section>

</div>


<!-- Footer -->
<%@ include file="../../footer/userFooter.txt"%>