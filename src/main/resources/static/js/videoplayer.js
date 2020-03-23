$(function () {
    $(document).ready(function () {
        console.log("videotype： "+$("#vtype").val());
        $.get({
            url: 'http://localhost:8080/loadVideoByType?vtype=' + $("#vtype").val(),//从这里开始，加载该相关视频的所有信息
            // data : {'test' : $('testMessage').val()},//不管用
            success: function (data, status) {//data：数据  ，status：状态
                if(data!=null){
                    var uid ="";
                    if($("#uid").val()!=null){
                        uid = $("#uid").val();
                    }else {
                        uid = $("#unid").val();
                    }
                    var html="";
                   $("#videolist").html("");
                    for (var i=0 ; i<=7;i++){
                        var vname = data[0][i].videoname;
                        var upname = data[1][i].username;
                        var pcount = data[0][i].playcount;
                        html+="<li style=\"float: left;\">"+
                            "<a href='loadVideoByVid?vid="+data[0][i].vid+"&uid="+uid+"'><img src=\""+data[0][i].videoface+"\" width=\"165px\" height=\"85px\" style=\" float: left; margin-bottom:10px;\"/></a>"+
                            "<h4 class=\"videotitle\">"+vname+"</h4>"+
                            "<br><p class=\"littleTitle\">"+upname+"</p>"+
                            "<br><p class=\"littleTitle\">播放量："+pcount+"</p>"
                            +"</li>";
                    }
                    $("#videolist").html(html);
                }
                console.log(status);
                if ($("#isfollow").val()==1){//表示已关注
                    $("#follow").css("width", "145px");
                    $("#follow").css("background", "#aca7ae");
                    $("#follow").attr("value","已关注");
                }else if ($("#isfollow").val()==0){
                    $("#follow").css("width", "195px");
                    $("#follow").css("background", "#43b5ef");
                    $("#follow").attr("value","+关注");//要细微改动
                }
            }
        });
        if($("#uid").val()!=null){//如果用户不为空时加载该用户的操作
        $.get({//获取用户对这个视频的操作
            url: 'http://localhost:8080/loadUserActionforThisVideo?uid=' + $("#uid").val()+'&vid='+$("#vid").val(),//从这里开始，加载该相关视频的所有信息
            // data : {'test' : $('testMessage').val()},//不管用
            success: function (data, status) {//data：数据  ，status：状态
                if(data!=null){
                    if(data.up==1){
                        $("#upimage").attr("src","../static/images/up2.png");
                    }else{
                        $("#upimage").attr("src","../static/images/up1.png");
                    }
                    if(data.down==1){
                        $("#downimage").attr("src","../static/images/down2.png");
                    }else{
                        $("#downimage").attr("src","../static/images/down1.png");
                    }
                    if(data.collect==1){
                        $("#collectimage").attr("src","../static/images/collect2.png");
                    }else{
                        $("#collectimage").attr("src","../static/images/collect1.png");
                    }
                }
                console.log(status+"up："+data.up+"down："+data.down+"collect："+data.collect);
            }
        });
        }
    });

})

/**
 * 具体的关注功能实现
 * @constructor
 */
function OnFollowClick() {//关注用
    if($("#isfollow").val()==1) {//已关注，点击后取关
        $("#follow").css("width", "195px");
        $("#follow").css("background", "#43b5ef");
        $("#isfollow").attr("value",0);
        $("#follow").attr("value","+关注");
    }else if ($("#isfollow").val()==0){//未关注，点击后关注
        $("#follow").css("width", "145px");
        $("#follow").css("background", "#aca7ae");
        $("#isfollow").attr("value",1);
        $("#follow").attr("value","已关注");
    }
    $.get({
        url: 'http://localhost:8080/updateisFollow?uid=' + $("#uid").val()+'&upid='+$("#videocreaterID").val()+'&isFollow='+$("#isfollow").val(),
        // data : {'test' : $('testMessage').val()},//不管用
        success: function (data, status) {//data：数据  ，status：状态
            console.log(status+"，关注状态修改成功");
        }
    });
    console.log("关注相关操作已完成");
}
function OnUpClick() {//点赞按钮
    if($("#isup").val()==0){
        $("#isup").attr("value",1);
        $("#upimage").attr("src","../static/images/up2.png");
    }else if ($("#isup").val()==1){
        $("#isup").attr("value",0);
        $("#upimage").attr("src","../static/images/up1.png");
    }
    ForUseraction("isup="+$("#isup").val()+"&isdown=2&iscollect=2");
    console.log("用户进行点赞操作");
}
function OnDownClick() {//点踩按钮
    if($("#isdown").val()==0){
        $("#isdown").attr("value",1);
        $("#downimage").attr("src","../static/images/down2.png");
    }else if ($("#isdown").val()==1){
        $("#isdown").attr("value",0);
        $("#downimage").attr("src","../static/images/down1.png");
    }
    ForUseraction("isdown="+$("#isdown").val()+"&isup=2&iscollect=2");
    console.log("用户进行点踩操作");
}
function OnCollectClick() {//收藏按钮
    if($("#iscollect").val()==0){
        $("#iscollect").attr("value",1);
        $("#collectimage").attr("src","../static/images/collect2.png");
    }else if($("#iscollect").val()==1){
        $("#iscollect").attr("value",0);
        $("#collectimage").attr("src","../static/images/collect1.png");
    }
    ForUseraction("iscollect="+$("#iscollect").val()+"&isdown=2&isup=2");
    console.log("用户进行收藏操作");
}
function ForUseraction(param) {//用户操作请求
    $.get({
        url: 'http://localhost:8080/updateUseraction?uid=' + $("#uid").val()+'&vid='+$("#vid").val()+"&"+param,
        success: function (data, status) {//data：数据  ，status：状态
            document.getElementById("upcount").innerText=data.putcount;
            document.getElementById("collectcount").innerText=data.collectcount;
            document.getElementById("downcount").innerText=data.downcount;
            console.log(status+"，用户操作已完成");
        }
    });
}