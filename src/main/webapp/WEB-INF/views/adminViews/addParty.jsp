<%@ taglib uri="http://www.springframework.org/tags/form" prefix="x"%>

<!-- Header -->
<%@ include file="../../header/adminHeader.txt"%>

<!-- 
	<h1>
		<center>Add Party</center>
	</h1>
	<x:form class="modal-content animate" action="addPartyDescription" modelAttribute="addParty"
		style="background-color: #b8b894">
		<div class="container">
			<label><b>PARTY NAME</b></label> 
				<input type="text" placeholder="Enter Party name" name="partyName" required> 
			<label><b>PARTY EMAIL</b></label> 
				<input type="text" placeholder="Enter Party email" name="partyEmail" required> 
			<label><b>Description</b></label><br>
				<textarea rows="4" cols="50" placeholder="Enter Party Description" name="partyDescription"> </textarea><br> 
			<label><b>MEMBERS FOR MP</b></label> 
				<input type="text" placeholder="Enter the list of MP members with comma seperated" required name="mpMembers"><br> <br>
			<label><b>MEMBERS FOR MLA</b></label> 
				<input type="text" placeholder="Enter the list of MLA members with comma seperated" required name="mlaMembers"><br> <br>
			<div class="clearfix">
				<button type="button" onclick="" class="cancelbtn">Cancel</button>
				<button type="submit" class="signupbtn">ADD</button>
			</div>
		</div>
	</x:form>
-->

<!-- Body -->
	<div class="wrapper row3">
		<br/>
		<div class="sectiontitle">
			<div class="col-lg-15">
				<header class="panel-heading">
					<h4>
						<b>Add Party</b>
					</h4>
				</header>
				<font color="Red"> ${errMsg}</font>
				<x:form class="form-horizontal animate" action="addPartyDescription"
					modelAttribute="addParty">
					
				<div class="form-group">
					<label class="col-lg-3 col-sm-2 control-label"> Party Name </label>
					<div class="col-lg-9">
						<input type="text" class="form-control" name="partyName" 
						placeholder="Enter Party Name" title="Please enter name of the party"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-lg-3 col-sm-2 control-label"> Party Email </label>
					<div class="col-lg-9">
						<input type="text" class="form-control" name="partyEmail" 
						placeholder="Enter party email" title="Please enter party email"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 col-sm-2 control-label"> Party Description </label>
					<div class="col-lg-9">
						<textarea rows="4" cols="50" class="form-control" name="partyDescription" 
						placeholder="Enter party description" title="Enter party description"></textarea>
					</div>
				</div>

				<div class="form-group">
					<label class="col-lg-3 col-sm-2 control-label"> MP Members </label>
					<div class="col-lg-9">
						<input type="text" class="form-control" name="mpMembers" 
						placeholder="Enter the list of MP members with comma seperated" title="Enter the list of MP members with comma seperated"/>
					</div>
				</div>

				<div class="form-group">
					<label class="col-lg-3 col-sm-2 control-label"> MLA Members </label>
					<div class="col-lg-9">
						<input type="text" class="form-control" name="mlaMembers" 
						placeholder="Enter the list of MLA members with comma seperated" title="Enter the list of MLA members with comma seperated"/>
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
	</div>