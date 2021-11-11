import React from 'react'
import { Link } from 'react-router-dom'


const HomePage = ({children}) => (
  <section>
    <h1>Home</h1>
    <div>
      {children}
    </div>
    <div>
        <p>Bienvenid@ a la mejor carrera de perros</p>
    </div>
    <Link to="/Game" className="button">
      Crear Juego
    </Link>
  </section>
)
export default HomePage