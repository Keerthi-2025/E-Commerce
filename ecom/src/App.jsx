import React from 'react'
import Login from './pages/Auth/Login.jsx';
import Signup from './pages/Auth/Signup.jsx';
import Products from './pages/Products.jsx';
import Cart from './pages/Cart.jsx';

import { Routes, Route} from 'react-router-dom';
import LandingPage from './components/Landing/LandingPage.jsx';
import Orders from './pages/Orders.jsx';
import OrderDetails from './pages/OrderDetails.jsx';

function App  () {
  return (
    <Routes>
      <Route path ="/login" element={<Login/>}/>
      <Route path='/signup' element={<Signup/>}/>
      <Route path='/' element={<LandingPage/>}/>
      {/* <Route path='/dashboard' element={<Dashboard/>}/> */}

      <Route path='/products' element={<Products/>}/>
      <Route path='/cart' element={<Cart/>}/>
      <Route path='/orders' element={<Orders/>}/>

      <Route path="/orders/:orderId" element={<OrderDetails />} />

      <Route path='/OrderDetails' element={<OrderDetails/>}/>
    </Routes>
  )
}

export default App