import React, { Component } from 'react';
import {connect} from 'react-redux';
import {fetchWorkSessionReport} from '../actions/workSessionActions'

class WorkSessionReport extends Component {


    componentDidMount(){
        this.props.fetchWorkSessionReport();
    }


    getUserInformation = ()=>{
        if (this.props.user) {
            return(
                <div className = "float-right row">
                    <h5>{this.props.user.name}</h5>&nbsp;&nbsp;&nbsp;
                    <img  src={this.props.user.imageUrl} width="30" height="30" />   
                </div> 
            )
        } 
        
        return null;
    }


 

    render(){


        let rows = [];

        if (this.props.todaysWorkSessionReport
            && this.props.todaysWorkSessionReport.tagWorkSessions) {

            Object.entries(
                this.props.todaysWorkSessionReport.tagWorkSessions
            ).forEach((element) => {

                rows.push(
                    <tr key = {element[0]}>
                        <td>{element[0]}</td>
                        <td>{element[1].totalWorkSessions}</td>
                        <td>{element[1].totalMinutes}</td>
                    </tr>
                )

            });
        } 
        

        return (

            <div className="card text-white bg-primary mb-3" >

            <div className="card-header">
                {this.getUserInformation()}
            </div>
            <div className="card-body">

                <div className = "table-responsive">
                <table className = "table table-striped table-hover">
                    <thead >
                        <tr>                           
                            <th>Task</th>
                            <th>Work Sessions</th>
                            <th>Time</th>
                        </tr>
                    </thead>
                    <tbody>
                        {rows}
                    </tbody>
                    <tr class="table-primary">
        
                        <td>Total</td>
                        <td>
                            {
                                this.props.todaysWorkSessionReport ? 
                                    this.props.todaysWorkSessionReport.totalWorkSessions
                                    : " - " 
                            }
                        </td>
                        <td>
                            {
                                this.props.todaysWorkSessionReport ? 
                                    this.props.todaysWorkSessionReport.totalMinutes
                                    : " - " 
                            }
                        </td>
                    </tr>
                </table>

            </div>

            </div>


</div>

        )
    }
}


const mapDispatchToProps = (dispatch) => {

    return {
        fetchWorkSessionReport: () => dispatch(fetchWorkSessionReport())
    }
    
}


const mapStateToProps = (state) => {
    return {
        todaysWorkSessionReport : state.workSession.todaysWorkSessionReport,
        user : state.user.user
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(WorkSessionReport);
