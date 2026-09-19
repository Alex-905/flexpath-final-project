import React, { useState, useEffect } from "react";

function Home() {
  const [resorts, setResorts] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/resorts")
      .then((response) => response.json())
      .then((data) => setResorts(data));
  }, []);

  return (
  <div>
    <h1>Ski Resorts</h1>
    <div className="container">
      {resorts.map((resort) => (
        <div key={resort.id} className="card mb-3 p-3">
          <h3>{resort.resortName}</h3>
          <p>{resort.location}</p>
          <p>{resort.description}</p>
        </div>
      ))}
    </div>
  </div>
);
}

export default Home;

