/*-------------------------------------------------------------------------
 * 版权所有：北京光宇在线科技有限责任公司
 * 作者：陈巧玲
 * 联系方式：chenqiaoling@gyyx.cn
 * 创建时间： 2014/8/11
 * 版本号：v1.0
 * 修改：李根 at 2014-12-1
 * 内容： 档案管理页面 列表页

 * -------------------------------------------------------------------------*/
$(function () {

    /*中英文数字*/


    //机构
    //$(".js_agencySelect").agencySelect({
    //    hidCode: $("#PersonalFileList").find("input[name='AgencyCode']"), /*隐藏inputID*/
    //    hidName: $("#PersonalFileList").find("input[name='AgencyName']")/*hidden*/
    //});
    //选择机构
    $(".js_agencySelectForPost").agencyCallback({
        hidCode: $("#PersonalFileList").find("input[name='AgencyCode']"), /*隐藏inputID*/
        hidName: $("#PersonalFileList").find("input[name='AgencyNameForPost']"), /*hidden*/
        hidDiv: ".js_agencySelectListForPost",
        getPostList: true,
        PostSelect: $("#PersonalFileList").find("select[name='PostCodeD']")
    });
    if ($("input[name='AgencyCode']").val() > 0) {
        $.ajax({
            url: "http://oa.gyyx.cn/post/agencyposts/",
            type: "GET",
            dataType: "jsonp",
            jsonp: "jsoncallback",
            data: {
                id: $("input[name='AgencyCode']").val(),
                r: Math.random()
            },
            success: function (d) {
                if (d.Ret == 0) { /*获取岗位成功*/
                    if (d.Data.length != 0) {
                        /*有岗位数据*/
                        $("#PostSelect").empty();
                        $.each(d.Data, function (i, item) {
                            var options = $('<option value="' + item.Code + '">' + item.Name + '</option>');
                            $("#PostSelect").append(options);
                        });
                        $("#PostSelect").val($("input[name='PostCode']").val());
                    }
                } else {
                    alert(d.Message);
                }
            }
        });
    }
    //获取机构列表
    $(".js_agencySelect").agencyCallback({
        hidCode: $("#BatchConfirmation").find("input[name='BCAgencyCode']"), /*隐藏inputID*/
        hidName: $("#BatchConfirmation").find("input[name='BCAgencyName']") /*hidden*/
    });
});
