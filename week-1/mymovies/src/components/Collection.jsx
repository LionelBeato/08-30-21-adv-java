import React from "react";
import { Movie } from "./Movie";

export const Collection = ({ name, movies }) => {
  return (
    <div className="columns">
      {movies.map((movie) => (
        <div className="column">
          <Movie
            title={movie.title}
            releaseDate={movie.releaseDate}
            synopsis={movie.synopsis}
          />
        </div>
      ))}
    </div>
  );
};

Collection.defaultProps = {
  name: "Collection Name",
  movies: [],
};
