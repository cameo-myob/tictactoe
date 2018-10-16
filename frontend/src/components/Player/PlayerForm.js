import React from 'react';

export default function PlayerForm({addNewPlayer}){
    return (
        <form onSubmit={(e) => {
            e.preventDefault()
            const form = e.target.elements
            const name = form.name.value
            const token = form.token.value
            if(name === '' || token === ''){
                alert('Please enter your name and token')
                return;
            }
            addNewPlayer(name, token)
            document.querySelector("form").reset();
            document.getElementById("player-title").innerText = "Please enter details for Player 2:";
        }}>
            <h3 id="player-title">Please enter details for Player 1:</h3>
            <label htmlFor="name">Player Name:</label>
            <input type="text" name="name"/>
            <label htmlFor="token">Player Token:</label>
            <input type="text" name="token"/><br/>
            <button className="grey-button">Submit</button>
        </form>
    );
}