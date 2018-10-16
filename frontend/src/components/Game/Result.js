import React from 'react';

export default function Result({result}) {
    return(
        <div className="result">
            <h2>{result.status}</h2>
            <h3>{result.message}</h3>
        </div>
    )
}