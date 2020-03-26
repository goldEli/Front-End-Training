import React, {Component} from 'react'
import './App.css'
import Login from '../login/Login'
import Register from '../register/Register'

class App extends Component {

    state = {
        msgObj:{
            display: "none",
            msg: "on my god!"
        }
    }

    // 修改提示信息的状态
    showMsg = (display, msg) => {
        this.setState({
            msgObj : {
                display : display,
                msg : msg
            }
        })
    }

    render() {
        const {msgObj} = this.state
        return (
            <div>

                <div className="info">
                    <h1>MY ACCOUNT</h1>
                    <h4>Click here to login with Facebook</h4>
                </div>

                <div className="msg" style={{display:msgObj.display}}>
                    <h3>{msgObj.msg}</h3>
                </div>

                <div className="forms">
                    <Login showMsg={this.showMsg}/>
                    <Register showMsg={this.showMsg}/>
                </div>

            </div>
        )
    }
}

// 将组件暴露出来
export default App