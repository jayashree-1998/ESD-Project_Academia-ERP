import React, { useState } from "react";
import '../App.css';
const LoginForm = ({showLogin}) => {

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = (event) => {

        event.preventDefault()

        const logincredentials = {email, password}
        showLogin(logincredentials)
        setEmail('')
        setPassword('')
        
    }

    return(
        <div className="top-container">
            <form onSubmit={handleLogin} class="login-form">
            <h3>Faculty Sign In </h3>
                <div className="container">
                    <div class = "headline">
                        <label>Login Id</label>
                    </div>
                    <input type={"email"} placeholder='Email' value={email} onChange={event => setEmail(event.target.value)} id = 'email' required/>
                </div>
                <div className="container">
                    <div class = "headline">
                        <label>Password</label>
                    </div>
                    <input type={"password"} placeholder='Password' value={password} onChange={event =>setPassword(event.target.value)} id = 'password' required/>
                </div>
                <div className="button-container">
                    <button class = "login-btn" type='submit' id='login-submit'>LOGIN</button>
                </div>
            </form>
        </div>
    )
}
export default LoginForm