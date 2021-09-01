import logo from './logo.svg';
import './App.css';
import { Collection } from './components/Collection';
import { useState, useEffect } from 'react';

const movies90s = [
  {
    title: "Jurassic Park",
    releaseDate: "199X",
  },
  {
    title: "The Lost World: Jurassic Park",
    releaseDate: "199X",
  },
]

function App() {

  // const [movies, setMovies] = useState([]);


  // useEffect(() => { setMovies(movies90s) }, [])

  return (
    <div>
      <Collection name="Movies from the 90s" movies={movies90s} />
      <Collection name="Other titles" />
    </div>
  );
}

export default App;
