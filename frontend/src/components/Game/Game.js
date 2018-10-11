import React, { Component } from 'react';
import Welcome from '../Welcome/Welcome';
import PlayerForm from '../Player/PlayerForm';

class Game extends Component {
    state = {
        board: [["", "", ""], ["", "", ""], ["", "", ""]],
        gameRunning: false,
        players: [],
    }

    startGame = () => {
        this.setState({
            gameRunning: true,
        })
    }

    addPlayer = (player) => {
        this.setState({
            
        })
    }
    render() {
        return(
            <div className="game">
                {this.state.gameRunning ? <PlayerForm /> : <Welcome startGame={this.startGame}/>}
            </div>
        )
    }
}

export default Game;

{/* <Board board={this.state.board}/> */}