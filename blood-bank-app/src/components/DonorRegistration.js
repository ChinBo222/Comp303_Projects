import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function DonorRegistration() {
  const [donor, setDonor] = useState({
    firstName: "",
    lastName: "",
    age: "",
    bloodGroup: "",
    city: "",
    phone: "",
    email: "",
    password: "",
  });

  const navigate = useNavigate(); // Hook to navigate programmatically

  const handleChange = (e) => {
    const { name, value } = e.target;
    setDonor({
      ...donor,
      [name]: value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    fetch("http://localhost:8083/api/donors", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(donor),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log("Donor Registered: ", data);
        alert("Donor Registered!");
        navigate("/login"); // Redirect to login after successful registration
      })
      .catch((error) => {
        console.error("Error registering donor: ", error);
      });
  };

  return (
    <div>
      <h2>Donor Registration</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="firstName"
          placeholder="First Name"
          value={donor.firstName}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="lastName"
          placeholder="Last Name"
          value={donor.lastName}
          onChange={handleChange}
          required
        />
        <input
          type="number"
          name="age"
          placeholder="Age"
          value={donor.age}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="bloodGroup"
          placeholder="Blood Group"
          value={donor.bloodGroup}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="city"
          placeholder="City"
          value={donor.city}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="phone"
          placeholder="Phone"
          value={donor.phone}
          onChange={handleChange}
          required
        />
        <input
          type="email"
          name="email"
          placeholder="Email"
          value={donor.email}
          onChange={handleChange}
          required
        />
        <input
          type="password"
          name="password"
          placeholder="Password"
          value={donor.password}
          onChange={handleChange}
          required
        />
        <button type="submit">Register</button>
      </form>
      <button onClick={() => navigate("/login")}>Go to Login</button>
    </div>
  );
}

export default DonorRegistration;
