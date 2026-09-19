import React from "react";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import Home from "./pages/Home";
import MyTripLists from "./pages/MyTripLists";
import AddResort from "./pages/AddResort";

function App() {
  return (
    <BrowserRouter>
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
        <Link className="navbar-brand ms-4 nav-link" to="/">Home</Link>
        <Link className="nav-link" to="/my-trip-lists">My Trip Lists</Link>
        <Link className="nav-link" to="/add-resort">Add Resort</Link>
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