import React from 'react';
import Tile from './Tile';

export default function Board({board, addMove}) {
    
    return (
        <div className="board">
            <div className="row">
                <Tile postMove={addMove} token={board[0][0]} x={1} y={1}/>
                <Tile postMove={addMove} token={board[0][1]} x={1} y={2}/>
                <Tile postMove={addMove} token={board[0][2]} x={1} y={3}/>
            </div>
            <div className="row">
                <Tile postMove={addMove} token={board[1][0]} x={2} y={1}/>
                <Tile postMove={addMove} token={board[1][1]} x={2} y={2}/>
                <Tile postMove={addMove} token={board[1][2]} x={2} y={3}/>
            </div>
            <div className="row">
                <Tile postMove={addMove} token={board[2][0]} x={3} y={1}/>
                <Tile postMove={addMove} token={board[2][1]} x={3} y={2}/>
                <Tile postMove={addMove} token={board[2][2]} x={3} y={3}/>
            </div>
        </div>
    );
}