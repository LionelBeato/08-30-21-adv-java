import logo from './logo.svg';
import './App.css';
import PetStore from './PetStore';
import IncrButton from './IncrButton';
import ViewCount from './ViewCount';
import React, { useState } from 'react';
import Activity from './Activity';


function App() {

  const [count, setCount] = useState(0);

  let data = [
    {
      name: "Mr. Burns",
      location: "Springfield",
    },
    {
      name: "Marge Simpson",
      location: "Springfield",
    },
  ]

  let elements = data.map((person, index) =>
    <li key={index}>Name: {person.name} Location: {person.location}</li>
  )

  const handleIncrButton = () => {
    setCount(count + 1)
  }



  return (
    <div>
      <ul>
        {elements}
      </ul>
      <br></br>
      <PetStore />
      <ViewCount count={count} />
      <IncrButton handleIncrButton={handleIncrButton} />
      <br></br>
      <hr></hr>
      <Activity />
    </div>
  );
}

export default App;
