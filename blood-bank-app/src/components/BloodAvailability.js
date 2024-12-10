import React, { useState } from "react";

function BloodAvailability() {
  const [bloodGroup, setBloodGroup] = useState("");
  const [availability, setAvailability] = useState(null);
  const [error, setError] = useState(null); // To capture errors if any

  const handleChange = (e) => {
    setBloodGroup(e.target.value);
  };

  const checkAvailability = () => {
    console.log("Checking availability for:", bloodGroup);

    if (!bloodGroup || bloodGroup.trim() === "") {
      alert("Please enter a valid blood group.");
      return;
    }

    fetch(`http://localhost:8083/api/bloodstocks/availability/${bloodGroup}`)
      .then((response) => {
        if (!response.ok) {
          throw new Error(`Error: ${response.status}`);
        }
        return response.json();
      })
      .then((data) => {
        console.log("Response Data:", data);

        // If data contains a message (error response)
        if (data.message) {
          setError(data.message); // Store the error message as a string
          setAvailability(null); // Reset availability state
        } else {
          setAvailability(data);
          setError(null); // Clear any previous errors
        }
      })
      .catch((error) => {
        console.error("Error checking availability: ", error);
        setError("An error occurred while checking availability.");
      });
  };


  return (
    <div>
      <h2>Check Blood Availability</h2>
      <input
        type="text"
        value={bloodGroup}
        onChange={handleChange}
        placeholder="Enter Blood Group"
      />

      <button onClick={checkAvailability}>Check Availability</button>

      {error && <p style={{ color: "red" }}>{error}</p>}

      {availability && (
  <div>
    <p>Blood Group: {availability.bloodGroup}</p>
    <p>Quantity Available: {availability.quantity}</p>
    <p>Status: {availability.status}</p>
  </div>
)}

    </div>
  );
}

export default BloodAvailability;
