import React, { Component } from 'react'
import { Link } from 'react-router'

export default class App extends Component {
  constructor(props){
    super(props)
  }

  render() {
    let {children} = this.props
    return (
      <div className="boards">
        <h1><Link to="/"><i className="fa fa-home" aria-hidden="true"></i></Link> Íbex Petshop Manager</h1>
        {children}
      </div>
    );
  }
}
