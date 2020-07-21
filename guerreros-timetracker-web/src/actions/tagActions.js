
import axios from 'axios';

export function fetchTags(){

    return (dispatch)=>{

        return axios.get
        ('http://localhost:8080/users/SYSTEM/tags', {
            method: 'GET',
            headers: {
              'content-type': 'application/json',
            }
          }
        )
    
        .then(response => 
            dispatch(
            {   
                type : 'GET_TAGS',
                payload : response.data   
            }
            )
        )
    }

}

export function selectTag(tagName){

    return ({
        type : 'SELECT_TAG',
        payload : tagName
    })

}
