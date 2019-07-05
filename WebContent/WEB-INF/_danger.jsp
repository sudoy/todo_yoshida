<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="alert alert-danger" role="alert">
	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	<span aria-hidden="true">&times;</span></button>

	<p><b>エラーが発生しました！</b></p>
	<!-- エラーメッセージをループで抽出する -->
		<ul>
			<c:forEach items="${sessionScope['error']}" var="i">
				<li>${i}</li>
			</c:forEach>
		</ul>

</div><!--alert-danger-->