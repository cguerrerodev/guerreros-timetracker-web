
import React, { Component } from 'react';
import {connect} from 'react-redux';
import {login} from '../actions/userActions';
import GoogleLogin from 'react-google-login';

class Login extends Component {

    state = {
        
    }


    onSignIn = (googleUser) => {
        var profile = googleUser.getBasicProfile();

        let user = {
            userType: 'GOOGLE',
            idToken :  googleUser.getAuthResponse().id_token,
            name : profile.getName(),
            email : profile.getEmail(),
            imageUrl : profile.getImageUrl()
        }

        this.props.login(user);
        this.props.history.push('/pomodoro')

    }


    componentDidMount(){
            
    }

    render(){


        return (

            <div  style = {{
                
                height: '100%',
                display: 'flex',
                alignItems: 'center',
                justifyContent: 'center'

            }} >
                                
                <div className="card text-white bg-primary mb-3" 
                    style={{maxWidth: '20rem'}} >
                    <div className="card-header align-self-left" >
                        Login
                    </div>
                    <div className="card-body">
                        
                        
                    <GoogleLogin
                        clientId="609664151591-4mevlg7eip0qsk3buf1dc6qangtiruqo.apps.googleusercontent.com"
                        buttonText="Login"
                        onSuccess={this.onSignIn}
                        
                        cookiePolicy={'single_host_origin'}
                    />


                    </div>
                </div>
              
            </div>
 
        );

    }

}




const mapDispatchToProps = (dispatch) => {
    return {
        login: (user) => dispatch(login(user))
    }
    
}


export default connect(null,mapDispatchToProps)(Login);