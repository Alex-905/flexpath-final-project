import React, { useState, useEffect } from "react";

function MyTripLists() {
  const [tripLists, setTripLists] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/triplists")
      .then((response) => response.json())
      .then((data) => setTripLists(data));
  }, []);

  return (
    <div className="container">
      <h1>My Trip Lists</h1>
      {tripLists.map((tripList) => (
        <div key={tripList.id} className="card mb-3 p-3">
          <h3>{tripList.tripList}</h3>
          <p>{tripList.description}</p>
        </div>
      ))}
    </div>
  );
}

export default MyTripLists;