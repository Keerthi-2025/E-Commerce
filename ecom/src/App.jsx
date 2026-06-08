import React from 'react'
import Login from './pages/Auth/Login.jsx';
import Signup from './pages/Auth/Signup.jsx';
import Products from './pages/Products.jsx';

import { Routes, Route} from 'react-router-dom';
import LandingPage from './components/Landing/LandingPage.jsx';

function App  () {
  return (
    <Routes>
      <Route path ="/login" element={<Login/>}/>
      <Route path='/signup' element={<Signup/>}/>
      <Route path='/' element={<LandingPage/>}/>
      {/* <Route path='/dashboard' element={<Dashboard/>}/> */}

      <Route path='/products' element={<Products/>}/>
    </Routes>
  )
}

export default App