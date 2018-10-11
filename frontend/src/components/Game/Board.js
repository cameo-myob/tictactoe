import React from 'react';
import Tile from './Tile';

export default function Board({board}) {
    return (
        <div className="board">
            <div className="row">
                <Tile token={board[0][0]}/>
                <Tile token={board[0][1]}/>
                <Tile token={board[0][2]}/>
            </div>
            <div className="row">
                <Tile token={board[1][0]}/>
                <Tile token={board[1][1]}/>
                <Tile token={board[1][2]}/>
            </div>
            <div className="row">
                <Tile token={board[2][0]}/>
                <Tile token={board[2][1]}/>
                <Tile token={board[2][2]}/>
            </div>
        </div>
    );
}