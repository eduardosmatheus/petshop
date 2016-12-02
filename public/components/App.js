import React, { Component } from 'react'
import { Link } from 'react-router'
import Modal from './Modal'

export default class App extends Component {
  constructor(props){
    super(props)
  }

  render() {
    let {children} = this.props
    return (
      <div className="boards">
        <h2 className="app-title title is-2"><Link to="/"><i className="fa fa-home fa-5x"></i></Link> Íbex Petshop Manager</h2>
        <div className="applicationContainer">{ children }</div>
        <Modal/> 
      </div>
    );
  }
}
