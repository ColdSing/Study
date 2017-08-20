<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!-- 登录 注册 购物车... -->
<div class="container-fluid">
	<div class="col-md-4">
		<img src="img/logo2.png" />
	</div>
	<div class="col-md-5">
		<img src="img/header.png" />
	</div>
	<div class="col-md-3" style="padding-top:20px">
		<ol class="list-inline">
			<c:if test="${empty user }">
				<li><a href="login.jsp">登录</a></li>
				<li><a href="register.jsp">注册</a></li>
			</c:if>
			<c:if test="${!(empty user) }">
				${user.username }
				<li><a href="${pageContext.request.contextPath }/logout">退出</a></li>
			</c:if>
			<li><a href="cart.jsp">购物车</a></li>
			<li><a href="order_list.jsp">我的订单</a></li>
		</ol>
	</div>
</div>

<!-- 导航条 -->
<div class="container-fluid">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">首页</a>
			</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="product_list.htm">手机数码<span class="sr-only">(current)</span></a></li>
					<li><a href="#">电脑办公</a></li>
					<li><a href="#">电脑办公</a></li>
					<li><a href="#">电脑办公</a></li>
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group" style="position: relative;">
						<input  id="serchInput" class="form-control" placeholder="Search" onkeyup="showTips(this)" >
						<div id="searchDiv"  style="display: none; position: absolute;width: 195px; height: auto; z-index: 1000; background-color: white; border: 1px solid #2AABD2; border-radius: 5px;" >
							
						</div>
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<script type="text/javascript" src="js/jquery-1.11.3.min.js" ></script>
				<script type="text/javascript" >
					function showTips(obj){
						var serchWord = $(obj).val();
						$.ajax({
							type:"post",
							url:"${pageContext.request.contextPath }/ajaxIndexSerch",
							async:true,
							data:{"serchWord":serchWord},
							dataType:"json",
							success: function(data){
								$("#searchDiv").empty();
								var pnames=data.pnameList;
								if(pnames.length>1){
	    							for (var i=0;i<pnames.length;i++){
	    								$("#searchDiv").append("<div style='padding:5px;cursor:pointer ' onmouseover='fnover(this)'  onmouseout='fnout(this)' onclick='fnclick(this)'>"+pnames[i]+"</div>");
	    								if(i>10){
	    									break;
	    								}
	    							}
	    							$("#searchDiv").css("display","block");
	    						}
    						}

						});
					}
				function fnover(obj){
					$(obj).css("background","#28A4C9");
				}
				
				function fnout(obj){
					$(obj).css("background","white");
				}
				
				function fnclick(obj){
					var wd=$(obj).html();
					$("#serchInput").val(wd);
					$("#searchDiv").css("display","none");
				}
				
				
				</script>
			</div>
		</div>
	</nav>
</div>