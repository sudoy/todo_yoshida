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

			<div class="submitform">
				<p><b>登録フォーム</b></p>
				<hr>
			</div><!--submitform-->
			<form class="form-horizontal" method="POST" action="entry.html">
	  			<div class="form-group">
	    			<label for="inputPassword3" class="col-sm-2 control-label">題名</label>
	    		<div class="col-sm-8">
					<input type="text" class="form-control" name="name" placeholder="題名">
	    		</div>
	  			</div>

	 		 <div class="form-group">
	    		<label for="inputPassword3" class="col-sm-2 control-label">詳細</label>
	    		<div class="col-sm-8">
	    			<textarea class="form-control" name="detail" placeholder="詳細"></textarea>
	    		</div>
	  		</div><!--form-group閉じ-->

	   		<div class="form-group">
	    		<label for="inputPassword3" class="col-sm-2 control-label">重要度</label>
	   			 <div class="col-sm-4" id="radio">
	    			<label class="radio-inline">
	 				<input type="radio" name="priority" id="inlineRadio1" value="3" checked>★★★
					</label><br>
					<label class="radio-inline">
	  				<input type="radio" name="priority" id="inlineRadio2" value="2">★★
					</label><br>
					<label class="radio-inline">
	  				<input type="radio" name="priority" id="inlineRadio3" value="1">★
					</label>
	    		</div><!--radio閉じ-->
	  		</div><!--form-group閉じ-->

	  		<div class="form-group">
	    		<label for="inputPassword3" class="col-sm-2 control-label">期限</label>
	    		<div class="col-sm-8">
					<input type="text" class="form-control" name="timelimit" placeholder="期限">
	    		</div>
	  		</div><!--form-group閉じ-->

			<div class="form-group">
	    		<div class="col-sm-offset-2 col-sm-4">
	    				<button type="button" class="btn btn-default"
	    				onclick="location.href='index.html'">キャンセル</button>
	    				<button type="submit" class="btn btn-primary">追加</button>
				</div>
			</div><!--form-group閉じ-->
	  		</form><!--form-horizontal-->
		</div><!--body-->
	</div>
	<jsp:include page="footer.jsp" />

</body>
</html>