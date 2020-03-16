<%@ include file="common/header.jspf"%>
<div class="container">
	<p>
		<font color="red">${errorMessage}</font>
	</p>Please Login...
	<p>
	<form action="<spring:url value="/signin"/>" method="POST">
		<fieldset class="form-group">
			<label>Name</label> <input name="username" type="text" class="form-control" />
		</fieldset>
		<fieldset class="form-group">
			<label>Password</label> <input name="password" type="password" class="form-control" />
		</fieldset>
		<button type="submit" class="btn btn-success">Submit</button>
	</form>

</div>

<%@ include file="common/footer.jspf"%>