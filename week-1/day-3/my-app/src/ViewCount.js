import React, { Component } from 'react';

export default class ViewCount extends Component {
    constructor(props) {
        super(props);
        // this.state = { count: 0 };
    }

    render() {
        return (
            <div>{this.props.count}</div>
        )
    }
}