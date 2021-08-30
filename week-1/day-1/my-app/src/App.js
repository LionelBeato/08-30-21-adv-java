import logo from './logo.svg';
import './App.css';
import Welcome from './Welcome';
import FunctionalComponent from './FunctionalComponent';
import WelcomeClass from './WelcomeClass';

function App() {

  const element = <h2>This is JSX (or psuedo-html)</h2>;
  const character = 'bart';
  const simpsons = <h2>homer, lisa, marge, maggie, {character} </h2>;


  return (
    <div>
      <h1>Hello from React!</h1>
      <Welcome name="LeVar Burton" />
      <WelcomeClass name="Jimmy" />
      {/* <header></header>
      <main></main>
      <footer></footer> */}
      {element}
      {simpsons}
      <FunctionalComponent name="Jeff"/>
    </div>
  );
}

export default App;
