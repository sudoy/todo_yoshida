<%@ page language="java" pageEncoding="UTF-8"%>
<div class="alert alert-success" role="alert">
	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
	<span aria-hidden="true">&times;</span></button>

	<p><b>完了しました！</b><p>

		<ul>
			<li>#${sessionScope['id']}を${sessionScope['message']}しました。</li>
		</ul>

</div><!--alert-success-->