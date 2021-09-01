import React from "react";
import { Movie } from "./Movie";

export const Collection = ({ name, movies }) => {
  return (
    <div>
      {movies.map((movie) => (
        <Movie title={movie.title} releaseDate={movie.releaseDate} />
      ))}
    </div>
  );
};

Collection.defaultProps = {
  name: "Collection Name",
  movies: [],
};
