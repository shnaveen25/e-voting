<%@ taglib uri="http://www.springframework.org/tags/form" prefix="x"%>
<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<%@ include file="../../header/userHeader.txt"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
		$('#submit').click(function() {
			console.log('Editing application');
			var data = {
				name : $('#name').val(),
				dob : $('#dob').val(),
				gender : $('#gender').val(),
				mobile : $('#mobile').val(),
				email : $('#email').val(),
				appliedFor : $('#appliedFor').val(),
				id : $('#id').val(),
				area : $('#area').val(),
				landMark : $('#landMark').val(),
				pinCode : $('#pinCode').val(),
				aadhar  : $('#aadhar').val()

			};
			console.log("Form Data", data);
			$.ajax({
				url : 'editApplication',
				data : JSON.stringify(data),
				headers : {
					'Accept' : 'application/json',
					'Content-Type' : 'application/json'
				},
				type : 'PUT',
				complete : function(responseText) {
					alert("Request has been sent");
					$(window.location).attr('href', 'userHome');
				}
			});
		});
		
		$('#delete').click(function() {
			console.log('Requesting to delet application' , $('#aadhar').val());
			$.ajax({
				url : 'requestDeleteVoterApplication',
				data : {
					aadhar  : $('#aadhar').val(),
				},
				success : function(responseText) {
					console.log(responseText)
					alert(responseText);
					$(window.location).attr('href', 'userHome');
				}
			});
		});
		
	});
</script>

<!-- Body -->
<div class="wrapper row3">
	<main class="hoc clear">
	<h4 class="text-center">Application Details</h4>
	<div id="comments">
		<ul>
			<j:if test="${electorProfile == null}">
				<li>
					<article>
						<header>
							<address>I. Provide Elector Details</address>
						</header>
						<form action="getElectorProfile">
							<div class="comcont">
								<div class="form-group">
									<Label class="col-lg-3 col-sm-2 control-label">Elector
										Id </Label>
									<div class="col-lg-9">
										<input type="text" name="electorId" id="electorId" required /><br />
									</div>
								</div>

								<div class="form-group">
									<Label class="col-lg-3 col-sm-2 control-label">Password</Label>
									<div class="col-lg-9">
										<input type="password" name="password" id="password" required /><br />
									</div>
								</div>
								<div class="text-center">
									<div class="form-group">
										<div class="col-lg-offset-2 col-lg-8">
											<button type="submit" class="btn btn-danger" id="generateOTP"
												data-toggle='modal' data-target='#otpField'>Get
												Profile</button>
										</div>

									</div>
								</div>
							</div>
							<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
							<br />
						</form>
					</article>
				</li>
			</j:if>
			<j:if test="${electorProfile != null}">
				<li>
					<article>
						<header>
							<address>II. Applicant's Details</address>
						</header>
						<div class="comcont">
							<div class="form-group">
								<label class="col-lg-2 col-sm-2 control-label"> Name </label>
								<div class="col-lg-4 ">
									<input type="text" class="form-control" id="name"
										placeholder="Enter Your First Name. Special Character/ numbers not allowed."
										value="<j:out value="${electorProfile.name}" />" required />
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-2 col-sm-2 control-label"> Date of
									Birth </label>
								<div class="col-lg-4">
									<input type="date" class="form-control" id="dob"
										value="<j:out value="${electorProfile.dob}" />"
										title="Please select DOB." required />
								</div>
								<label class="col-lg-2 col-sm-2 control-label"> Gender</label>
								<div class="col-lg-4">
									<select id="gender" class="form-control"
										value="<j:out value="${electorProfile.gender}" />">
										<option value="male">Male</option>
										<option value="female">Female</option>
										<option value="other">Other</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-2 col-sm-2 control-label"> Mobile </label>
								<div class="col-lg-4">
									<input type="text" class="form-control" id="mobile"
										placeholder="Enter Your Mobile Number"
										value="<j:out value="${electorProfile.mobile}" />" required />
								</div>
								<label class="col-lg-2 col-sm-2 control-label"> Email </label>
								<div class="col-lg-4">
									<input type="email" class="form-control" id="email"
										placeholder="Enter Your Email"
										value="<j:out value="${electorProfile.email}" />" required />
								</div>
								<input type="hidden" id="appliedFor" value="editing" /> <input
									type="hidden" class="form-control" id="id"
									value="<j:out value="${electorProfile.id}" />" />
							</div>
						</div>
						<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
					</article>

				</li>

				<li>
					<article>
						<header>
							<address>III. Identity Information</address>
						</header>
						<div class="comcont">
							<div class="form-group">
								<label class="col-lg-2 col-sm-2 control-label"> Aadhar
									Number </label>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="aadhar"
										placeholder="Enter Your Mobile Number"
										value="<j:out value="${electorProfile.aadhar}" />" disabled />
								</div>
							</div>
						</div>
						<br /> <br /> <br />
					</article>
				</li>

				<li>
					<article>
						<header>
							<address>IV. Particulars Of Place Of Ordinary Residence</address>
						</header>
						<div class="comcont">
							<div class="form-group">
								<label class="col-lg-2 col-sm-2 control-label">
									Area/Street 1 </label>
								<div class="col-lg-4">
									<textarea rows="4" cols="50" class="form-control" id="area"
										placeholder="Please Enter details of your place of residence."><j:out
											value="${electorProfile.area}" /></textarea>
								</div>
								<label class="col-lg-2 col-sm-2 control-label"> </label>
								<div class="col-lg-4"></div>
							</div>
							<div class="form-group">
								<label class="col-lg-2 col-sm-2 control-label"> Land
									Mark </label>
								<div class="col-lg-4 ">
									<input type="text" class="form-control" id="landMark"
										placeholder="Enter Land Mark."
										value="<j:out value="${electorProfile.landMark}" />" />
								</div>
								<label class="col-lg-2 col-sm-2 control-label"> Pin Code
								</label>
								<div class="col-lg-4">
									<input type="text" class="form-control" id="pinCode"
										placeholder="Enter Pin" minlength="6" maxlength="6"
										value="<j:out value="${electorProfile.pinCode}" />" required />
								</div>
							</div>

							<div class="text-center">
								<div class="form-group">
									<div class="col-lg-offset-2 col-lg-8">
										<button type="submit" class="btn btn-danger" id="submit">SUBMIT</button>
										<button type="submit" class="btn btn-danger" id="delete">DELETE</button>
									</div>
								</div>
							</div>
							<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
							<br /> <br />
					</article>
				</li>

			</j:if>
		</ul>
	</div>
	
	</main>
</div>





<!-- Footer -->
<%@ include file="../../footer/userFooter.txt"%>