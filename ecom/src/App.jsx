import React from 'react'
import Login from './pages/Auth/Login.jsx';
import Signup from './pages/Auth/Signup.jsx';

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