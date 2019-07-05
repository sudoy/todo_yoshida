<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="alert alert-success" role="alert">
	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	<span aria-hidden="true">&times;</span></button>

	<p><b>完了しました！</b><p>
	<!-- 成功メッセージもループで出力 -->
		<ul>
			<c:forEach items="${sessionScope['success']}" var="i">
				<li>${i}</li>
			</c:forEach>
		</ul>

</div><!--alert-success-->