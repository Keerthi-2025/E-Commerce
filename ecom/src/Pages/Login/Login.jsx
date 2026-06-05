import React, { useState } from 'react'
import PasswordInput from '../../components/Input/PasswordInput';



const Login = () => {
const [email, setEmail] = useState("");
const [password, setPassword] = useState("");
const [error, setError] = useState(null);

  return (


    <div className='flex items-center justify-center mt-28'>
      <div className='w-96 border rounded bg-white px-7 py-10'>
        <form>
          <h4 className='text-2xl mb-7'>Login </h4>
            {/* <input type='text' placeholder='Email' className='input-box'/> */}

            <input
            type='text'
            placeholder='Email'
            className='input-box'
            value={email}
            onChange={(e) => setEmail(e.target.value)}/>

            <PasswordInput 
            value={password}
            onChange={(e) => setPassword(e.target.value)}/>

            {error && <p className='text-red-500 text-xs pb-1'>{error}</p>}

            <button  type="submit" className='btn-primary'>Login</button>

            <p>Not regsitered yet?{" "}
              <Link to="/signup" className="font-medium underline">Create an account</Link>
            </p>
         
        </form>
      </div>
    </div>
  )
}

export default Login