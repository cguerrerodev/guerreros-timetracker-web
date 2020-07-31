
import React, { Component } from 'react';
import Clock from './Clock';
import TagSelect from './TagSelect';
import WorkSessionReport from './WorkSessionReport';
import NavBar from './NavBar';
import {connect} from 'react-redux';

class Main extends Component {

    render(){

        return (

 //           this.props.user ?
            (<div className="containter">
                    <NavBar />
                    <hr />
                    <Clock />
                    <TagSelect />
                    <WorkSessionReport />
            </div>)
 //           :
 //           <Redirect to='/' />
        );

    }

}

const mapStateToProps = (state) => {
    return {user : state.user.user}
}

export default connect(mapStateToProps)(Main);