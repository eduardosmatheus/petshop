import React, { Component } from 'react'

export default class App extends Component {
  constructor(props){
    super(props)
  }

  render() {
    let {children} = this.props
    return (
      <div className="boards">
        {children}
      </div>
    );
  }
}
