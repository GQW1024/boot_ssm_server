function loadNowPage(pagenum) {//分页用
        $.get({
            url : 'http://localhost:8080/loadVideoByPagenum?pagenum='+pagenum,
            // data : {'test' : $('testMessage').val()},//不管用
            success:function (data , status) {//data：数据  ，status：状态
                console.log(status);
                // $('#testMessage').val(data);
                var html="";
                var uid ="";
                if($("#uid").val()!=null){
                    uid = $("#uid").val();
                }else {
                    uid = $("#unid").val();
                }
                $("#AllVideo").html(html);
                for(var i=0 ; i<=11 ; i++){
                    if(data[i]!=null){
                        html += "<li>"+
                            " <p id=\"videoname\" style=\"float: left;\">"+data[i].videoname+"</p>"+
                            "<a href='loadVideoByVid?vid="+data[i].vid+"&uid="+uid+"'><img class=\"img-responsive\" src=\""+data[i].videoface+"\"></img>"+
                            "<p id=\"playcount\">"+data[i].playcount+"</p>&nbsp;<p>"+"播放量:"+"</p>"
                            +"</li>";
                    }
                    $("#AllVideo").html(html);
                }
            }
        });
    }
