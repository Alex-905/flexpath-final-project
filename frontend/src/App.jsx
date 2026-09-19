import React from "react";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import Home from "./pages/Home";
import MyTripLists from "./pages/MyTripLists";
import AddResort from "./pages/AddResort";

function App() {
  return (
    <BrowserRouter>
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
  <div className="container-fluid">
    <Link className="navbar-brand ms-4" to="/">Home</Link>
    <div className="navbar-nav flex-row gap-3">
      <Link className="nav-link" to="/my-trip-lists">My Trip Lists</Link>
      <Link className="nav-link" to="/add-resort">Add Resort</Link>
    </div>
  </div>
</nav>
      <hr />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/my-trip-lists" element={<MyTripLists />} />
        <Route path="/add-resort" element={<AddResort />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;