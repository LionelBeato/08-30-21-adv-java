import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => {
  const style = {
    input: {
      backgroundColor: "#f5f5f5",
    },
    appName: {
      fontSize: "1.75em",
      fontWeight: "bold",
    },
  };

  return (
    <nav className="navbar p-5" role="navigation" aria-label="main navigation">
      <div className="navbar-brand">
        <div className="navbar-item">
          <Link to="/" style={style.appName}>
            MOVIES APP
          </Link>
        </div>
      </div>
      <div className="navbar-start">
        <div className="navbar-item">
          <Link to="/about">About</Link>
        </div>
      </div>
      <div className="navbar-end">
        <div className="navbar-item">
          <input
            className="input is-rounded"
            type="text"
            placeholder="Text input"
            style={style.input}
          ></input>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
