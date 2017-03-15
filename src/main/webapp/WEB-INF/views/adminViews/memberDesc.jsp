<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="x"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Select PArty</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */
button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

/* Extra styles for the cancel button */
.cancelbtn {
	padding: 14px 20px;
	background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
	float: left;
	width: 50%;
}

/* Add padding to container elements */
.container {
	background-color: #66ffff;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 90%; /* Could be more or less, depending on screen size */
}

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	padding-top: 80px;
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 60%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
	position: absolute;
	right: 35px;
	top: 15px;
	color: #000;
	font-size: 40px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: red;
	cursor: pointer;
}

/* Clear floats */
.clearfix::after {
	content: "";
	clear: both;
	display: table;
}

.animate {
	-webkit-animation: animatezoom 0.6s;
	animation: animatezoom 0.6s
}

@
-webkit-keyframes animatezoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes animatezoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}
/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
	.cancelbtn, .signupbtn {
		width: 100%;
	}
}
</style>

<script>
	// Get the modal
	var modal = document.getElementById('id01');

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
</script>
<body style="background-color: #ffc266">

	<!-- Button to open the modal -->


	<!-- The Modal (contains the Sign Up form) 
<div id="id01" class="modal" style="background-color:#ffb380">-->
	<h1>
		<center>Member Description Form</center>
	</h1>
	<x:form class="modal-content animate" action="addParticipantDetails"
		style="background-color:#b8b894" modelAtribute="selectedParty">
		<div class="container">
			<label><b>Select Party</b></label> <select>
				<j:forEach items="${partyList}" var="party">
					<option value=<j:out value="${party.id}"/>>
						<j:out value="${party.partyName}" />
					</option>
				</j:forEach>
			</select><br>
			<br> <label><b>Participating for</b></label><br> <input
				type="radio" name="post" value="mla" checked>MLA <input
				type="radio" name="post" value="mp">MP<br>
			<br> <label><b>State</b></label> <select>
				<option value="karnataka">Karnataka</option>
				<option value="Andra">Andra</option>
			</select><br>
			<br>
			<div class="clearfix">
				<button type="button" onclick="" class="cancelbtn">Cancel</button>
				<button type="submit" class="signupbtn">Next</button>
			</div>
		</div>
	</x:form>
</body>
</html>