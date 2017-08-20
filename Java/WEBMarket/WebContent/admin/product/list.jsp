<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style1.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="${pageContext.request.contextPath}/js/public.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	function addProduct() {
		window.location.href = "${pageContext.request.contextPath}/adminAddPage";
	}
	
	function deleteProduct(pid) {
		var doDelete = confirm("是否确认删除？");
		if(doDelete){
			window.location.href = "${pageContext.request.contextPath}/adminDeleteProduct?pid="+pid;
		}
	}
	
	function checkPrice(id){
		var obj=document.getElementById(id);
		var checkSpan=document.getElementById("price");
		var reg=/(^[1-9]\d*(\.\d{1,2})?$)|(^0(\.\d{1,2})?$)/;
		if(obj.value.replace(/(^\s*)|(\s*$)/g,"")==""||obj.value==null){
			checkSpan.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		}else if(!reg.test(obj.value)){
			checkSpan.innerHTML="价格应为数字或为空！";
			checkSpan.style.color="red";
		}else{
			checkSpan.innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		}
	}
	
	window.onload=function(){
		var isDelete="${isDelete }";
		if(isDelete!=""){
			alert("删除失败！");
		}
		
	}
	
	$(function(){
		$("#is_hot").val("${condition.is_hot }");
		$("#cid").val("${condition.cid }");
		
		 /* $("#is_hot option[value='${condition.is_hot }']").prop("selected",true);
		 $("#cid option[value='${condition.cid }']").prop("selected",true); */
	});
</script>
</HEAD>
<body>
	<br>
	<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/adminSearchProduct"
		method="post">&nbsp;&nbsp;&nbsp;&nbsp;
		商品名称：<input type="text" name="pname" value="${condition.pname }">&nbsp;&nbsp;&nbsp;&nbsp;
		是否热门：<select name="is_hot" id="is_hot">
					<option value="">不限</option>
					<option value="1">是</option>
					<option value="0">否</option>
			   </select>&nbsp;&nbsp;&nbsp;&nbsp;
		价格范围：￥<input type="text" name="low_price" value="${condition.low_price }" id="low_price" style="width:50px" onblur="checkPrice(this.id)">元--
			        ￥<input type="text" name="high_price" value="${condition.high_price }" id="high_price" style="width:50px" onblur="checkPrice(this.id)">元
			        <span id="price">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
	  	产品种类：<select name="cid" id="cid">
	  				<option value="">不限</option>
	  				<c:forEach items="${categoryList }" var="category">
	  					<option value="${category.cid }">${category.cname }</option>
	  				</c:forEach>
			   </select>&nbsp;&nbsp;&nbsp;&nbsp;
			   <input type="submit" value="搜索">
			   
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0" style="margin-top:20px">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>商品列表</strong>
					</TD>
				</tr>
				<tr>
					<td class="ta_01" align="right">
						<button type="button" id="add" name="add" value="添加"
							class="button_add" onclick="addProduct()">
							&#28155;&#21152;</button>

					</td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

								<td align="center" width="18%">序号</td>
								<td align="center" width="17%">商品图片</td>
								<td align="center" width="17%">商品名称</td>
								<td align="center" width="17%">商品价格</td>
								<td align="center" width="17%">是否热门</td>
								<td width="7%" align="center">编辑</td>
								<td width="7%" align="center">删除</td>
							</tr>
							<c:forEach items="${productList }" var="product" varStatus="num">
								<c:if test="${product.isDelete==0 }">
									<tr onmouseover="this.style.backgroundColor = 'white'"
										onmouseout="this.style.backgroundColor = '#F5FAFE';">
										<td style="CURSOR: hand; HEIGHT: 22px" align="center"
											width="18%">${num.count }</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center"
											width="17%"><img width="40" height="45"
											src="${ pageContext.request.contextPath }/${product.pimage}"></td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center"
											width="17%">${product.pname }</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center"
											width="17%">${product.shop_price }</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center"
											width="17%">${product.is_hot==1?"是":"否 "}</td>
										<td align="center" style="HEIGHT: 22px"><a
											href="${pageContext.request.contextPath}/editProduct?pid=${product.pid }">
												<img
												src="${pageContext.request.contextPath}/images/i_edit.gif"
												border="0" style="CURSOR: hand">
										</a></td>

										<td align="center" style="HEIGHT: 22px"><a href="javascript:void(0);" onclick="deleteProduct('${product.pid }')">
												<img
												src="${pageContext.request.contextPath}/images/i_del.gif"
												width="16" height="16" border="0" style="CURSOR: hand">
										</a></td>
									</tr>
								</c:if>

							</c:forEach>
						</table>
					</td>
				</tr>

			</TBODY>
		</table>
	</form>
</body>
</HTML>

