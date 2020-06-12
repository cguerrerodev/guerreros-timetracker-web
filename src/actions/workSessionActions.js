
import axios from 'axios';

export function createWorkSession(tagName){

    return (dispatch)=>{

        let currentDatetime = new Date()
        let formattedDate = currentDatetime.getFullYear() + "-" + (currentDatetime.getMonth() + 1) 
            + "-" + currentDatetime.getDate() + "T" + currentDatetime.getHours() + ":" 
            + currentDatetime.getMinutes() + ":" + currentDatetime.getSeconds() 

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

