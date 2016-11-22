import React, { Component } from 'react'
import { Link } from 'react-router'

export default class App extends Component {
  constructor(props){
    super(props)
  }


  render() {
    let { pet, openModal } = this.props
    return (
      <div className="column is-one-third area-item animal-card">
        <div className="card is-fullwidth">
          <div className="card-content">
            <div className="media">
              <div className="media-content">
                <h1>  { pet.name }     </h1>
                <p>   { pet.customer.name }</p>
              </div>
            </div>
            <br/>
            <div className="content">
              {pet.obs && <blockquotes> { pet.obs } </blockquotes>}
              <br/>
              <br/>
              <medium>{ pet.especie.name }</medium>
              <br/>
              <small>Nascimento:<strong> {pet.birth } </strong> </small>
            </div>
          </div>
          <footer className="card-footer">
            <a className="card-footer-item">Edit</a>
            <a className="card-footer-item">Delete</a>
          </footer>
        </div>
      </div>
    );
  }
}
