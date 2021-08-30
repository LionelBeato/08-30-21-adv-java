import React from "react";

// below in Welcome.jsx, we are defining props
// props is a js object and as such can be destructured
// I prefer this method but passing props plainly is fine too
function Welcome({name}) {
  return (
    <div>
        {/* <h1>blah</h1> */}
      <h1>Hello, {name}</h1>
    </div>
  );
}

export default Welcome;
