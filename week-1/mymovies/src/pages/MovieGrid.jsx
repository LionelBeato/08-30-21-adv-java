import React from "react";
import { Collection } from "../components/Collection";

const movies90s = [
  {
    title: "Jurassic Park",
    image: "",
    synopsis:
      "A pragmatic paleontologist visiting an almost complete theme park is tasked with protecting a couple of kids after a power failure causes the park's cloned dinosaurs to run loose.",
    releaseDate: "199X",
  },
  {
    title: "The Lost World: Jurassic Park",
    image: "",
    synopsis:
      "A research team is sent to the Jurassic Park Site B island to study the dinosaurs there, while an InGen team approaches with another agenda.    ",
    releaseDate: "199X",
  },
  {
    title: "Se7en",
    image: "",
    synopsis:
      "Two detectives, a rookie and a veteran, hunt a serial killer who uses the seven deadly sins as his motives.    ",
    releaseDate: "199X",
  },
];

const MovieGrid = () => {
  return (
    <div className="section">
      <div className="container">
        <Collection name="Movies from the 90s" movies={movies90s} />
        <Collection name="Other titles" />
      </div>
    </div>
  );
};

export default MovieGrid;
