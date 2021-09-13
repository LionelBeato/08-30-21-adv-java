import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import StateCounter from './StateCounter';
import ReduxCounter from './ReduxCounter';
import reportWebVitals from './reportWebVitals';
import { Provider } from 'react-redux';
import { createStore } from 'redux';

const initialState = {
  count: 0
}

function reducer(state = initialState, action) {
  switch(action.type) {
    case 'INCREMENT':
      return {
        count: state.count + 1
      };
    case 'DECREMENT':
      return {
        count: state.count - 1
      };
    default:
      return state; 
  }
}

const store = createStore(reducer);

ReactDOM.render(
  <Provider store={store}>
    <ReduxCounter />
  </Provider>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
