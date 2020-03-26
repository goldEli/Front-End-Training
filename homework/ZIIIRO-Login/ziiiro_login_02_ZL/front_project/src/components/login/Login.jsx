import React, { Component } from 'react'
import PropTypes from 'prop-types'

export default class Login extends Component {
    // 指定传入参数的类型
    static propTypes = {
        showMsg : PropTypes.func.isRequired
    }

    // 点击登录按钮(箭头函数中this指代调用它的上级对象)
    handleLogin = () => {
        // 收集数据
        const username = this.username.value.trim()
        //console.log(Object.prototype.toString.call(username))
        const pwd = this.pwd.value.trim()
        //console.log(Object.prototype.toString.call(pwd))
        // 判断数据是否符合规则(更新msg)
        if(username === "" || pwd === ""){
            this.props.showMsg("block", "用户名，密码不能为空！")
            return
        }
        if (!this.isPwd(pwd)){
            this.props.showMsg("block", "密码必须包含数字、下划线和字母，长度在8-15位")
            return
        }
        
        // 提交至服务端(更新msg)
        const url = "login?username=" + username + "&password=" + pwd;
        console.log("当前的url=", url);
        fetch(url,{
                method : "GET",
                mode: 'no-cors',
                //headers : new Headers(),
            })
            .then(function(response){
                return response.json()
            })
            .then(data => this.props.showMsg("block", data.message))
            .catch(error => console.error('Error=', error))
    }

    /*校验邮件地址是否合法 */
    isPwd = (str) => {
        var reg = /^\w{8,15}$/;
        return reg.test(str);
    }

    render(){
        return (
            <div className="forms_login">
                <h2>LOGIN</h2>

                <h4>Username or email address *</h4>
                <input className="input01" type="text" ref={input => this.username = input} />
                <h4>Password *</h4>
                <input className="input01" type="password" ref={input => this.pwd = input}  />
                <br />
                <input className="checkbox" type="checkbox" value="on" />&nbsp;
                <span>remember me</span>
                <br />

                <button className="log_submit" onClick={this.handleLogin}>Log in</button>
                
                <br />
                <a href="#">Lost your password?</a>
            </div>
        )
    }
}