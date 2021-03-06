
import axios from 'axios';

export function createWorkSession(tagName){

    return (dispatch)=>{

        let currentDatetime = new Date()

        return axios.post
        ('http://localhost:8080/users/SYSTEM/tags/' + tagName + '/worksession', 
            {

                startTime : currentDatetime
                
            }
        )
    
        .then(response => 
            dispatch(
                {   
                    type : 'CREATE_WORK_SESSION',
                    payload : response.data   
                }
            )
        )
    }

}


export function cancelWorkSession(){

    return (dispatch)=>{

        let currentDatetime = new Date()
 
        return axios.put
        ('http://localhost:8080/users/SYSTEM/worksession/cancel',currentDatetime)
    
        .then(response => 
            dispatch(
                {   
                    type : 'CANCEL_WORK_SESSION',
                    payload : response.data   
                }
            )
        )
    }

}

export function endWorkSession(){

    return (dispatch)=>{

        let currentDatetime = new Date()
 
        return axios.put
        ('http://localhost:8080/users/SYSTEM/worksession/end',currentDatetime)
    
        .then(response => 
            dispatch(
                {   
                    type : 'END_WORK_SESSION',
                    payload : response.data   
                }
            )
        )
    }

}

export function fetchWorkSessionReport(){

    return (dispatch)=>{

        return axios.get
        ('http://localhost:8080/users/SYSTEM/worksessions/report?from=2020-01-01&to=2020-08-30', {
            method: 'GET',
            headers: {
              'content-type': 'application/json',
            }
          }
        )
    
        .then(response => 
            dispatch(
            {   
                type : 'GET_WORKSESSION_REPORT',
                payload : response.data   
            }
            )
        )
    }

}
