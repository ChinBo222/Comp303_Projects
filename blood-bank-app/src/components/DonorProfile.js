import React, { useState, useEffect } from "react";

function DonorProfile() {
  const [donor, setDonor] = useState(null);
  const [error, setError] = useState(null);

  useEffect(() => {
    const donorId = "some-id"; // Replace with actual ID
    fetch(`http://localhost:8083/api/donors/${donorId}`)
      .then((response) => response.json())
      .then((data) => setDonor(data))
      .catch((error) => {
        setError("Donor not found.");
      });
  }, []);

  if (error) {
    return <div>{error}</div>;
  }

  if (!donor) {
    return <div>Loading...</div>;
  }

  return (
    <div>
      <h2>Donor Profile</h2>
      <p>First Name: {donor.firstName}</p>
      <p>Last Name: {donor.lastName}</p>
      <p>Age: {donor.age}</p>
      <p>Blood Group: {donor.bloodGroup}</p>
      <p>City: {donor.city}</p>
      <p>Phone: {donor.phone}</p>
    </div>
  );
}

export default DonorProfile;
