import React from "react";
import logo from "./logo.svg";
import "./App.css";
import { GitHubRepository, GitHubSearchResultType } from "./Types/GitHub";
import axios from "axios";
import SearchForm from "./Components/SearchForm";
import ListRepositories from "./Components/ListRepositories";

/*
  This project is based on the following tutorial: 
  https://blog.logrocket.com/typescript-react-and-create-react-app-leveraging-the-power-of-types/
*/
function App() {
  // typescript assigns a type to a variable
  // on the moment of declaration, dependent on the value
  // this is known as type inference
  let helloWorld = "hello world";
  // the following line should be immediately detected as illegal
  // helloWorld = 3;

  // this represents my state utilizing the state hook
  // note the multiple generic types!
  const [repositories, setRepositories] =
    React.useState<Array<GitHubRepository>>();

  // this method performs the actual search with axios
  async function search(query: string) {
    const result = await axios.get<GitHubSearchResultType>(
      `https://api.github.com/search/repositories?q=${query}`
    );
    setRepositories(result.data.items);
  }

  return (
    <div>
      <SearchForm search={search} />
      <ListRepositories repositories={repositories} />
    </div>
  );
}

export default App;
