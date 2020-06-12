
import React, { Component } from 'react';
import Clock from './Clock';
import TagSelect from './TagSelect';

class Pomodoro extends Component {

    render(){

        return (
            <div className="containter">
                <Clock />
                <TagSelect />
            </div>
        );

    }

}

export default Pomodoro;