import React from "react";

export const Movie = ({ title, releaseDate, synopsis }) => {
  const style = {
    card: {
      minHeight: "20em",
    },
    title: {
      fontSize: "1.5em",
    },
  };

  return (
    <div className="card" style={style.card}>
      <header>
        <p className="card-header-title" style={style.title}>
          {title}
        </p>
      </header>

      <div className="card-image">
        <figure className="image">
          <img
            src="https://via.placeholder.com/270x400"
            alt="Placeholder image"
          />
        </figure>
      </div>
      <div className="card-content">
        <div className="content">{releaseDate}</div>
        <div className="content">{synopsis}</div>
      </div>
    </div>
  );
};
