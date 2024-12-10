import React from "react";
import { BrowserRouter as Router, Route, Routes, Link } from "react-router-dom";
import DonorRegistration from "./components/DonorRegistration";
import BloodAvailability from "./components/BloodAvailability";
import DonorProfile from "./components/DonorProfile";
import DonorLogin from "./components/DonorLogin"; // Assuming this component exists

function App() {
  return (
    <Router>
      <div>
        <h1>Blood Bank Information System</h1>
        {/* Navigation Links */}
        <nav>
          <Link to="/register">Register</Link> |{" "}
          <Link to="/login">Login</Link> |{" "}
          <Link to="/availability">Blood Availability</Link> |{" "}
          <Link to="/profile">Donor Profile</Link>
        </nav>

        {/* Define Routes */}
        <Routes>
          <Route path="/register" element={<DonorRegistration />} />
          <Route path="/login" element={<DonorLogin />} />
          <Route path="/availability" element={<BloodAvailability />} />
          <Route path="/profile" element={<DonorProfile />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
