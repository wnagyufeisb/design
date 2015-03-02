<script>
	$(document).ready(function() {
			var dayy = $("#dayTime").val();
			var monthy = $("#monthTime").val();
			var yeary = $("#yearTime").val();
			var nowDateM =formatTop(yeary+'',monthy+'',dayy+'');
			var newDay = formatDM(dayy);
		$('#calendar').fullCalendar({
			day:newDay,
			titleFormat:{month:'YYYY-MM'+'-'+newDay,week:'YYYY-MM-DD dddd',day:'YYYY-MM-DD dddd'},
			buttonText : {agendaDay: '日',agendaWeek: '周',month: '月'},
			header : {left: 'title', center: 'agendaDay agendaWeek month', right: 'today prev, next'},
			aspectRatio : 1.35,
			weekMode : 'liquid',
			dayNamesShort:['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],
			dayNames:['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],
			allDayText: '全天',
			allDaySlot:false,
			firstHour : 12 ,
			dayClick: function(date, jsEvent, view) {
				var dates = new Date();
				if(date.format() == formatD(dates)){
					var nowDate = format(dates);
				}else {
					var nowDate = getNewTime(date.format());
				}
				
				$("#startTime").val(nowDate);
				$(this).attr("data-toggle","modal");
				$(this).attr("href","#memoForm");
   			},
   			eventMouseover : function(event, jsEvent, view) {
   				$("#floatDiv").html(event.title);
   				$("#floatSection").css("display","block");
   			},
   			eventMouseout : function( event, jsEvent, view ) {
   				$("#floatSection").css("display","none");
   			},
   			eventClick: function(calEvent, jsEvent, view) {	
   			//  ----------------------------请求编辑  删除----开始------------------------------------------------     -->
   			var subTitle = calEvent.title;
   			var person = subTitle.substr(0,1);
   			var time = $(".fc-left h2").html();
   			var memoType = $("#memoType").val();
   			if(person=='我')  {
				var memoCode = calEvent.id;
				$.ajax
				({
					type : "POST",
					url : "${rc.contextPath}/memo/showOneMemoInfo",
					data : {
						"memoCode" : memoCode
					},
					success : 
						function(data) {	
							$("#updateMemoForm").html(data);
							$("#OaSearchStaff").OaSearch();
							$("#timem").val($(".fc-left h2").html());
							$("#memoTypem").val($("#memoType").val());
							$("#memoCode").val(memoCode);
							$("#deleteOneMemo").click(function(){
								window.location.href="${rc.contextPath}/memo/deleteOneMemo?memoCode="+memoCode;
							});
							$(".js_Min").datepicker({
            					format: 'yyyy-mm-dd hh:ii:s',
            					startView: 3,   //默认打开是年试图
            					autoclose: true,  //选择后自动关闭
            					todayBtn: true,  //选择今天的按钮
            					minView: 0   //只能选到年试图  （0 代表能选到分钟、1 代表能选到小时、2 代表能选到日 ）
        					}).on('changeDate', function (ev) {
            					$(".js_Min").datepicker('hide');    //隐藏开始时间面板
        					});
						},
					error :
						function() {
							alert( "显示请求失败了...." );
						}
				});	
				$(this).attr("data-toggle","modal");
				$(this).attr("href","#updateMemoForm");
			}else{
				alert("不是您添加的备忘您不能修改哟...");
			}
				//   ----------------------------请求编辑  删除----结束------------------------------------------------     -->
  			},
  			eventLimit: true, // allow "more" link when too many events
			events: ${json}
		});	
		$('#calendar').fullCalendar( 'gotoDate', nowDateM);
	});

</script>