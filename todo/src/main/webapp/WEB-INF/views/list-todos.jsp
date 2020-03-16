<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<table class="table table-striped">
		<caption><spring:message code="todo.caption" /></caption>
		<thead>
			<tr>
				<th>Description</th>
				<th>Date</th>
				<th>Status</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.desc}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.status}</td>
					<td><a type="button" class="btn btn-primary" href="<c:url value='/update-todo/${todo.id}'/>">Edit</a>					
					    <a type="button" class="btn btn-warning" href="<c:url value='/delete-todo/${todo.id}'/>">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<a type="button" class="btn btn-success" href="<c:url value='/add-todo'/>">Add</a>
	</div>
</div>
<%@ include file="common/footer.jspf"%>