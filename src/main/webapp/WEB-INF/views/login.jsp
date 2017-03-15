
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Admin Login</title>
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
	background-color: rgb(0, 145, 0); /* Fallback color */
	background-color: rgba(0, 254, 0, 0.4); /* Black w/ opacity */
	padding-top: 80px;
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 5px auto; /* 15% from the top and centered */
	border: 1px solid #888;
	width: 50%; /* Could be more or less, depending on screen size */
	font-family: Arial;
}

/* The Close Button */
.close {
	/* Position it in the top right corner outside of the modal */
	position: absolute;
	right: 25px;
	top: 0;
	color: #000;
	font-size: 35px;
	font-weight: bold;
}

/* Close button on hover */
.close:hover, .close:focus {
	color: red;
	cursor: pointer;
}

/*button color */
.button {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 8px 8px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 12px;
}

/* Add Zoom Animation */
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
</head>
<br/>
<body style="background-color: #00997a;">
	<div style="text-align: center">
		<!-- Modal Content -->
			
		<form class="modal-content animate" action="/processLogin"
			style="background-color: #ff9966" method="post">
			<div class="imgcontainer" style="background-color: #ff9966">
				<img src="static/images/demo/13-512.png" alt="Avatar" height="320px"
					width="320px" class="avatar">
			</div>
			<font color="Red"> ${errMsg}</font>
			<div class="modal-content" style="background-color: #ffffb3">
				<label><b>Username</b></label> <input type="text"
					placeholder="Enter Username" name="uname" required> <br />
				<label><b>Password</b></label> <input type="password"
					placeholder="Enter Password" name="pswd" required> <br />
				<button type="submit" class="button">Login</button>
			</div>
		</form>
	</div>
</body>
</html>