  <!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Registration</title>
   <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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
.cancelbtn,.signupbtn {
    float: left;
    width: 50%;
}

/* Add padding to container elements */
.container {
    background-color: #66ffff;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
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
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    padding-top: 80px;
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
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

.close:hover,
.close:focus {
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

@-webkit-keyframes animatezoom {
    from {-webkit-transform: scale(0)}
    to {-webkit-transform: scale(1)}
}

@keyframes animatezoom {
    from {transform: scale(0)}
    to {transform: scale(1)}
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
<body style="background-color:#ffc266">

 <!-- Button to open the modal -->


<!-- The Modal (contains the Sign Up form) 
<div id="id01" class="modal" style="background-color:#ffb380">-->
  <h1><center>Voter Registration Form</center></h1>
 <!-- <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span> -->
  <form class="modal-content animate" action="action_page.php" style="background-color:#b8b894">
    <div class="container">
      <label><b>SURNAME</b></label>
      <input type="text" placeholder="Enter SURNAME" name="sname" required>

      <label><b>FIRST NAME</b></label>
      <input type="text" placeholder="Enter FIRST NAME" name="fname" required>

      <label><b>LAST NAME</b></label>
      <input type="text" placeholder="Enter LAST NAME" name="lname" required><br><br>

      <label><b>DATE OF BIRTH</b></label>
      <input type="date" name="dob" required><br><br>

      <input type="radio" name="gender" value="male" checked>Male 
      <input type="radio" name="gender" value="male">Female
      <input type="radio" name="gender" value="male">Others<br><br>

      <label><b>ADHAAR NUMBER</b></label>
      <input type="text" placeholder="Enter UID" name="uid" required>

      <label for="fileupload"> Select a file to upload</label>
      <input type="file" name="fileupload" value="fileupload" id="fileupload" accept=".pdf"><br>

      <label><b>State</b></label>
      <select>
      <option value="Select State">Select State</option>
      <option value="Andra Pradesh">Andra Pradesh</option>
      <option value="Maharashtra">Maharashtra</option>
      <option value="Karnataka">Karnataka</option>
      <option value="Assam">Assam</option>
      </select><br><br>

     <!-- <textarea rows="4" cols="50">
At w3schools.com you will learn how to make a website. We offer free tutorials in all web development technologies. 
</textarea>-->


      <label><b>ADDRESS</b></label><br>
      <textarea rows="4" cols="50" placeholder="Address"> </textarea><br>

      <input type="checkbox" checked="checked"> Remember me
      <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

      <div class="clearfix">
        <button type="button" onclick="location.href='file:///C:/Users/AJIT/Desktop/interlingua/index.html'" class="cancelbtn">Cancel</button>
        <button type="submit" class="signupbtn">Get NSSN_ID</button>
      </div>
    </div>
  </form>
</div>
</body>
</html>