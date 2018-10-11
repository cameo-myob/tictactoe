import React, { Component } from 'react';

class Welcome extends Component {
    render(){
        return (
            <div className="welcome">
                <h1>Welcome to Tic Tac Toe!</h1>
                <button className="grey-button" onClick={()=>{this.props.startGame()}}>Start Game</button>
            </div>
        );
    }
}

export default Welcome;