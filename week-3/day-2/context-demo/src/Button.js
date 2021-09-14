import React from 'react';
import { ThemeContextConsumer } from "./ThemeContextProvider"

// we assign the onClick prop to the value of our toggleTheme method
// provided by our React Context from ThemeContextProvider
function Button(props) {
    return (
        <ThemeContextConsumer>
            {context => (
                <button onClick={context.toggleTheme} className="button">
                    Switch
                    <span role="img" aria-label="sun">
                        🌞
                    </span>
                    <span role="img" aria-label="moon">
                        🌚
                    </span>
                </button>
            )}
        </ThemeContextConsumer>
    )
}

export default Button;