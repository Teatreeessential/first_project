<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<!-- bootstrap start -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title> page title </title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.3.1.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<!-- bootstrap end -->
<script type="text/javascript" 
    src="https://www.gstatic.com/charts/loader.js">
</script>
<script type="text/javascript">
var bank_name = "${Get_UseNumVO.bank_name}";
var fintech_use_num = "${Get_UseNumVO.fintech_use_num}";

$(document).ready(function(){
	
	 
	transaction_list(fintech_use_num); 
    $('#btn').click(function(){
    	report(fintech_use_num)
    });
})


function transaction_list(fintech_use_num){ //거래내역 뿌리는 곳
$.ajax({
		    type:'get',
			headers: {
		    	"Authorization": "Bearer"+" ${sessionScope.access_token}"
		        	                    
		    },
		    
		    url:"https://testapi.open-platform.or.kr/v1.0/account/transaction_list",
			data:{"fintech_use_num":fintech_use_num,
			      "inquiry_type":"${get_transactionVO.inquiry_type}",
			      "from_date":"${get_transactionVO.from_date}",
			      "to_date":"${get_transactionVO.to_date}",
			      "sort_order":"${get_transactionVO.sort_order}",
			      "page_index":"${get_transactionVO.page_index}",
			      "tran_dtime":"${get_transactionVO.tran_dtime}"
			      },
			success:function(data){
				let items  ="<tr><th>거래일자</th>"
                           +"	 <th>거래시간</th>"
                           +"	 <th>입출금내역</th>"
                           +"	 <th>거래금액</th>"
                           +"	 <th>거래후금액</th>"
                           +"	 <th>거래점명</th>"
                           +"	 <th>구분</th></tr>"
                           	 
                           
				$.each(data.res_list,function(index,item){
			    	items += '<tr><td>' + item.tran_date +'</td>' //거래일자
			    	      + '<td>' + item.tran_time +'</td>' //거래시간
			    	      + '<td>' + item.inout_type +'</td>' //입출금
			    	      + '<td>' + item.tran_amt +'</td>' //거래금액                   
			    	      + '<td>' + item.after_balance_amt +'</td>' //거래후 금액                   
			    	      + '<td>' + item.branch_name +'</td>' //거래점명
			    	      + '<td><select id="option'+index+'" onchange=test(this.value,"'+ item.branch_name+'","'+item.tran_date+'")>'
			    	      +   '<option value="----">선택하세요</option>'
			    	      +   '<option value="간식">간식/음료</option>'
			    	      +   '<option value="의료">의료</option>'
			    	      +   '<option value="등등">등등</option>'
			    	      +   '<option value="volvo">Volvo</option>'
			    	      +  '</select></td>'
			    	      
			              
				});  
			    
				$('#list').html(items);
				
				
		    }
			
    })
}

function test(v, br,trandate) {
	if (v === '----') return;
	if (confirm('저장하시겠습니까?')) {
		alert("소비 성향이 업데이트 되었습니다.")
		location.href = 'save?branch_name=' + br + '&category='+v+'&trandate='+trandate;		
	    
	}
}

function report(fintech_use_num){
	$.ajax({
				    type:'get',
					headers: {
				    	"Authorization": "Bearer"+" ${sessionScope.access_token}"
				        	                    
				    },
				    
				    url:"https://testapi.open-platform.or.kr/v1.0/account/transaction_list",
					data:{"fintech_use_num":fintech_use_num,
					      "inquiry_type":"${get_transactionVO.inquiry_type}",
					      "from_date":"${get_transactionVO.from_date}",
					      "to_date":"${get_transactionVO.to_date}",
					      "sort_order":"${get_transactionVO.sort_order}",
					      "page_index":"${get_transactionVO.page_index}",
					      "tran_dtime":"${get_transactionVO.tran_dtime}"
					      },
					success:function(data){
						var sum_consume=0;
						var sum_income=0;
							$.each(data.res_list,function(index,item){
						    	if(item.inout_type==="입금"){
						    		sum_income += parseInt(item.tran_amt);
						    		           
						    		console.log("입금"+item.tran_amt);
						    		
						    	} 
						    	if(item.inout_type==="출금"){
						    		
						    		sum_consume += parseInt(item.tran_amt);
						    		console.log("지출"+item.tran_amt);
						    	}
						    }) 
						  
				        drawChart(sum_consume,sum_income);    
					}
					
	})
}

function drawChart() {
    // 구글 차트는 데이터 테이블이라는 객체로 차트의 데이터를 전달한다.
    var data = new google.visualization.DataTable();
    //열 설정 2개를 설정하고 데이터 타입, 열이름
    data.addColumn('string', 'Topping');
    data.addColumn('number', 'Slices');
    //행 추가 5개의 행을 추가한다. 
    //파이차트는  전체 합의 비율로 표시
    data.addRows([
      ['Mushrooms', 3],
      ['Onions', 2],
      ['Olives', 1],
      ['Zucchini', 1],
      ['Pepperoni', 3]
    ]);
    // chart 옵션 설정 범례, 가로 세로 
    var options = {'title':'지출과수입',
                   'width':400,
                   'height':300};
    // 파이 차트 객체 생성 및 div 태그에 내용 전달
    var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
    //차트 그리고 태그, 옵션
    chart.draw(data, options);
}

</script>    
    
    
</head>
<body>
  <table id="list" border=1>
   
  </table>
  <div><input type="button" id="btn" value="총지출"></div>
  <div id = "chart_div"></div>
</body>
</html>