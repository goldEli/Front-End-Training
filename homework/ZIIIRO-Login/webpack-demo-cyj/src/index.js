// require('../app/js/login')
// require('../css/index.css')
import './index.css'
import './logo.png'
var tip = document.getElementsByClassName("tips")[0];
tip.style.visibility="hidden";
function change(){
    var tips = tip.style.visibility="visible";
    email();
    password();
    num = e + p;
    switch(num){
        case 1: return tip.innerHTML="邮箱地址错误"; break;
        case 2: return tip.innerHTML="密码强度不够（密码中必须包含大小写字母、数字、特殊字符，至少6个字符，最多16个字符）"; break;
        case 3: return tip.innerHTML="邮箱地址和密码输入不合法，请全部重新输入！"
    }
    if(email()||password()==false){
        console.log("可以发送请求")
    }
}
function email(){
    var email = document.getElementById("email").value;
    var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
    if(reg.test(email)){
    //成功
    return e = 0;
    }else{
    //失败
    return e = 1;
    }
}
function password(){
    var pswd = document.getElementsByClassName("password-reg").value;
    //密码必须包含 字母、数字，至少6个字符，最多16个字符
    var pwdRegex = new RegExp(/^(?![^a-zA-Z]+$)(?!\D+$)/);
    if (pwdRegex.test(pswd)) {
    //成功
    return p = 0;
    }else{
    //失败
    return p = 2;   
    }
}