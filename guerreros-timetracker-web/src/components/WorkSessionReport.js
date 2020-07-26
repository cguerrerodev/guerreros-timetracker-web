import React, { Component } from 'react';
import {connect} from 'react-redux';
import {fetchWorkSessionReport} from '../actions/workSessionActions'

class WorkSessionReport extends Component {


    componentDidMount(){
        this.props.fetchWorkSessionReport();
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
            </table>

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
    return {todaysWorkSessionReport : state.workSession.todaysWorkSessionReport}
}

export default connect(mapStateToProps, mapDispatchToProps)(WorkSessionReport);
