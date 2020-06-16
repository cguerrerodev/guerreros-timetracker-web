
const initState= {}

const workSessionReducer = (state = initState, action) => {

    switch (action.type){

        case 'CREATE_WORK_SESSION':
             
            return{
                ...state,
                workSession:action.payload
            }
        
        case 'CANCEL_WORK_SESSION':
            
            return{
                ...state,
                workSession:action.payload
            }

        case 'END_WORK_SESSION':
        
            return{
                ...state,
                workSession:action.payload
            }
               
        default:

            return state;
    }

};

export default workSessionReducer;
