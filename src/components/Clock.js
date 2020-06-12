
import React, { Component } from 'react';
import {connect} from 'react-redux';
import TagSelect from './TagSelect'
import {createWorkSession} from '../actions/workSessionActions';

class Clock extends Component {

  state = {
      sessionDuration : 25,
      remainingSeconds:  1500,
      clockValue : '25:00'
  }

  getRemainingTime = () =>{
    let clockValue = ('' + Math.trunc (this.state.remainingSeconds / 60)).padStart(2, '0');
    clockValue += ':' + ('' + (this.state.remainingSeconds % 60)).padStart(2, '0');

    let remainingSeconds = this.state.remainingSeconds - 1;

    this.setState({clockValue,remainingSeconds});
    
    if (this.state.remainingSeconds === 0){
      clearInterval(this.state.interval);
    }
  }

  startWorkSession = () =>{
    document.getElementById("Clock.startWorkSessionBotton").style.display = "none";
    document.getElementById("Clock.cancelWorkSessionBotton").style.display = "";
    this.setState({interval : setInterval(this.getRemainingTime, 1000)});
    this.props.createWorkSession(this.props.tagName);
  }

  cancelWorkSession = () =>{
    
    document.getElementById("Clock.startWorkSessionBotton").style.display = "";
    document.getElementById("Clock.cancelWorkSessionBotton").style.display = "none";

    clearInterval(this.state.interval);
  }  

  componentDidMount(){ }

  render(){


      return (
        <div className="jumbotron">
          <div>
            <h1 class="display-3">{this.state.clockValue}</h1>
          </div>
          <br />
          <div>
            <button id = "Clock.startWorkSessionBotton"   
              onClick = {this.startWorkSession} className="btn btn-outline-primary">
              Start
            </button>
            <button id = "Clock.cancelWorkSessionBotton"  
              onClick = {this.cancelWorkSession}
              className="btn btn-outline-primary"  >
                Cancel
            </button>
          </div>
        </div>

      );

    }
  
}

const mapStateToProps = (state) => {
  return {
            workSession : state.workSession.workSession,
            tagName : state.tag.tagName
          }
  
}

const mapDispatchToProps = (dispatch) => {
  return {
    createWorkSession: (tagName) => dispatch(createWorkSession(tagName))
  }
  
}


export default connect(mapStateToProps, mapDispatchToProps)(Clock);