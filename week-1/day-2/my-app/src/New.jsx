import React, {useState, useEffect} from 'react';

const New = () => {

    const [count, setCount] = useState(0); 
    const [hamburgers, setHamburgers] = useState(0); 

    const handleClick = () => {
        setCount(count+1); 
    }

    useEffect(() => {
        console.log("Component did mount");
    },[])

    useEffect(() => {
        console.log("Component did update");
    })

    const handleDivClick = (event) => {
        console.log("Handle Click", event.target); 
    }

    const handleInput = (event) => {
        console.log("Handle Input", event.target.value); 
    }

    return (
        <div>
            <div>{count}</div>
            <button onClick={handleClick}>
                </button> 

                <div onClick={handleDivClick}>Clickable Div</div>
                <input onInput={handleInput}></input>
        </div>
    )

}

export default New; 