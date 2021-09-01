import logo from './logo.svg';
import './App.css';
import PetStore from './PetStore';

function App() {

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

  return (
    <div>
      <ul>
        {elements}
      </ul>
      <br></br>
      <PetStore />
    </div>
  );
}

export default App;
