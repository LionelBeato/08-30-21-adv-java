import React, { useState } from "react";

// we will be using react hooks to provide this function
// with a state
const FunctionalComponent = ({ name }) => {
  const [state, setState] = useState(0);

  return (
    <main>
      <h1>Hello from a functional component!</h1>
      <h2>Happy to meet you, {name}</h2>
      <p>{state}</p>
      <button onClick={() => setState(state + 1)}>Add</button>
      <button onClick={() => setState(state - 1)}>Subtract</button>
    </main>
  );
};

export default FunctionalComponent;
