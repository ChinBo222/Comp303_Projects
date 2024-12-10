import React, { useState, useEffect } from "react";
import { BrowserRouter as Router, Route, Routes, Link, Navigate } from "react-router-dom";
import DonorRegistration from "./components/DonorRegistration";
import DonorLogin from "./components/DonorLogin";
import Homepage from "./components/Homepage";
import DonorProfile from "./components/DonorProfile";
import BloodAvailability from "./components/BloodAvailability";
import '../src/styles_1.css';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  useEffect(() => {
    const donorId = localStorage.getItem("donorId");
    if (donorId) {
      setIsLoggedIn(true); // User is logged in
    }
  }, []);

  return (
    <Router>
      <div>
        <h1>Blood Bank Information System</h1>
        <nav>
          {!isLoggedIn ? (
            <>
              <Link to="/register">Register</Link> |{" "}
              <Link to="/login">Login</Link>
            </>
          ) : (
            <>
              <Link to="/home">Home</Link> |{" "}
              <Link to="/availability">Blood Availability</Link> |{" "}
              <Link to="/profile">Donor Profile</Link>
            </>
          )}
        </nav>

        <Routes>
          {!isLoggedIn ? (
            <>
              <Route path="/register" element={<DonorRegistration />} />
              <Route path="/login" element={<DonorLogin setIsLoggedIn={setIsLoggedIn} />} />
            </>
          ) : (
            <>
              <Route path="/home" element={<Homepage setIsLoggedIn={setIsLoggedIn} />} />
              <Route path="/availability" element={<BloodAvailability />} />
              <Route path="/profile" element={<DonorProfile />} />
            </>
          )}
          {/* Redirect to Home if logged in */}
          <Route path="/" element={<Navigate to={isLoggedIn ? "/home" : "/login"} />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
