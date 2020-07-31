
import React, { Component } from 'react';
import {connect} from 'react-redux';
import Modal from 'react-bootstrap/Modal';
import {createWorkSession, cancelWorkSession, endWorkSession} from '../actions/workSessionActions';

class Clock extends Component {

  state = {
      sessionDuration : 1,
      breakDuration : 1,

      remainingSeconds: 0,
      clockValue : '00:00',
      onABreak : false,

      showSelectTaskModal : false,
      showCancelConfirmationModal : false,
      showWorkSessionEndedMenuModal : false
  }

  initClock = () =>{

    clearInterval(this.state.interval);
    this.setState({
      remainingSeconds : 0,
      clockValue : '00:00'
    });

    document.getElementById("Clock.startWorkSessionBotton").style.display = "";
    document.getElementById("Clock.cancelWorkSessionBotton").style.display = "none";
    document.getElementById("Clock.statusText").innerHTML = "Ready to start";
    
  }

  getRemainingTime = () =>{
    let clockValue = ('' + Math.trunc (this.state.remainingSeconds / 60)).padStart(2, '0');
    clockValue += ':' + ('' + (this.state.remainingSeconds % 60)).padStart(2, '0');

    let remainingSeconds = this.state.remainingSeconds - 1;

    this.setState({clockValue,remainingSeconds});
    
    if (this.state.remainingSeconds === 0){

      if (!this.state.onABreak){
        this.setState({showWorkSessionEndedMenuModal : true});
        this.props.endWorkSession();
      }else{
        this.setState({onABreak : false});
      }

      this.initClock();
    }
  }

  startCounter = () =>{

    document.getElementById("Clock.startWorkSessionBotton").style.display = "none";
    document.getElementById("Clock.cancelWorkSessionBotton").style.display = "";
    this.setState({interval : setInterval(this.getRemainingTime, 1000)});


  }

  startWorkSession = () =>{
    
    if (!this.props.tagName){
      this.setState({showSelectTaskModal : true});
      document.getElementById("TagSelect.tagSelect").focus();
      return;
    }

    this.setState({
      remainingSeconds:  this.state.sessionDuration * 60,
      clockValue : ('' + this.state.sessionDuration).padStart(2, '0') + ':00',
      onABreak : false    
    })

    document.getElementById("Clock.statusText").innerHTML = "Working";
    this.startCounter();
    this.props.createWorkSession(this.props.tagName);
  }


  confirmWorkSessionCancelation = () =>{
    
    this.setState({showCancelConfirmationModal : false});

    document.getElementById("Clock.startWorkSessionBotton").style.display = "";
    document.getElementById("Clock.cancelWorkSessionBotton").style.display = "none";

    clearInterval(this.state.interval);
    this.initClock();

    this.props.cancelWorkSession();
  }  

  startBreak = ()=>{

    this.setState({
      onABreak : true,
      remainingSeconds:  this.state.breakDuration * 60,
      clockValue : ('' + this.state.breakDuration).padStart(2, '0') + ':00'      
    })

    document.getElementById("Clock.statusText").innerHTML = "On a break";
    this.startCounter();
  }

  cancelButtonHandler = () =>{
    
    if(!this.state.onABreak){
      this.setState({showCancelConfirmationModal : true});
      return;
    }

    this.initClock();
  }  


  takeABreakButtonHandler = ()=>{
    this.setState({showWorkSessionEndedMenuModal : false});
    this.startBreak();
  }

  skipBreakButtonHandler = () => {
    this.setState({showWorkSessionEndedMenuModal : false});
    this.initClock();
  } 

  componentDidMount(){ }

  render(){


      return (
        <div className="jumbotron">
          <div>
            <h1 className="display-3 text-center">{this.state.clockValue}</h1>
          </div>
          <div className = "text-center">
            <button id = "Clock.startWorkSessionBotton"   
              onClick = {this.startWorkSession} className="btn btn-outline-primary">
              Start
            </button>
            <button id = "Clock.cancelWorkSessionBotton"  
              onClick = {this.cancelButtonHandler}
              className="btn btn-outline-primary"  style={{display: "none"}} >
                Cancel
            </button>
            <p id="Clock.statusText" className="text-left">Ready to start</p>
          </div>
          
 
          <Modal
            size="sm"
            aria-labelledby="contained-modal-title-vcenter"
            centered
            show={this.state.showSelectTaskModal} onHide={() => this.setState({showSelectTaskModal : false})} 
            >
            <Modal.Header closeButton>
                <Modal.Title id="contained-modal-title-vcenter">
                Please, select a task
                </Modal.Title>
            </Modal.Header>
          </Modal>
          <Modal
            size="sm"
            aria-labelledby="contained-modal-title-vcenter"
            centered
            show={this.state.showCancelConfirmationModal} onHide={() => this.setState({showCancelConfirmationModal : false})} 
            >
            <Modal.Header closeButton>
                <Modal.Title id="contained-modal-title-vcenter">
                  Are you sure, you want to cancel?
                </Modal.Title>
            </Modal.Header>
            <Modal.Footer>
              <button className="btn btn-outline-primary" onClick = {this.confirmWorkSessionCancelation}>Yes</button>
              <button className="btn btn-outline-primary" onClick={() => this.setState({showCancelConfirmationModal : false})}>No</button>
            </Modal.Footer>
            
          </Modal>
          <Modal
            size="sm"
            aria-labelledby="contained-modal-title-vcenter"
            centered
            show={this.state.showWorkSessionEndedMenuModal} onHide={() => this.setState({showWorkSessionEndedMenuModal : false})} 
            >
            <Modal.Header closeButton>
                <Modal.Title id="contained-modal-title-vcenter">
                  Work session over
                </Modal.Title>
            </Modal.Header>

            <Modal.Body>
              <button type="button" class="btn btn-primary btn-lg btn-block"
                onClick= {this.takeABreakButtonHandler}
              >
                Take a break
              </button>
              <button type="button" class="btn btn-primary btn-lg btn-block"
                onClick={this.skipBreakButtonHandler}
              >
                Skip break
              </button>
            </Modal.Body>
            
          </Modal>
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
    createWorkSession: (tagName) => dispatch(createWorkSession(tagName)),
    cancelWorkSession: () => dispatch(cancelWorkSession()),
    endWorkSession: () => dispatch(endWorkSession())
  }
  
}


export default connect(mapStateToProps, mapDispatchToProps)(Clock);