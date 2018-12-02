<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- bootstrap start -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>page title</title>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.3.1.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<!-- bootstrap end -->
<title>Insert title here</title>
</head>
<script type="text/javascript">

var size = ${get_usernumVOs.size()};
var usernumVO =${get_usernumVOs};
$(document).ready(function(){
	for(let i=0;i<size;i++){
		balance_show(usernumVO[i][0],usernumVO[i][1]);
	 
	}
})
    
 function balance_show(bank_name,fintech_use_num){  
    $.ajax({
	url : 'https://testapi.open-platform.or.kr/account/balance',
	type : 'get',
	headers : {
		"Authorization" : "Bearer" + " ${sessionScope.access_token}"
	},
	data : {
		'fintech_use_num' : fintech_use_num,
		'tran_dtime' : '${get_transactionVO.tran_dtime}'
		
	},
	success : function(data) {
		console.log(data)
		
		var items =
			
				   "<tr><td>"+bank_name+"</td>"+
				   "<td>"+data.product_name+"</td>"+ 
				   "<td>"+data.balance_amt+"</td>"+
				   "<td><a href='list?bank_name="+bank_name+"'><input type='button' value='거래내역'/></a></td></tr>";
		$("#balance").append(items);
	}
	});
 }


		
	
</script>
<body>
	${sessionScope.id} 사용자가 로그인 중입니다.
	<br /> ${sessionScope.shinhan} 은행의 이용정보
	<br /> ${sessionScope.access_token } 엑세스 토큰
	<br /> ${sessionScope.woori } 우리은행의 이용정보
	<br /> ${get_transactionVO.inquiry_type}
	<br /> ${get_transactionVO.from_date}
	<br /> ${get_transactionVO.to_date}
	<br /> ${get_transactionVO.sort_order}
	<br /> ${get_transactionVO.page_index}
	<br /> ${get_transactionVO.tran_dtime}
	<br />${get_usernumVOs.get(0).bank_name}
	<br />${get_usernumVOs.get(1).bank_name}
	<br />${get_usernumVOs.size()}
	<hr />
	<table id="balance" border=1>
		<tr>
			<th>은행명</th>
		    <th>계좌명</th>
		    <th>계좌잔액</th>
			<th>거래내역</th>
		</tr>
	</table>
	

</body>
</html>
