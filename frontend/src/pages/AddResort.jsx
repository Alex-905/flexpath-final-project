import React, { useState } from "react";

function AddResort() {
  const [resortName, setResortName] = useState("");
  const [location, setLocation] = useState("");
  const [description, setDescription] = useState("");

  function handleSubmit(event) {
    event.preventDefault();

    const newResort = {
      username: "user",
      resortName: resortName,
      location: location,
      description: description,
      base: 0,
      vertDrop: 0,
      avgSnow: 0,
      diffLevel: "Mixed",
      isPub: true,
    };

    fetch("http://localhost:8080/api/resorts", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(newResort),
    }).then(() => {
      alert("Resort added!");
    });
  }

  return (
    <div className="container">
      <h1>Add a Resort</h1>
      <form onSubmit={handleSubmit}>
        <input
          placeholder="Resort Name"
          value={resortName}
          onChange={(e) => setResortName(e.target.value)}
        />
        <input
          placeholder="Location"
          value={location}
          onChange={(e) => setLocation(e.target.value)}
        />
        <input
          placeholder="Description"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
        />
        <button type="submit">Add Resort</button>
      </form>
    </div>
  );
}

export default AddResort;