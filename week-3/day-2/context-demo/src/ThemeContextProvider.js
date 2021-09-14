import React, { Component } from "react";
const { Provider, Consumer } = React.createContext();

class ThemeContextProvider extends Component {

    state = {
        theme: "Day"
    };


    // this method is just simply switching the state for "day" to "night"
    toggleTheme = () => {
        this.setState(prevState => {
            return {
                theme: prevState.theme === "Day" ? "Night" : "Day"
            };
        });
    }

    render() {
        // here we pass down our state and methods to our provider from React Context
        return <Provider value={{ theme: this.state.theme, toggleTheme: this.toggleTheme }}
        >{this.props.children}</Provider>
    }
}

export { ThemeContextProvider, Consumer as ThemeContextConsumer };