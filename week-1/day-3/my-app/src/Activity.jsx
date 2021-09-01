import React, { useEffect, useState } from "react";

const Activity = () => {
  // I want to load API information when this component mounts

  const [state, setState] = useState({ activity: "do nothing" });

  useEffect(() => {
    handleClick() 
  }, []);

  const handleClick = () => {
    fetch("https://www.boredapi.com/api/activity")
    .then((response) => response.json())
    .then((json) => setState(json));
  }

  return (
    <div>
      <h3>{state.activity}</h3>
      <button onClick={handleClick}>Press Me for New Activity</button>
    </div>
  );
};

export default Activity;
