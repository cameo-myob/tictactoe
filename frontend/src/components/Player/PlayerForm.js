import React, { Component } from 'react';

class PlayerForm extends Component {

    addNewPlayer(name, token){
        const url = `${process.env.REACT_APP_LOCAL_SERVER}/addplayer`
        
        fetch(url, {
            method: 'POST',
            body: JSON.stringify(name, token),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            }
        })
        .then(res => console.log(res.json()))
        .catch(err => console.error(err))
    }

    render(){
        return (
            <form onSubmit={(e) => {
                e.preventDefault()
                const form = e.target.elements
                const name = form.name.value
                const token = form.token.value
                if(name === '' || token === ''){
                    alert('Please enter your name and token')
                    return;
                }
                this.addNewPlayer(name, token)

            }}>
                <label htmlFor="name">Player Name:</label>
                <input type="text" name="name"/>
                <label htmlFor="token">Player Token:</label>
                <input type="text" name="token"/><br/>
                <button className="grey-button">Submit</button>
            </form>
        );
    }
}

export default PlayerForm;