import React,{Component} from 'react'
import PropTypes from 'prop-types'

export default class Register extends Component {
    static propTypes = {
        showMsg : PropTypes.func.isRequired
    }

    // 点击注册按钮
    handleReg = () => {
        // 1.收集数据
        const email = this.email.value.trim()
        const pwd = this.pwd.value.trim()
        // 2.匹配规则
        if(email === "" || pwd === ""){
            this.props.showMsg("block","邮箱地址，密码不能为空")
            return
        }
        if(!this.isEmail(email)){
            this.props.showMsg("block", "邮箱地址格式错误")
            return
        }
        if(!this.isPwd(pwd)){
            this.props.showMsg("block", "密码必须包含数字、下划线和字母，长度在8-15位")
            return
        }
        // 3.向服务器提交
        const url = "register?email=" + email + "&password=" + pwd;
        console.log("当前的url=", url);
        fetch(url, {
                method: "GET",
                mode: 'no-cors',
                //headers : new Headers(),
            })
            .then(function (response) {
                return response.json()
            })
            .then(data => this.props.showMsg("block", data.message))
            .catch(error => console.error('Error=', error))
    }

    /*校验邮件地址是否合法 */
    isEmail = (str) => {
        var reg = /^\w+@[a-zA-Z0-9]{2,10}(?:\.[a-z]{2,4}){1,3}$/;
        return reg.test(str);
    }
    /*校验邮件地址是否合法 */
    isPwd = (str) => {
        var reg = /^\w{8,15}$/;
        return reg.test(str);
    }

    render(){
        return(
            <div className="forms_register">
                <h2>REGISTER</h2>

                <h4 >email address *</h4>
                <input className="input02" type="text" ref={input => this.email = input} />
                <h4>Password *</h4>
                <input className="input02" type="password" ref={input => this.pwd = input} />
                <br />
                <input className="checkbox" type="checkbox" name="remember" />&nbsp;
                <span>Subscribe to our newsletter</span>
                <p>
                    Your personal data will be used to support your experience throughout this website, to manage access to your account,
                and for other purposes described in our <a href="#">privacy policy</a> .
                </p>

                <button className="res_submit" onClick={this.handleReg}>Register</button>    

        </div>
        )
    }
}