(function () {
    $('#account').on('focus',function () {
        $('#account-v span').html("")
    });
    $('#password').on('focus',function () {
        $('#password-v span').html("")
    });
    $('#verifvPassword').on('focus',function () {
        $('#verifvPassword-v span').html("")
    });
    $('#name').on('focus',function () {
        $('#name-v span').html("")
    });
    $('#phone').on('focus',function () {
        $('#phone-v span').html("")
    });
    $('#account').on('blur',function () {
        let reg = /^[0-9a-zA-Z_\u3E00-\u9FA5]{3,15}$/;
        let $account = $('#account').val();
        let $aem = $('#account-v span');
        if($account=="" || $account == null){
            $aem.html('账号不能为空！');
        }else if (!reg.test($account)){
            $aem.html('账号格式不正确！');
        }
    });
    $('#password').on('blur',function () {
        let $password = $('#password').val();
        if($password == "" || $password == null){
            $('#password-v span').html("密码不能为空！");
        }
    });
    $('#verifvPassword').on('blur',function () {
        let $password = $('#password').val();
        let $verifvPassword = $('#verifvPassword').val();
        if($verifvPassword == "" || $verifvPassword == null){
            $('#verifvPassword-v span').html("再次输入密码！");
        }else if ($password != $verifvPassword) {
            $('#verifvPassword-v span').html("两次密码不一致！");
        }

    });
    $('#name').on('blur',function () {
        let $name = $('#name').val();
        if($name ==""||$name==null){
            $('#name-v span').html("名字不能为空！");
        }
    });
    $('#phone').on('blur',function () {
        let reg =  /^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$/;
        let $phone = $('#phone').val();
        if($phone == "" || $phone == null){
            $('#phone-v span').html("手机号码不能为空！");
        }else if($phone.length != 11){
            $('#phone-v span').html("手机号码长度有误！");
        }else if(!reg.test($phone)){
            $('#phone-v span').html("手机号码不存在！");
        }
    });

    $('#registeredButton').bind("click",function (event) {
        console.log("按了注册按钮");
        let $account = $('[name="account"]').val();
        let $password = $('[name="password"]').val();
        let $verifvPassword = $('[name="verifvPassword"]').val();
        let $name = $('[name="name"]').val();
        let $phone = $('[name="phone"]').val();
        if ($account == "" || $('#account-v span').text() != "") {
            alert("请重新填写账号！");
            event.preventDefault();
            return;
        }else if ($password == "" || $('#password-v span').text() != ""){
            alert("请重新输入密码！");
            event.preventDefault();
            return;
        }else if ($verifvPassword == "" || $('#verifvPassword-v span').text() != ""){
            alert("请重新填写确认密码！");
            event.preventDefault();
            return;
        }else if ($name == "" || $('#name-v span').text() != ""){
            alert("请输入姓名！");
            event.preventDefault();
            return;
        }else if ($phone == "" || $('#phone-v span').text() != ""){
            alert("请正确格式的手机号码！");
            event.preventDefault();
            return;
        }else{
            let formData = new FormData($("#form-validate")[0]);
            $.ajax({
                url:"/registerCreate",
                method:"post",
                data:formData,
                processData: false,
                contentType: false,
                success: function(result) {
                    console.log(result);
                    if(result=="账号创建成功"){
                        window.location.href="/login";
                    }else{
                        alert("账号已存在！");
                    }
                }
            })
        }
    })

})(jQuery);