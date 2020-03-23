$(function () {//login.html 用
    $("#useraccnum").blur(function () {//在#useraccnum获得鼠标焦点时，检测用户名是否存在，下同
        $.get({
            url : 'http://localhost:8080/selUseraccnum?useraccnum='+$('#useraccnum').val(),
            // data : {'test' : $('testMessage').val()},//不管用
            success:function (data , status) {//data：数据  ，status：状态
                console.log(data);
                // $('#testMessage').val(data);
                if(data){
                    $("#userinfo").css("color","green");
                    $("#userinfo").html("用户名无误");
                }else{
                    $("#userinfo").css("color","red");
                    $("#userinfo").html("此用户名不存在");
                }
            }
        });
    });
    $("#registeruseraccnum").blur(function () {//检测账户是否存在
        $.get({
            url : 'http://localhost:8080/selUseraccnum?useraccnum='+$('#registeruseraccnum').val(),
            // data : {'test' : $('testMessage').val()},//不管用
            success:function (data , status) {//data：数据  ，status：状态
                console.log(data);
                // $('#testMessage').val(data);
                if(data){
                    $("#userinfo1").css("color","red");
                    $("#userinfo1").html("该账户不可注册");
                }else{
                    $("#userinfo1").css("color","green");
                    $("#userinfo1").html("该账户可注册");
                }
            }
        });
    });
    $("#username").blur(function () {//检测用户昵称是否存在
        $.get({
            url : 'http://localhost:8080/selUsername?username='+$('#username').val(),
            // data : {'test' : $('testMessage').val()},//不管用
            success:function (data , status) {//data：数据  ，status：状态
                console.log(data);
                // $('#testMessage').val(data);
                if(data){
                    $("#userinfo2").css("color","red");
                    $("#userinfo2").html("用户昵称不可用");
                }else{
                    $("#userinfo2").css("color","green");
                    $("#userinfo2").html("可使用昵称");
                }
            }
        });
    });
})