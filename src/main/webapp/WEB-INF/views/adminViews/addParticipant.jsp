<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="x"%>

<!-- Header -->
<%@ include file="../../header/adminHeader.txt"%>

<!-- Body -->
<div class="wrapper row3 text-center">
	<div class="col-lg-30">
		<header class="panel-heading">
			<h4>
				<b>Member Description Form</b>
			</h4>
		</header>
		<font color="Red"> ${errMsg}</font>
		<x:form class="form-horizontal animate" action="addParticipant"
			modelAttribute="participant">
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label"> Select Party
				</label>
				<div class="col-lg-6">
					<select name="partyId" class="form-control">
						<j:forEach items="${partyList}" var="party">
							<option value=<j:out value="${party.id}"/>>
								<j:out value="${party.partyName}" />
							</option>
						</j:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label"> Select State
				</label>
				<div class="col-lg-6">
					<select name="participatingState" class="form-control">
						<option value="Select State">Select State</option>
						<option value="Andra Pradesh">Andra Pradesh</option>
						<option value="Maharashtra">Maharashtra</option>
						<option value="Karnataka">Karnataka</option>
						<option value="Assam">Assam</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label"> Full Name </label>
				<div class="col-lg-6">
					<input type="text" class="form-control" name="name"
						placeholder="Enter Name" title="Please Enter your officel name" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label"> Email </label>
				<div class="col-lg-6">
					<input type="text" class="form-control" name="email"
						placeholder="Enter Email" title="Please Enter your email" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label"> Mobile </label>
				<div class="col-lg-6">
					<input type="text" class="form-control" name="mobile"
						placeholder="Enter Mobile Number"
						title="Please enter your mobile number" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label"> Date of
					Birth </label>
				<div class="col-lg-6">
					<input type="Date" class="form-control" name="dob" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label"> Gender </label>
				<div class="col-lg-6">
					<select name="gender" class="form-control">
						<option value="male">Male</option>
						<option value="female">Female</option>
						<option value="other">Other</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label">
					Participating For </label>
				<div class="col-lg-6">
					<select name="post" class="form-control">
						<option value="mla">MLA</option>
						<option value="mp">MP</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label">
					Participating Place </label>
				<div class="col-lg-6">
					<input type="text" class="form-control" name="participatingPlace"
						placeholder="Enter Participating Place"
						title="Please enter participating place" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label"> Education </label>
				<div class="col-lg-6">
					<input type="text" class="form-control" name="education"
						placeholder="Enter Education Qualification"
						title="Please enter education" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label"> Property </label>
				<div class="col-lg-6">
					<input type="text" class="form-control" name="property"
						placeholder="Enter property" title="Please enter property value" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label"> Adhaar
					Number </label>
				<div class="col-lg-6">
					<input type="text" class="form-control" name="adhaar"
						placeholder="Enter Address" title="Please enter adhaar number" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label"> Police
					Record </label>
				<div class="col-lg-6">
					<select name="policeRecord" class="form-control">
						<option value="Select State">Select Option</option>
						<option value="yes">Yes</option>
						<option value="no">No</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 col-sm-2 control-label"> Address </label>
				<div class="col-lg-6">
					<textarea rows="4" cols="50"  class="form-control" name="address"
						placeholder="Enter Address" title="Please enter address" ></textarea>
				</div>
			</div>
			<div class="text-center">
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-8">
						<button type="submit" class="btn btn-danger">Submit</button>
					</div>
				</div>
			</div>
		</x:form>
	</div>
</div>


<!-- Footer -->
<%@ include file="../../footer/adminFooter.txt"%>