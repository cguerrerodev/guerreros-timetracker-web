
const initState= {}

const tagReducer = (state = initState, action) => {

    switch (action.type){

        case 'GET_TAGS':
             
            return{
                ...state,
                tags:action.payload
            }

 
        case 'SELECT_TAG':
             
            return{
                ...state,
                tagName:action.payload
            }           
        
        default:

            return state;
    }

};

export default tagReducer;
