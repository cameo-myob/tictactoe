import React, { Component } from 'react';
import Welcome from '../Welcome/Welcome';
import PlayerForm from '../Player/PlayerForm';
import Board from './Board';

class Game extends Component {
    render() {
        return(
            <div className="game">
                {/* <Board/> */}
                <PlayerForm/>
            </div>
        )
    }
}

export default Game;