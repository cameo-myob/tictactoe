import React from 'react';

export default function Tile({token}) {
    return (
        <button className="tile">
        {token}
        </button>
    );
}