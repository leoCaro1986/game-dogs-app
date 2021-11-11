import React from 'react'
import { Link } from 'react-router-dom'

const Game = () => {
    return (
        <div className="container mt-5">
            <h1>Game</h1>
            <form >
            <h1>Game</h1>
                <div className="col-auto border-">
                    <label htmlFor="type">Type</label>
                    <select name="type" id="type"  >
                        <option value="OPEN (LONG OPEN BOX)">OPEN (LONG OPEN BOX)</option>
                        <option value="OPINION (SHORT OPEN BOX)">OPINION (SHORT OPEN BOX)</option>
                        <option value="WITH RESULT (OPEN BOX WITH LINK)">WITH RESULT (OPEN BOX WITH LINK)</option>
                        
                    </select>
                </div>
                <div>
                    <label htmlFor="category">Category</label>
                    <select name="category" id="category" >
                        <option value="TECHNOLOGY AND COMPUTER">TECHNOLOGY AND COMPUTER</option>
                        <option value="SCIENCES">SCIENCES</option>
                        <option value="SOFTWARE DEVELOPMENT">SOFTWARE DEVELOPMENT</option>
                        <option value="SOCIAL SCIENCES">SOCIAL SCIENCES</option>
                        <option value="LANGUAGE">LANGUAGE</option>
                    </select>
                </div>
                
                <button type="submit" className="button btn btn-primary"  >
                    
                </button>
                
            </form>
             
        </div>

    )
}

export default Game;
