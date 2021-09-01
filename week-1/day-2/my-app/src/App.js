import logo from './logo.svg';
import React from 'react';
import './App.css';
import New from './New';

class App extends React.Component {

  constructor() {
    super();
    this.state = {
      name: "Bart",
    }
  }

  shouldComponentUpdate() {
    console.log("Should component update");
  }

  componentDidMount() {
    console.log("Component did mount"); 
  }

  componentDidUpdate() {
    console.log("Component did update");
  }

  componentWillUnmount() {
    console.log("Component will unmount");
  }

  render() {
    return (
      <div>{this.state.name}
        <New />
      </div>
    )
  }

}

export default App;
