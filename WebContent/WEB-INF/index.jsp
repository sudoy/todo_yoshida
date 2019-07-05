<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<jsp:include page="header.jsp" />
<body>

	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <a class="navbar-brand" href="index.html">Todoリスト</a>
	    </div>
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav navbar-right">
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
	           aria-expanded="false">須藤雄一<span class="caret"></span></a>
	           <ul class="dropdown-menu">
	           		<li><a href="#">ログアウト</a></li>
	          </ul>
	        </li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>



	<div class="color">
	<div class="container body">



		<c:if test="${sessionScope['success'] != null}">
			<jsp:include page="_success.jsp" />
		</c:if>


		<div class="container list">
			<table class="table">

				<tr>
					<th>#</th>
					<th>題名</th>
					<th>重要度</th>
					<th>期限</th>
				</tr>
			<!-- DBから取得した値をループで出力 -->

			<c:forEach var="f" items="${form}">
				<tr>

				<!-- getでid値を送信する -->

					<td>${f.id}</td>
					<td><a href="update.html?id=${f.id}">${f.name}</a></td>
					<td>${f.priority}</td>
					<td>${f.timelimit}</td>

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