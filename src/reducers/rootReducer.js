

import {combineReducers} from 'redux';
import tagReducer from './tagReducer';
import workSessionReducer from './workSessionReducer';


const rootReducer = combineReducers({
    tag : tagReducer,
    workSession : workSessionReducer
});

export default rootReducer;