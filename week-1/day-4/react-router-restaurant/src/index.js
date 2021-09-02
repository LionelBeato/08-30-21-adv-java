import React, { Component } from 'react';
import ReactDOM from 'react-dom';
// import './index.css';
// import App from './App';
import reportWebVitals from './reportWebVitals';
import {
  BrowserRouter as Router,
  Route,
  Link
} from 'react-router-dom';

/*
  Home is our "home" page. Below we will be making components that will behave
  like traditional html pages. 
*/
class Home extends Component {
  render() {
    return (
      <div>
        <h1>React Router Restaurant</h1>
        <h4>Serving up URLS like Momma use to make!</h4>
        <img src="https://i0.wp.com/68.media.tumblr.com/159d31bca61108d5bd1a8dedf5c14dfe/tumblr_otlasg917I1ql7xb0o6_1280.gif?" />
      </div>
    )
  }
}

class About extends Component {
  render() {
    return (
      <div>
        <h1>About Us</h1>
        <p>We here at the Triple-R love fresh URLs, especially ones tied to awesome React Components.</p>
        <p>It's even better when you can switch between those URLs with ease and share them with friends and family</p>
      </div>
    )
  }
}

class Menu extends Component {
  render() {
    return (
      <div>
        <h1>Menu</h1>
        <p>Check out our amazing 24/7 menu:
          <ul>
            <li>Lazy Loading</li>
            <li>Dynamic Route Matching</li>
            <li>Location Transition Handling</li>
          </ul>
        </p>
      </div>
    )
  }
}

class Navbar extends Component {
  render() {
    return (
      <div className="nav">
        <Link to="/">Home</Link> |
        <Link to="menu">Menu</Link> |
        <Link to="about">About</Link>
      </div>
    )
  }
}

class Routes extends Component {
  render() {
    return (
      <Router>
        <div>
          <Navbar />
          <hr />
          <Route name="Home" exact path="/" component={Home} />
          <Route name="Menu" exact path="/menu" component={Menu} />
          <Route name="About" exact path="/about" component={About} />
        </div>
      </Router>
    )
  }
}

ReactDOM.render(
  <React.StrictMode>
    <Routes />
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
