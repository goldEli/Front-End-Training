require("!style-loader!css-loader!./index.css");
require("jquery");

$(function () {
    // input框内容元素发生改变时触发(自动加载已有记录)
    $('#name').change(function () {
        var name = $('#name').val();
        for (var i = 0; i < localStorage.length; i++) {
            if (name === localStorage.key(i)) {
                //alert(localStorage.getItem(name));
                $('#log_pwd').attr("value", localStorage.getItem(name));
            }
        }
    })

    $('#log_btn').click(function () {
        var name = $('#name').val();
        var pwd = $('#log_pwd').val();
        var check_box = $("#check_box").prop("checked");

        if (name === "") {
            $("#msg").html("用户名/邮箱地址不能为空").slideDown("slow");
            return false;
        }
        if (pwd === "") {
            $("#msg").html("密码不能为空").slideDown("slow");
            return false;
        }
        if (!isPwd(pwd)) {
            $("#msg").html("密码必须包含数字、下划线和字母，长度在8-15位").slideDown("slow");
            return false;
        }

        if (check_box === true) {
            localStorage.setItem(name, pwd);
        }

        $.ajax({
            url: "login",
            type: "Get",
            data: { "username": name, "password": pwd },
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            success: function (data) {
                alert(data.message);
                $("#msg").html(data.message).slideDown("slow");
            }
        })
        return true;
    });

    $('#res_btn').click(function () {
        var email = $('#email').val();
        var pwd = $('#reg_pwd').val();

        if (email === "") {
            $("#msg").html("邮箱地址不能为空").slideDown("slow");
            return false;
        }
        if (!IsEmail(email)) {
            $("#msg").html("邮箱地址格式错误").slideDown("slow");
            return false;
        }

        if (pwd === "") {
            $("#msg").html("密码不能为空").slideDown("slow");
            return false;
        }
        if (!isPwd(pwd)) {
            $("#msg").html("密码必须包含数字、下划线和字母，长度在8-15位").slideDown("slow");
            return false;
        }

        $.ajax({
            url: "register",
            type: "Get",
            data: { "email": email, "password": pwd },
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            success: function (data) {
                alert(data.message);
                $("#msg").html(data.message).slideDown("slow");
            }
        })

        return true;
        /*校验邮件地址是否合法 */
        function IsEmail(str) {
            var reg = /^\w+@[a-zA-Z0-9]{2,10}(?:\.[a-z]{2,4}){1,3}$/;
            return reg.test(str);
        }
    })
})

/*检验密码是否合法*/
function isPwd(str) {
    var reg = /^\w{8,15}$/;
    return reg.test(str);
}