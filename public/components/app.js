import React, { Component } from 'react'

export default class App extends Component {
  constructor(props){
    super(props)
  }

  render() {
    console.log(this.props);
    return (
      <div className="boards">
      Teste
        {this.props.children}
      </div>
    );
  }
}
