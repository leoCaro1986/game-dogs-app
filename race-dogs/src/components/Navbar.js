import React from 'react'
import { Link } from 'react-router-dom'

export const Navbar = () => (
  <nav className="navbar navbar-dark bg-dark">
    <img src ="/logoDogsText.png" alt="icon" style={{maxWidth:200, padding:0}} />
    <section ClassName="btn-group">
      <Link to="/" ClassName="btn btn-primary"> Home </Link>
    </section>
  </nav>
)
