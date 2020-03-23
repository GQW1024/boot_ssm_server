$(function () {
    $(document).ready(function () {
    $.get({
        url: 'http://localhost:8080/loadAllVideoType',
        success: function (data, status) {//data：数据  ，status：状态
           var html = '';
           for (var i = 0;i<data.length;i++){
               html+="<option value='"+data[i].vtype+"'>" +data[i].vtype
                   "</option>";
           }
           $("#videotype").html(html);
            console.log(status+"，视频类型已加载完成");
        }
    }); //获取视频类型信息
    });
})