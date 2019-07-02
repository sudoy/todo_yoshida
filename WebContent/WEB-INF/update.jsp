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

	<c:if test="${error != null}">

		<jsp:include page="_danger.jsp" />

	</c:if>

		<div class="container updateform">
			<p><b>更新フォーム</b></p>
			<hr>
		<form class="form-horizontal" method="POST" action ="update.html">

				<input type="hidden" name="id" value="${form.id}">

  			<div class="form-group">
    			<label for="inputPassword3" class="col-sm-2 control-label">題名</label>
    		<div class="col-sm-8">
				<input type="text" class="form-control" name="name" placeholder="題名"
				value="${form.name}">
    		</div>
  		</div><!--form-group閉じ-->

 		 <div class="form-group">
    		<label for="inputPassword3" class="col-sm-2 control-label">詳細</label>
    		<div class="col-sm-8">
    			<textarea class="form-control" name="detail" placeholder="詳細">${form.detail}</textarea>
    		</div>
  		</div><!--form-group閉じ-->

   		<div class="form-group">
    		<label for="inputPassword3" class="col-sm-2 control-label">重要度</label>
   			 <div class="col-sm-4" id="radio">
    			<label class="radio-inline">
 				<input type="radio" name="priority" id="inlineRadio3" value="3"
 				<c:if test="${form.priority == 3}">checked</c:if>>★★★
				</label><br>
				<label class="radio-inline">
  				<input type="radio" name="priority" id="inlineRadio2" value="2"
  				<c:if test="${form.priority == 2}">checked</c:if>>★★
				</label><br>
				<label class="radio-inline">
  				<input type="radio" name="priority" id="inlineRadio1" value="1"
  				<c:if test="${form.priority == 1}">checked</c:if>>★
				</label>
    		</div><!--radio閉じ-->
  		</div><!--form-group閉じ-->

  		<div class="form-group">
    		<label for="inputPassword3" class="col-sm-2 control-label">期限</label>
    		<div class="col-sm-8">
				<input type="text" class="form-control" name="timelimit" placeholder="期限"
				value="${form.timelimit}">
    		</div>
  		</div><!--form-group閉じ-->

		<div class="form-group">
    		<div class="col-sm-offset-2 col-sm-8">
    			<button type="button" class="btn btn-default"
    			onclick="location.href='index.html'">キャンセル</button>
    			<button type="submit" class="btn btn-primary">更新</button>
    			<button type="button" class="btn btn-danger"
    			onclick="location.href='index.html'">削除</button>
			</div>
		</div><!--form-group閉じ-->

  		</form><!--form-horizontal-->
		</div><!--submitform-->
	</div><!--body-->
	</div><!--color-->
	<jsp:include page="footer.jsp" />
</body>
</html>