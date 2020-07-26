import React from 'react';
import './App.css';

import {BrowserRouter, Route} from 'react-router-dom'; 
import Pomodoro from './components/Pomodoro';
import Login from './components/Login';
import NavBar from './components/NavBar';

function App() {
  return (
    <div className="App" style={{height: "100%"}}> 
      <NavBar />
      <hr />
      <BrowserRouter>
        <Route path="/" exact component={Login} />
        <Route path="/pomodoro" exact component={Pomodoro} />
      </BrowserRouter>

    </div>
  );
}

export default App;
