import React, { Component } from 'react';
import Welcome from '../Welcome/Welcome';
import PlayerForm from '../Player/PlayerForm';
import Board from './Board';


class Game extends Component {
    state = {
        board: [["", "", ""],["", "", ""],["", "", ""]]
    }

    addMove(x,y){
        const url = `${process.env.REACT_APP_LOCAL_SERVER}/addmove`
        const body = {
            x,
            y,
        }

        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(body)
        })
        .then(res => res.json())
        .then(res => {
            console.log(res)
            document.getElementById(`${x},${y}`).setAttribute("disabled", "disabled")
            this.setState({board: res.board})
        })
    }

    addNewPlayer(name, token){
        const url = `${process.env.REACT_APP_LOCAL_SERVER}/addplayer`
        const body = {
            name,
            token
        }

        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(body)
        })
        .then(res => console.log(res.json()))
        .catch(err => console.error(err))
    }

    render() {
        return(
            <div className="game">
                <PlayerForm addNewPlayer={this.addNewPlayer.bind(this)}/>
                <Board board={this.state.board} addMove={this.addMove.bind(this)}/>
            </div>
        )
    }
}

export default Game;