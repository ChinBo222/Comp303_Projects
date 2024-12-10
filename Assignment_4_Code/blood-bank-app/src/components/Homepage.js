import React from "react";
import { useNavigate } from "react-router-dom";

function Homepage({ setIsLoggedIn }) {
    const navigate = useNavigate();

    const handleLogout = () => {
        // Remove donorId from localStorage
        localStorage.removeItem("donorId");

        // Update the state to reflect that the user is logged out
        setIsLoggedIn(false);

        // Redirect to login page
        navigate("/login");
    };

    return (
        <div>
            <h2>Welcome to the Blood Bank Information System</h2>
            <p>Welcome back! You are logged in.</p>
            
            {/* Logout button */}
            <button onClick={handleLogout}>Log Out</button>
        </div>
    );
}

export default Homepage;
