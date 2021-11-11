import React from 'react'
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link
} from 'react-router-dom';

import { Navbar } from './components/Navbar'
import Game from './pages/Game'
import HomePage from './pages/HomePage'
import Footer from './components/Footer'



function App() {
  return (
    <Router>
      <Navbar/>
        <Routes>
          <Route  path="/" exact element={<HomePage />}>
          </Route>
          <Route  path="/Game" exact element={<Game />}></Route>
        </Routes>
      
      <br/>
      <br/>
      <Footer/>
    </Router>
  );
}

export default App;
