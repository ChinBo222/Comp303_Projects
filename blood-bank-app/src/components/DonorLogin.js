import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function DonorLogin({ setIsLoggedIn }) {
    const [credentials, setCredentials] = useState({ email: "", password: "" });
    const navigate = useNavigate();

    const handleChange = (e) => {
        const { name, value } = e.target;
        setCredentials({ ...credentials, [name]: value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
    
        fetch("http://localhost:8083/api/donors/login", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(credentials),
        })
            .then((response) => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error("Invalid credentials");
                }
            })
            .then((data) => {
                console.log("Login Successful:", data);
                alert("Login Successful!");

                // Store donor ID in localStorage
                localStorage.setItem("donorId", data.id);

                // Update the state to reflect the user is logged in
                setIsLoggedIn(true);

                // Redirect to the home page after login
                navigate("/home");
            })
            .catch((error) => {
                console.error("Login Failed:", error);
                alert("Login Failed: Invalid credentials");
            });
    };

    return (
        <div>
            <h2>Donor Login</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="email"
                    name="email"
                    placeholder="Email"
                    value={credentials.email}
                    onChange={handleChange}
                    required
                />
                <input
                    type="password"
                    name="password"
                    placeholder="Password"
                    value={credentials.password}
                    onChange={handleChange}
                    required
                />
                <button type="submit">Login</button>
            </form>
        </div>
    );
}

export default DonorLogin;
