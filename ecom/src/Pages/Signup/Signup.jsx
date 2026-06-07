import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axiosInstance from "../../utils/axiosInstance";

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
            const response = await axiosInstance.post("/api/User/v1/signup", {
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
                setError(error.response.data);
            } else {
                setError("An error occurred. Please try again later");
            }
        }
    };

    return (
        <div>
            <div>
                <div>
                    <form>
                        <h1>Signup</h1>
                    </form>
                </div>
            </div>
        </div>
    );
};

export default Signup;