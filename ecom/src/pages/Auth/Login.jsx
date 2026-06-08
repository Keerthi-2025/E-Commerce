import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import PasswordInput from '../../components/Input/PasswordInput'

import axiosInstance from "../../utils/axiosInstance";


import loginbg from "../../assets/login.jpeg";

export const Login = () => {

  const [email, setEmail] = useState("")
  const [password, setPassword] = useState("")
  const [error, setError] = useState("")
  const [loading, setLoading] = useState(false)

  const navigate = useNavigate()

  const handleLogin = async (e) => {
    e.preventDefault()

    if (!(email)) {
      setError("Please enter a valid email address")
      return
    }

    if (!password) {
      setError("Please enter password")
      return
    }

    setError("")
    setLoading(true)

    try {
      const response = await axiosInstance.post("/User/v1/login", {
        email,
        password
      })

      console.log("LOGIN RESPONSE:", response.data)

      const token = response.data?.token

      if (token) {
        localStorage.setItem("token", token)
      }

      localStorage.setItem("user", JSON.stringify(response.data))

      navigate("/products")

    } catch (error) {
      console.log(error)

      setError(
        error.response?.data?.message ||
        "Login failed. Please try again."
      )
    } finally {
      setLoading(false)
    }
  }

  return (
    <>
<div
  className="min-h-screen flex items-center justify-start px-35 pt-15 bg-cover bg-center" 
  style={{ backgroundImage: `url(${loginbg})` }}
>
        <div className='w-96 border rounded-2xl bg-white/15  shadow-lg backdrop-blur-md px-7 py-10'>

          <form onSubmit={handleLogin}>

            <h4 className='text-2xl  text-white mb-7 text-red-900'>
              Login
            </h4>

            <input
              type='text'
              placeholder='Email'
              className='input-box text-black font-semibold'
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />

            <PasswordInput
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />

            {error && (
              <p className='text-red-500 text-xs pb-1'>
                {error}
              </p>
            )}

            <button
              type="submit"
              className='btn-primary'
              disabled={loading}
            >
              {loading ? "Logging in..." : "Login"}
            </button>

            <p>
              Not registered yet?{" "}
              <Link to="/signup" className="font-medium underline">
                Create an account
              </Link>
            </p>

          </form>

        </div>
      </div>
    </>
  )
}

export default Login