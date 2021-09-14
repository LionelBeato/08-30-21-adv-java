import React from "react";
import Button from "./Button";
import { ThemeContextConsumer } from "./ThemeContextProvider"

// class Image extends React.Component {
//     render() {
//         const theme = this.context;
//         return (
//             <div className={`${theme}-image image`}>
//                 <div className={`${theme}-ball ball`} />
//                 <Button />
//             </div>
//         );
//     }
// }


function Image(props) {
    return (
        // here we provide a ThemeContextConsumer to allow this component
        // the ability to consume our context
        <ThemeContextConsumer>
            {context => (
                <div className={`${context.theme}-image image`}>
                    <div className={`${context.theme}-ball ball`} />
                    <Button />
                </div>
            )}
        </ThemeContextConsumer>
    )
}

Image.contextType = ThemeContextConsumer;


export default Image;