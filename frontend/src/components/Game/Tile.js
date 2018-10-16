import React from 'react';

export default function Tile({postMove, token, x, y}) {
    return (
        <button className="tile" id={`${x},${y}`} onClick={(e)=>{
            e.preventDefault();
            postMove(x,y)
        }}>
        {token.match(/\S/) ? token : "."}
        </button>
    );
}