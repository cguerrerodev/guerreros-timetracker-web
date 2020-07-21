
import React, { Component } from 'react';
import Clock from './Clock';
import TagSelect from './TagSelect';
import {connect} from 'react-redux';
import {Redirect} from 'react-router-dom';

class Pomodoro extends Component {

    render(){

        return (

            this.props.user ?
            (<div className="containter">
                <Clock />
                <TagSelect />
            </div>)
            :
            <Redirect to='/' />
        );

    }

}

const mapStateToProps = (state) => {
    return {user : state.user.user}
}

export default connect(mapStateToProps)(Pomodoro);