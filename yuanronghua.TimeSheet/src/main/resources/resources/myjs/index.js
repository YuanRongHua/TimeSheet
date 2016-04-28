	var login_name = $.cookie('name');
	var login_id = $.cookie('id');
	$("#login_span").html(login_name);
	
	var pageSize = 10;
	var totalPage = 1;
	var totalRecords = 0;
	var pageNo = 1;
	var curentPage = 1;
	var curentVal;
					
	QueryData(0,pageSize);

	function QueryData(start, limit){
		$.getJSON('query.json?start='+start+'&pageSize='+limit, function(data) {
			$('#main_table tbody').html('<tr><th style="width:5%">#</th><th style="width:10%">姓名</th><th style="width:18%">时间</th><th style="width:20%" >地点</th><th style="width:10%" >时长</th><th style="width:10%" >日薪</th><th style="width:10%" >BOSS</th><th  >操作</th></tr>');
			  $.each(data.result.list, function(key, val) {
				 // alert(" <tr class='tr_content'><td>"+val.id+"</td><td>"+val.dateTime+"</td><td>"+val.address+"</td><td>"+val.time_hour+"</td><td>"+val.salary+"</td><td> <button type='button' class='btn btn-info' onclick='updateThis1("+val+");' > 修改 </button>&nbsp;<button type='button' class='btn btn-danger' onclick='deleteThis('"+val.id+"')'> 删除 </button></td></tr>");
				  var valString = JSON.stringify(val);
				  $('#main_table tbody').append(" <tr class='tr_content'><td>"+val.id+"</td><td>"+login_name+"</td><td>"+val.dateTime+"</td><td>"+val.address+"</td><td>"+val.time_hour+"</td><td>"+val.salary+"</td><td>"+val.boss_name+"</td><td> <button type='button' class='btn btn-info' onclick='updateThis1("+valString+");' > 修改 </button>&nbsp;<button type='button' class='btn btn-danger' onclick='deleteThis("+val.id+")'> 删除 </button></td></tr>");
				  return;
			  });
			  totalRecords = data.result.count;
			  totalPage =  Math.ceil(Number(totalRecords)/10);
			//init
				$(function(){
					//生成分页
					//有些参数是可选的，比如lang，若不传有默认值
					kkpager.generPageHtml({
						pno : pageNo,
						//总页码
						total : totalPage,
						//总数据条数
						totalRecords : totalRecords,
						/*
						,lang				: {
							firstPageText			: '首页',
							firstPageTipText		: '首页',
							lastPageText			: '尾页',
							lastPageTipText			: '尾页',
							prePageText				: '上一页',
							prePageTipText			: '上一页',
							nextPageText			: '下一页',
							nextPageTipText			: '下一页',
							totalPageBeforeText		: '共',
							totalPageAfterText		: '页',
							currPageBeforeText		: '当前第',
							currPageAfterText		: '页',
							totalInfoSplitStr		: '/',
							totalRecordsBeforeText	: '共',
							totalRecordsAfterText	: '条数据',
							gopageBeforeText		: ' 转到',
							gopageButtonOkText		: '确定',
							gopageAfterText			: '页',
							buttonTipBeforeText		: '第',
							buttonTipAfterText		: '页'
						}*/
						
						//,
						mode : 'click',//默认值是link，可选link或者click
						click : function(n){
							this.selectPage(n);
							QueryData((n-1)*pageSize,pageSize);
							curentPage = n;
						  return true;
						}
					});
				});

		});
	}
	
	$(function() {
		$( "#dateTime" ).datepicker({
			inline: true,
			showOtherMonths: true,
			dateFormat:'yy-mm-dd',
			regional:'zh-CN',
		})
		.datepicker('widget').wrap('<div class="ll-skin-cangas"/>');
	});
	
	$(function() {
		$( "#begin_time" ).datepicker({
			inline: true,
			showOtherMonths: true,
			dateFormat:'yy-mm-dd',
			regional:'zh-CN',
		})
		.datepicker('widget').wrap('<div class="ll-skin-cangas"/>');
	});
	
	$(function() {
		$( "#end_time" ).datepicker({
			inline: true,
			showOtherMonths: true,
			dateFormat:'yy-mm-dd',
			regional:'zh-CN',
		})
		.datepicker('widget').wrap('<div class="ll-skin-cangas"/>');
	});
	
	 $("#submit").click(function () {
		
		$("#account_id").val(login_id);
		var id = $("#id").val();
		if(id == null || id==''){
			var data = serializeArrayToJson($("#timesheet_form").serializeArray());
			            var options = {
			                url: '/add.do',
			                type: 'post',
			                dataType: 'json',
			                data: data,
			                success: function (data) {
								if(data.restCode == 200){
									alert("新增成功!");
									$("input[type=reset]").trigger("click");
									$('#myModal').modal('hide');
									QueryData((curentPage-1)*pageSize,pageSize);
								}else{
									alert("操作失败!");
								}
								
							}
			            };
			            $.ajax(options);
			            return false;
		}else{
			var data = serializeArrayToJson($("#timesheet_form").serializeArray());
			            var options = {
			                url: '/update.do',
			                type: 'post',
			                dataType: 'json',
			                data: data,
			                success: function (data) {
								if(data.restCode == 200){
									alert("修改成功!");
									$("input[type=reset]").trigger("click");
									$('#myModal').modal('hide');
									QueryData((curentPage-1)*pageSize,pageSize);
								}else{
									alert("操作失败!");
								}
								
							}
			            };
			            $.ajax(options);
			            return false;
		}
      });
	
	function deleteThis(id){
		 var data ='{"id":"'+id+'"}';
		  $.post("/remove.do",
		  data,
		  function(data,status){
			QueryData((curentPage-1)*pageSize,pageSize);
		    alert("删除成功!");
		  });
	}
	
	function updateThis1(val){
		$("#id").val(val.id)
		$("#dateTime").val(val.dateTime);
		$("#address").val(val.address)
		$("#time_hour").val(val.time_hour)
		$("#salary").val(val.salary)
		$("#boss_id").val(val.boss_id)
		$("#account_id").val(val.account_id)
		$("#boss_name").val(val.boss_name)
		$('#myModal').modal('show');
	}
	
	function dateTimeOnclick(){
		var begin_time = $("#begin_time").val();
		var end_time = $("#end_time").val();
		var salary_list_html="<div><select multiple class=\"form-control\">";
		 salary_list_html += " <option><table ><tr><th>时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><th>工时</th><th>日薪</th></tr></table></option>"
		if(begin_time.length>1 && end_time.length>1 ){
			$.getJSON("queryByDate.json?begin_time="+begin_time+"&end_time="+end_time,function(data){
				 var days = data.result.count;
				 var hours = 0;
				 var pay = 0;
				 $.each(data.result.list, function(key, val) {
					 hours += parseInt(val.time_hour);
					 pay += parseInt(val.salary);
					 salary_list_html += " <option><table><tr><td width=\"50px\">"+val.dateTime+"</td><td>"+val.time_hour+"</td><td>"+val.salary+"</td></tr></table></option>"
				 });
				$("#span-name").html(login_name);
				$("#span-begin-time").html(begin_time+" ~ ");
				$("#span-end-time").html(end_time);
				$("#span-days").html(days);
				$("#span-hours").html(hours);
				$("#span-pay").html(pay);
				
				 salary_list_html += "</select></div>";
				
				$('#salary_list_button').popover({
					content:salary_list_html,
					html:true
				});
			});
		}
	}
	
 