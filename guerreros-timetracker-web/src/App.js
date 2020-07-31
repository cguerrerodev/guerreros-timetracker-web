import React from 'react';
import './App.css';

import {BrowserRouter, Route} from 'react-router-dom'; 
import Main from './components/Main';
import Pomodoro from './components/Pomodoro';
import Login from './components/Login';

function App() {
  return (
    <div className="App" style={{height: "100%"}}> 
      
      <BrowserRouter>
        <Route path="/" exact component={Login} />
        <Route path="/main" exact component={Main} />
        <Route path="/pomodoro" exact component={Pomodoro} />       
      </BrowserRouter>

    </div>
  );
}

export default App;
