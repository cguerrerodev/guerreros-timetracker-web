import React, { Component } from 'react';
import {connect} from 'react-redux';
import Navbar from 'react-bootstrap/Navbar'
import Nav from 'react-bootstrap/Nav'


class NavBar extends Component {


    getUserOptions = ()=>{
        if (this.props.user) {
            return(
                <Nav className="mr-auto">
                    <Nav.Link href="/Pomodoro">Pomodoro</Nav.Link>
                    <Nav.Link href="/Manual">Manual</Nav.Link>
                </Nav>
            )
        } 
        
        return null;
    }

    render(){

        return (

            <Navbar bg="primary" expand="lg" variant="dark" fixed="top">
                <Navbar.Brand href="#home">Guerrero's Time Tracker</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">

                {this.getUserOptions()}

                </Navbar.Collapse>
            </Navbar>

        )
    }
}

const mapStateToProps = (state) => {
    return {user : state.user.user}
}

export default connect(mapStateToProps)(NavBar);
