<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<jsp:include page="header.jsp" />
<body>


	<div class="container-fluid top">
		<div class="container">
			<h1>Todoリスト</h1>
		</div>
	</div><!--topの閉じ-->
	<div class="color">
	<div class="container body">
		<div class="alert alert-success" role="alert">
		 <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		 <span aria-hidden="true">&times;</span></button>
			<p>

			<b>完了しました！</b><p>
			<ul>
				<li>No.27のToDoを更新しました。</li>
			</ul>
		</div><!--alert-success-->

		<div class="alert alert-danger" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
		 <span aria-hidden="true">&times;</span></button>
			<p>

			<b>エラーが発生しました！</b></p>
				<ul>
					<li>題名は入力必須です。</li>
					<li>題名は100字以内にしてください。</li>
					<li>期限は「YYYY/MM/DD」形式で入力してください。</li>
				</ul>
		</div><!--alert-danger-->

		<div class="container list">
			<table class="table">
				<tr>
					<th>#</th>
					<th>題名</th>
					<th>重要度</th>
					<th>期限</th>
				</tr>

			<!-- DBから取得した値をループで出力 -->

			<c:forEach var="i" items="${id}" varStatus="s">
				<tr>
					<td>${i}</td>
					<td><a href="update.html">${name[s.index]}</a></td>
					<td>${priority[s.index]}</td>
					<td>${timelimit[s.index]}</td>
				</tr>
			</c:forEach>

			</table>


		</div><!--list-->

		<button type="button" class="btn btn-primary" onclick="location.href='entry.html'">追加</button>

	</div><!--body-->
	</div><!--color-->
	<jsp:include page="footer.jsp" />
</body>
</html>