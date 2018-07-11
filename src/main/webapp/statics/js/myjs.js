$(function(){
    //使用 jquery + ajax 提交表单
    // $("#login").click(function(){
    //     var allData = {'name':$("#userName").val() , 'password':$("#password").val()}
    //     alert(allData);
    //     $.ajax({
    //         type:"post",
    //         url:"${pageContext.request.contextPath}/loginCheck",
    //         contentType:"application/json;charset=utf-8",
    //         dataType:"json",
    //         data:JSON.stringify(allData),
    //         error: function(XMLHttpRequest, textStatus, errorThrown) {
    //             alert(XMLHttpRequest.status);
    //             alert(XMLHttpRequest.readyState);
    //             alert(textStatus);
    //             alert(errorThrown)
    //         },
    //         success:function(data){
    //             alert(data['result']);
    //             var response=data['result'];
    //             if(response==="false"){
    //                 window.location.href="/login";
    //             }
    //             else {window.location.href="/items/queryItems";}
    //         }
    //     })
    // })
        //最原始的jquery实现表单提交
       /* $("#login").click(function(){
            // method="post" action="/loginCheck"
            $("#loginForm").attr("action","/loginCheck");
            $("#loginForm").attr("method","post");
            $("#loginForm").submit();
        });*/
        //在input file 内容改变的时候触发事件
        $("#file0").change(function () {
            //获取input file的files文件数组;
            //$('#file0')获取的是jQuery对象，.get(0)转为原生对象;
            //这边默认只能选一个，但是存放形式仍然是数组，所以取第一个元素使用[0];
            var file = $('#file0').get(0).files[0];

            //创建用来读取此文件的对象
            var reader = new FileReader();
            //使用该对象读取file文件
            reader.readAsDataURL(file);
            //读取文件成功后执行的方法函数
            reader.onload = function (e) {
                //读取成功后返回的一个参数e，整个的一个进度事件
                console.log(e);

                //选择所要显示图片的img，要赋值给img的src就是e中target下result里面
                //的base64编码格式的地址
                //$('#show').get(0).src = e.target.result;

                $("#show").attr('src', e.target.result);
            }
        })
    })