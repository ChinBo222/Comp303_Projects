import React, { useState, useEffect } from "react";

function DonorProfile() {
    const [donor, setDonor] = useState(null);
    const [isLoading, setIsLoading] = useState(true);
    const [updatedDonor, setUpdatedDonor] = useState({
        firstName: "",
        lastName: "",
        age: "",
        bloodGroup: "",
        city: "",
        phone: "",
        email: "",
    });

    useEffect(() => {
        const donorId = localStorage.getItem("donorId");

        if (donorId) {
            // Fetch donor profile using the logged-in donor ID
            fetch(`http://localhost:8083/api/donors/${donorId}`)
                .then((response) => {
                    if (!response.ok) {
                        throw new Error("Profile not found");
                    }
                    return response.json();
                })
                .then((data) => {
                    setDonor(data);
                    setUpdatedDonor(data); // Set the fetched data to the state for editing
                    setIsLoading(false);
                })
                .catch((error) => {
                    console.error("Error fetching donor profile:", error);
                    setIsLoading(false);
                });
        } else {
            console.error("No donor ID found");
            setIsLoading(false);
        }
    }, []);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setUpdatedDonor({
            ...updatedDonor,
            [name]: value,
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        const donorId = localStorage.getItem("donorId");

        // Send updated donor details to the API when editing
        fetch(`http://localhost:8083/api/donors/${donorId}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(updatedDonor),
        })
            .then((response) => response.json())
            .then((data) => {
                setDonor(data);
                alert("Profile updated successfully!");
            })
            .catch((error) => {
                console.error("Error updating donor profile:", error);
            });
    };

    if (isLoading) {
        return <div>Loading...</div>;
    }

    if (!donor) {
        return <div>Profile not found</div>;
    }

    return (
        <div>
            <h2>Donor Profile</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <strong>First Name:</strong>
                    <input
                        type="text"
                        name="firstName"
                        value={updatedDonor.firstName}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <strong>Last Name:</strong>
                    <input
                        type="text"
                        name="lastName"
                        value={updatedDonor.lastName}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <strong>Age:</strong>
                    <input
                        type="number"
                        name="age"
                        value={updatedDonor.age}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <strong>Blood Group:</strong>
                    <input
                        type="text"
                        name="bloodGroup"
                        value={updatedDonor.bloodGroup}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <strong>City:</strong>
                    <input
                        type="text"
                        name="city"
                        value={updatedDonor.city}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <strong>Phone:</strong>
                    <input
                        type="text"
                        name="phone"
                        value={updatedDonor.phone}
                        onChange={handleChange}
                    />
                </div>
                <div>
                    <strong>Email:</strong>
                    <input
                        type="email"
                        name="email"
                        value={updatedDonor.email}
                        onChange={handleChange}
                    />
                </div>

                <div>
                    <button type="submit">Save Changes</button>
                </div>
            </form>
        </div>
    );
}

export default DonorProfile;
