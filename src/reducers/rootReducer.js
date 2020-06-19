

import {combineReducers} from 'redux';
import tagReducer from './tagReducer';
import workSessionReducer from './workSessionReducer';
import userReducer from './userReducer';


const rootReducer = combineReducers({
    user : userReducer,
    tag : tagReducer,
    workSession : workSessionReducer
});

export default rootReducer;