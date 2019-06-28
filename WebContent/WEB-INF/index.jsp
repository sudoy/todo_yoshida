<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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

				<tr>
					<td>1</td>
					<td><a href="update.html">テストテスト</a></td>
					<td>★★★</td>
					<td>2015/06/20</td>
				</tr>

				<tr>
					<td>2</td>
					<td><a href="update.html">テストテスト</a></td>
					<td>★</td>
					<td>2015/06/22</td>
				</tr>

				<tr>
					<td>3</td>
					<td><a href="update.html">テストテスト</a></td>
					<td>★★★</td>
					<td>2015/06/20</td>
				</tr>

				<tr>
					<td>4</td>
					<td><a href="update.html">テストテスト</a></td>
					<td>★★</td>
					<td></td>
				</tr>
			</table>

		</div><!--list-->

		<button type="button" class="btn btn-primary" onclick="location.href='entry.html'">追加</button>

	</div><!--body-->
	</div><!--color-->
	<jsp:include page="footer.jsp" />
</body>
</html>