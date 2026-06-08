import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import axiosInstance from "../../utils/axiosInstance";

import PasswordInput from "../../components/Input/PasswordInput";

import signupbg from "../../assets/sig.jpg";

const Signup = () => {

    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");

    const navigate = useNavigate();

    const handleSignup = async (e) => {
        e.preventDefault();

        if (!name) {
            setError("Please enter your name");
            return;
        }

        if (!email) {
            setError("Please enter your email");
            return;
        }

        if (!password) {
            setError("Please enter the password");
            return;
        }

        setError("");

        try {
           const response = await axiosInstance.post("/User/v1/signup", {
    userId: Date.now().toString(),
    userName: name,
    email: email,
    password: password,
});

            alert(response.data);

            // signup → go to login page
            navigate("/login");

        } catch (error) {
            if (error.response && error.response.data) {
                setError(error.response?.data?.message || "Something went wrong");
            } else {
                setError("An error occurred. Please try again later");
            }
        }
    };

    return (
       
            <div className="flex items-center justify-center md:justify-end min-h-screen w-full pr-16"
             style={{
                backgroundImage:`url(${signupbg})`,
                backgroundSize:"contain",
                backgroundPosition:"left center",
                backgroundRepeat:"no-repeat"
             }}>
                <div className=  " w-96 border rounded-2xl bg-white/40 backdrop-blur-md shadow-xl hover:shadow-2xl transition-all duration-300 px-7 py-10 mr-10 ">
                    <form onSubmit={handleSignup}>
                        <h1 className="text-2xl mb-7 ">Signup</h1>

                        <input
                        type="text"
                        placeholder="Enter the Name"
                        className="input-box"
                        value={name}
                        onChange={(e)=>setName(e.target.value)}/>

                        <input
                        type="text"
                        placeholder="Enter the Email"
                        className="input-box"
                        value={email}
                        onChange={(e)=>setEmail(e.target.value)}/>

                     <PasswordInput value={password} onChange={(e)=>setPassword(e.target.value)}/>

                        <button type="submit" className="btn-primary">Create an Account</button>

                       {error && <p className="text-red-600">{error}</p>}

                       <p>Already have an Account? {" "}
                        <Link to="/login" className="font-medium underline">LogIn</Link>
                       </p>
                    </form>
                </div>
            </div>
       
    );
};

export default Signup;