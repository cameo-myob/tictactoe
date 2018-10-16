import React, { Component } from 'react';
import PlayerForm from '../Player/PlayerForm';
import Board from './Board';
import Result from './Result';


class Game extends Component {
    state = {
        board: [["", "", ""],["", "", ""],["", "", ""]],
        result: null,
        players: [],
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
            document.getElementById(`${x},${y}`).setAttribute("disabled", "disabled")
            this.setState({
                board: res.board,
                result: res,
            })
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
        .then(res => res.json())
        .then(res => {
            this.setState({
                players: this.state.players.concat(res.token)
            })
        })
        .catch(err => console.error(err))
    }

    render() {
        return(
            <div className="game">
                {this.state.result ? <Result result={this.state.result}/> : ""}
                {this.state.players.length < 2 ? <PlayerForm addNewPlayer={this.addNewPlayer.bind(this)}/> : <Board board={this.state.board} addMove={this.addMove.bind(this)}/>}
            </div>
        )
    }
}

export default Game;