import React from 'react'
import Login from './pages/Login/Login';
import Signup from './pages/Signup/Signup';
import { Routes, Route} from 'react-router-dom';

function App  () {
  return (
    <Routes>
      <Route path ="/login" element={<Login/>}/>
      <Route path='/signup' element={<Signup/>}/>
    </Routes>
  )
}

export default App